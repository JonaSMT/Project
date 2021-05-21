package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import msm.data.FileUtils;
import msm.data.Instrument;
import msm.data.InstrumentManagement;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class ModifyInstrumentFX implements Initializable, FileUtils {
    @FXML
    private Button btnModify;
    @FXML
    private TextField txtModify2;
    @FXML
    private Button btnSave;
    @FXML
    private TextField txtModify;
    @FXML
    private ListView<String> listInstruments;
    String name;
    String name1;
    int count = 0;
    boolean correct = true;
    String[] parts;
    List<String> data = new ArrayList<>();
    BufferedReader file = null;
    PrintWriter file2 = null;

    public void writeData(String name, List<String> list){
        try {
            file2  = new PrintWriter (name);
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
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("No data found");
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);
        for (String d:data) {
            listInstruments.getItems().addAll(d);
        }
    }

    public void showName(MouseEvent mouseEvent) {
        name = listInstruments.getSelectionModel().getSelectedItem();
        txtModify.setText(name);
    }

    public void save(ActionEvent actionEvent) {
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);
        count = 0;

        name1 = txtModify2.getText();
        try{
            for (int i = 0; i < name.length(); i++) {
                if (name.charAt(0) == ' ')
                    name = name.replace(" ", "");
            }
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Can't save with no data");
            alert.showAndWait();
        }

        parts = name.split(":");
        parts[0] = name1;
        String aux = "";
        aux = parts[0] + ":" + parts[1];

        char[] aux2 = aux.toCharArray();

        aux2[0] = Character.toUpperCase(aux2[0]);
        name1 = "";
        aux = "";
        for (int i = 0; i < aux2.length; i++){
            aux += aux2[i];
        }
        name1 = aux;

        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).contains(name1)) {
                correct = false;
            }
            if (!data.get(i).contains(name))
                count++;
            if (data.get(i).contains(name) && correct) {
                data.set(count, name1);
            }
        }
            if (!correct) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Instrument already exist");
                alert.showAndWait();
            }
            if (correct) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Information");
                alert.setContentText("Instrument correctly updated");
                alert.showAndWait();
            }
            writeData("instruments.txt", data);
        listInstruments.getItems().setAll();
        for (String d:data) {
            listInstruments.getItems().addAll(d);
        }
    }

    public void close(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnSave.getScene().getWindow();
        stage.close();
    }


}
