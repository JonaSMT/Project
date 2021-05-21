package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import msm.data.FileUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteInstrumentFX implements Initializable, FileUtils {
    @FXML
    private ListView<String> listDeleteIns;
    @FXML
    private Button btnShowData;
    @FXML
    private Button btnDelete;
    boolean erased = false;
    PrintWriter file2 = null;

    BufferedReader file = null;
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
    public void writeData(String name, List<String> list2){
        try {
            file2  = new PrintWriter(new PrintWriter(new FileWriter(name)));
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);
        for (String d : data) {
            listDeleteIns.getItems().addAll(d);
        }
    }

    public void showInstruments(ActionEvent actionEvent) {

    }

    public void deleteInstrument(ActionEvent actionEvent) {
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).contains(listDeleteIns.getSelectionModel().getSelectedItem())) {
                data.remove(listDeleteIns.getSelectionModel().getSelectedItem());
                writeData("instruments.txt",data);
                erased = true;
            }
        }

        if(erased){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information");
            alert.setContentText("Delete correctly");
            alert.showAndWait();
        }
        listDeleteIns.getItems().setAll();
        for (String d:data) {
            listDeleteIns.getItems().add(d);
        }
    }

}
