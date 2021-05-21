package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import msm.data.*;

import javax.crypto.BadPaddingException;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddMemberFX implements Initializable, FileUtils {
    @FXML
    private ComboBox<String> comboShip;
    @FXML
    private ListView<String> listInstruments;
    @FXML
    private ListView<String> listBands;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtDni;
    InstrumentManagement instrumentManagement = new InstrumentManagement();
    BandManagement bandManagement = new BandManagement();
    BufferedReader file = null;
    PrintWriter file2 = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listBands.getItems().setAll(bandManagement.showAll());
        listInstruments.getItems().setAll(instrumentManagement.showAll());
        comboShip.getItems().setAll("Yes", "No");
    }

    public void writeData(String name, List<String> list){
        try {
            file2  = new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
            for (String s:list) {
                file2.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (file2 != null) {
                file2.close();
            }
        }
    }
    public void readData(String name, List<String> list){
        String line = null;
        try {
            file = new BufferedReader(new FileReader(name));
            while ((line = file.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setTitle("Warning");
            alert.setContentText("Has been created a file named \"bands.txt\" ");
            alert.showAndWait();
        } finally {
            if (line != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public void Save(ActionEvent actionEvent) {

        MemberManagement memberManagement = new MemberManagement();
        List<String> data = new ArrayList<>();
        List<String> members = new ArrayList<>();
        String name = txtName.getText();
        int age = 0;
        String dni = "";
        if (name.equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Name can't be empty");
            alert.showAndWait();
            return;
        }
        if (txtDni.getText().length() == 9) {
            dni = txtDni.getText();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("DNI can only have 9 digits or can't be empty");
            alert.showAndWait();
            return;
        }
        String memberShip = comboShip.getSelectionModel().getSelectedItem();
        try {
            age = Integer.parseInt(txtAge.getText());
            if (age > 100 || age < 0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Age can be 1 - 99");
                alert.showAndWait();
                return;
            }
        }catch (Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Age can only have numbers or can't be empty");
                alert.showAndWait();
                return;
            }
        data.add("");
        readData("members.txt", data);

        Member musician;

        if (listInstruments.getSelectionModel().getSelectedItem() == null || listBands.getSelectionModel().getSelectedItem() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("ERROR");
            alert.setContentText("Bands and Instruments must be selected");
            alert.showAndWait();
            return;
        }else {
            for (int i = 0; i < data.size(); i++) {
                musician = new Musician(name, age, dni, memberShip, listInstruments.getSelectionModel().getSelectedItem(),
                        listBands.getSelectionModel().getSelectedItem());
                memberManagement.addMember(musician);
                data.set(i, "" + memberManagement.getMembers().get(i));
            }
        }

        for (String d : data) {
            if (!members.contains(d)) {
                members.add(d);
            }
        }
            writeData("members.txt", members);
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnSave.getScene().getWindow();
        stage.close();
    }

}
