package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import msm.data.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddInstrumentFX implements Initializable, FileUtils {

    @FXML
    private Button btnSave;
    @FXML
    private ComboBox<String> comboType;
    @FXML
    private TextField txtNameInstrument;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboType.getItems().addAll("Wind Metal","Wind Wood","Percussion");
    }

    String name;
    char[] aux;

    PrintWriter file2 = null;

    public void writeData(String name, List<String> list2){
        try {
            file2  = new PrintWriter(new BufferedWriter(new FileWriter(name, true)));
            for (String s:list2) {
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

    public void readData(String name,List<String> list){

        BufferedReader file = null;
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
            alert.setContentText("Has been created a file named \"instruments.txt\" ");
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

    public void save() {
        List<String> data = new ArrayList<>();
        List<String> instruments = new ArrayList<>();
        InstrumentManagement instrumentManagement = new InstrumentManagement();
        String type = comboType.getValue();
        data.add("Instruments");
        data.add("");
        readData("instruments.txt", data);
        name = txtNameInstrument.getText();


        if(type == null || name == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Instrument type and name instrument can´t be empty");
            alert.showAndWait();
        }
        else {
            switch (type) {
                case "Wind Metal":
                    Instrument windMetal = new WindMetal();
                    try {
                        aux = name.toCharArray();
                        aux[0] = Character.toUpperCase(aux[0]);
                        name = "";
                    }catch (Exception e){
                        {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Fields can't be empty");
                            alert.showAndWait();
                            return;
                        }
                    }
                    for (int i = 0; i < aux.length; i++) {
                        name += aux[i];
                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).contains(name)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Instrument already exist");
                            alert.showAndWait();
                            return;
                        } else if (!data.get(i).contains(name)) {
                            windMetal = new WindMetal(name);
                            instrumentManagement.addInstrument(windMetal);
                            data.set(i, "" + instrumentManagement.getInstruments().get(i));
                        }
                    }
                    break;

                case "Wind Wood":
                    Instrument windWood = new WindWood();

                    aux = name.toCharArray();
                    aux[0] = Character.toUpperCase(aux[0]);
                    name = "";
                    for (int i = 0; i < aux.length; i++) {
                        name += aux[i];
                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).contains(name)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Instrument already exist");
                            alert.showAndWait();
                            return;
                        } else if (!data.get(i).contains(name)) {
                            windWood = new WindWood(name);
                            instrumentManagement.addInstrument(windWood);
                            data.set(i, "" + instrumentManagement.getInstruments().get(i));
                        }
                    }
                    break;

                case "Percussion":
                    Instrument percussion = new Percussion();

                    aux = name.toCharArray();

                    for (int i = 1; i < aux.length; i++) {
                        aux[i] = Character.toLowerCase(aux[i]);
                    }

                    aux[0] = Character.toUpperCase(aux[0]);

                    name = "";
                    for (int i = 0; i < aux.length; i++) {
                        name += aux[i];
                    }
                    for (int i = 0; i < data.size(); i++) {
                        if (data.get(i).contains(name)) {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setHeaderText(null);
                            alert.setTitle("Error");
                            alert.setContentText("Instrument already exist");
                            alert.showAndWait();
                            return;
                        } else if (!data.get(i).contains(name)) {
                            percussion = new Percussion(name);
                            instrumentManagement.addInstrument(percussion);
                            data.set(i, "" + instrumentManagement.getInstruments().get(i));
                        }
                    }
                    break;
            }
            for (String d : data) {
                if (!instruments.contains(d)) {
                    instruments.add(d);
                }
            }

            writeData("instruments.txt", instruments);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information");
            alert.setContentText("Instrument correctly added");
            alert.showAndWait();
        }
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnSave.getScene().getWindow();
        stage.close();
    }
}