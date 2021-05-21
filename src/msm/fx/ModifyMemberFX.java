package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import msm.data.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ModifyMemberFX implements Initializable, FileUtils {
    @FXML
    private ComboBox<String> comboPaid;
    @FXML
    private ListView<String> listInstruments;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtAge;
    @FXML
    private TextField txtDni;
    @FXML
    private TextField txtPaid;
    @FXML
    private TextField txtInstrument;
    @FXML
    private TextField txtRehearsal;
    @FXML
    private TextField txtPerformance;
    @FXML
    private ListView<String> listMembers;

    BufferedReader file = null;
    PrintWriter file2 = null;
    String numbers;
    String[] parts;
    String numbers2;
    int count = 0;
    String type;
    String[] types;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = new ArrayList<>();
        readData("members.txt", data);

        for (String d:data) {
            d = d.replaceAll("\\s{2,}", " ");
            listMembers.getItems().addAll(d);
        }
        comboPaid.getItems().addAll("Yes", "No");

        List<String> instruments = new ArrayList<>();
        readData("instruments.txt", instruments);
        for (String i:instruments) {
            listInstruments.getItems().addAll(i);
        }



    }

    public void writeData(String name, List<String> list){
        try {
            file2  = new PrintWriter(name);
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

    public void confirmSelection(MouseEvent actionEvent) {

        numbers = listMembers.getSelectionModel().getSelectedItem();
        type = listMembers.getSelectionModel().getSelectedItem();

        if(numbers == null)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Select some option");
            alert.showAndWait();
            return;
        }

        types = type.split(":");
        listInstruments.getSelectionModel().select(types[9] + ":" + types[10]);
        //if(types.length == 22) {
            txtName.setText(types[1]);
            txtAge.setText(types[3]);
            txtDni.setText(types[5]);
            comboPaid.setValue(types[7]);
            txtRehearsal.setText(types[12]);
            txtPerformance.setText(types[14]);
            txtAmount.setText(types[16]);
            System.out.println(types.length);
        //}
    }


    public void update(ActionEvent actionEvent) {
        List<String> data = new ArrayList<>();
        List<String> members = new ArrayList<>();
        readData("members.txt", data);

        for (String d:data) {
            d = d.replaceAll("\\s{2,}", " ");
            members.add(d);
        }

        String name;
        int age;
        String dni;
        String paid;
        String instrument;
        int rehearsal;
        int performance;
        int amount;
        int total;

            if (txtName.getText().equals("")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("ERROR");
                alert.setContentText("Name can't be empty");
                alert.showAndWait();
                return;
            }else {
                name = txtName.getText();
            }
            try {
                age = Integer.parseInt(txtAge.getText());;
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
            paid = comboPaid.getSelectionModel().getSelectedItem();
            instrument = listInstruments.getSelectionModel().getSelectedItem();
            try {
                rehearsal = Integer.parseInt(txtRehearsal.getText());
                performance = Integer.parseInt(txtPerformance.getText());
                amount = Integer.parseInt(txtAmount.getText());
            }catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Only you can insert numbers");
                alert.showAndWait();
            return;
             }

        total = performance*amount;
        String rehearsalS = rehearsal+"";
        String performanceS = performance+"";
        String amountS = amount+"";
        String totalS = total+"";
        String ageS = age+"";

        System.out.println(types.length);

        //if(types.length == 22) {
            types[1] = name;
            types[3] = ageS;
            types[5] = dni;
            types[7] = paid;
            types[9] = instrument;
            types[10] = "";
            types[12] = rehearsalS;
            types[14] = performanceS;
            types[16] = amountS;
            types[18] = totalS;
        //}

        String aux = "";
        numbers2 = "";
        for (int i = 0; i < types.length; i++){
            aux = aux.replaceAll(":{2,}", ":");
            if (i <= 20) {
                aux += types[i] + ":";
            }
        }
        numbers2 = aux;
        for (int i = 0; i < members.size(); i++) {
            if (!members.get(i).contains(numbers)) {
                count++;
            }
            if (members.get(i).contains(numbers)) {
                data.set(count, numbers2);
            }
        }

        for (String d:data) {
            System.out.println(d);
        }
        count = 0;

        writeData("members.txt", data);
        listMembers.getItems().setAll();
        for (String d:data) {
            d = d.replaceAll("\\s{2,}", " ");
            listMembers.getItems().addAll(d);
        }

    }
}
