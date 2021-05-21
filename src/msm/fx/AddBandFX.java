package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import msm.data.*;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddBandFX implements Initializable, FileUtils {

    @FXML
    private Button btnAdd;
    @FXML
    private Button btnExit;
    @FXML
    private ChoiceBox<String> boxBand;
    @FXML
    private Label txtType;
    @FXML
    private TextField txtRehearsal;
    @FXML
    private TextField txtPerformance;
    @FXML
    private TextField txtPay;

    int rehearsal;
    int performance;
    int pay;
    String type;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        boxBand.getItems().addAll("Main Band", "Jazz Group", "Clarinets Ensemble", "Metal Ensemble", "Percussion Ensemble");
    }

    public void writeData(String name, List<String> list2){
        PrintWriter file2 = null;
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
    public void addBand(ActionEvent actionEvent){
        List<String> data2 = new ArrayList<>();
        List<String> bands = new ArrayList<>();
        BandManagement bandManagement = new BandManagement();
        String type = boxBand.getValue();

        data2.add("bands");
        data2.add("");
        readData("bands.txt", data2);

        try {
            rehearsal = Integer.parseInt(txtRehearsal.getText());
            performance = Integer.parseInt(txtPerformance.getText());
            pay = Integer.parseInt(txtPay.getText());
        }catch (Exception e){
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("Fields can't be empty or input is invalid");
                alert.showAndWait();
                return;
            }
        }
        switch (type) {
            case "Main Band":
                Band mainBand = new MainBand();
                for (int i = 0; i < data2.size(); i++) {
                    mainBand = new MainBand(rehearsal, performance, pay, bandManagement.calculateTotal(performance, pay));
                    bandManagement.addBand(mainBand);
                    data2.set(i, "" + bandManagement.getBands().get(i));
                }
                break;
            case "Jazz Group":
                Band jazzgroup = new JazzGroup();
                for (int i = 0; i < data2.size(); i++) {
                    jazzgroup = new JazzGroup(rehearsal, performance, pay, bandManagement.calculateTotal(performance, pay));
                    bandManagement.addBand(jazzgroup);
                    data2.set(i, "" + bandManagement.getBands().get(i));
                }
                break;
            case "Clarinets Ensemble":
                Band clarinets = new ClarinetsEnsemble();
                for (int i = 0; i < data2.size(); i++) {
                    clarinets = new ClarinetsEnsemble(rehearsal, performance, pay, bandManagement.calculateTotal(performance, pay));
                    bandManagement.addBand(clarinets);
                    data2.set(i, "" + bandManagement.getBands().get(i));
                }
                break;

            case "Metal Ensemble":
                Band metal = new MetalEnsemble();
                for (int i = 0; i < data2.size(); i++) {
                    metal = new MetalEnsemble(rehearsal, performance, pay, bandManagement.calculateTotal(performance, pay));
                    bandManagement.addBand(metal);
                    data2.set(i, "" + bandManagement.getBands().get(i));
                }
                break;
            case "Percussion Ensemble":
                Band percussion = new PercussionEnsemble();
                for (int i = 0; i < data2.size(); i++) {
                    percussion = new PercussionEnsemble(rehearsal, performance, pay, bandManagement.calculateTotal(performance, pay));
                    bandManagement.addBand(percussion);
                    data2.set(i, "" + bandManagement.getBands().get(i));
                }
                break;
            }

        for (String d : data2) {
            if (!bands.contains(d)) {
                bands.add(d);
            }
        }
            writeData("bands.txt", bands);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setTitle("Information");
            alert.setContentText("Band correctly added");
            alert.showAndWait();
    }

    public void exit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnAdd.getScene().getWindow();
        stage.close();
    }
}

