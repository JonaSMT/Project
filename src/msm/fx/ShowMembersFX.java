package msm.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import msm.data.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShowMembersFX implements Initializable, FileUtils{
    @FXML
    private ListView<String> listMembers;
    String name;
    int age;
    String dni;
    boolean membership;
    String instrument;
    String band;
    List<String> data = new ArrayList<>();
    BufferedReader file = null;
    MemberManagement memberManagement = new MemberManagement();
    InstrumentManagement instrumentManagement = new InstrumentManagement();


    public void readData(String name, List<String> list) {
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
    public void writeData(String name, List<String> list2) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<String> data = new ArrayList<>();
        readData("members.txt", data);
        for (String d:data) {
            listMembers.getItems().addAll(d);
        }

    }
}
