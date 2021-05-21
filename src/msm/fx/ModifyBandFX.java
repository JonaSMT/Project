package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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

public class ModifyBandFX implements Initializable, FileUtils {
    @FXML
    private Button btnConfirm;
    @FXML
    private ListView<String> listBand;
    @FXML
    private TextField txtRehearsal;
    @FXML
    private TextField txtPerformance;
    @FXML
    private TextField txtAmount;

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
        readData("bands.txt", data);
        for (String d:data) {
            listBand.getItems().addAll(d);
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

        numbers = listBand.getSelectionModel().getSelectedItem();
        type = listBand.getSelectionModel().getSelectedItem();

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
        txtRehearsal.setText(types[1]);
        txtPerformance.setText(types[3]);
        txtAmount.setText(types[5]);
    }


    public void modifyBand(ActionEvent actionEvent) {
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);

        int rehearsal;
        int performance;
        int amount;
        int total;

        try {
            rehearsal = Integer.parseInt(txtRehearsal.getText());
            performance = Integer.parseInt(txtPerformance.getText());
            amount = Integer.parseInt(txtAmount.getText());
        }catch (NumberFormatException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Only you can insert numbers or fields are empty");
            alert.showAndWait();
            return;
        }

        total = performance*amount;
        String rehearsalS = rehearsal+"";
        String performanceS = performance+"";
        String amountS = amount+"";
        String totalS = total+"";

        types[1] = rehearsalS;
        types[3] = performanceS;
        types[5] = amountS;
        types[7] = totalS;

        String aux = "";
        numbers2 = "";
        for (int i = 0; i < types.length; i++){
            if (i <= 7) {
                aux += types[i] + ":";
            }
        }
        aux += types[8];
        numbers2 = aux;
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).contains(numbers))
                count++;
            if (data.get(i).contains(numbers)) {
                data.set(count, numbers2);
            }
        }
        count = 0;

        writeData("bands.txt", data);
        listBand.getItems().setAll();
        for (String d:data) {
            listBand.getItems().addAll(d);
        }

    }

}
