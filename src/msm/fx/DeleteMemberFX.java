package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import msm.data.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteMemberFX implements Initializable, FileUtils {

    @FXML
    private ListView<String> listMembers;

    boolean erased = false;
    BufferedReader file = null;
    PrintWriter file2 = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = new ArrayList<>();
        readData("members.txt", data);
        for (String d:data) {
            listMembers.getItems().addAll(d);
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

    public void deleteMember(ActionEvent actionEvent) {
        List<String> data = new ArrayList<>();
        readData("members.txt", data);
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).contains(listMembers.getSelectionModel().getSelectedItem())) {
                data.remove(listMembers.getSelectionModel().getSelectedItem());
                writeData("members.txt",data);
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
        listMembers.getItems().setAll();
        for (String d:data) {
            listMembers.getItems().add(d);
        }
    }


}
