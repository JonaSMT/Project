package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import msm.data.Band;
import msm.data.BandManagement;
import msm.data.FileUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShowBandsFX implements FileUtils {
    @FXML
    private RadioButton btnMain;
    @FXML
    private RadioButton btnJazz;
    @FXML
    private RadioButton btnMetal;
    @FXML
    private RadioButton btnClarinets;
    @FXML
    private RadioButton btnPercussion;
    @FXML
    private ListView<String> listBand;
    @FXML
    private RadioButton btnAll;

    BandManagement bandManagement = new BandManagement();
    BufferedReader file = null;

    public void readData(String name, List<String> list){
        String line = null;
        try {
            file = new BufferedReader(new FileReader(name));
            while ((line = file.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
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

    public void showAll(ActionEvent actionEvent) {
        btnPercussion.setSelected(false);
        btnClarinets.setSelected(false);
        btnJazz.setSelected(false);
        btnMain.setSelected(false);
        btnMetal.setSelected(false);
        if(btnAll.isSelected()){
            listBand.getItems().setAll(bandManagement.showAll());
        }
        if (!btnAll.isSelected()){
            listBand.getItems().setAll();
        }
    }

    public void showMainBand(ActionEvent actionEvent) {
        btnPercussion.setSelected(false);
        btnClarinets.setSelected(false);
        btnJazz.setSelected(false);
        btnAll.setSelected(false);
        btnMetal.setSelected(false);
        if (btnMain.isSelected()) {
            listBand.getItems().setAll(bandManagement.showMainBand());
        }
        if (!btnMain.isSelected()){
            listBand.getItems().setAll();
        }
    }

    public void showJazzGroup(ActionEvent actionEvent) {
        btnPercussion.setSelected(false);
        btnClarinets.setSelected(false);
        btnAll.setSelected(false);
        btnMain.setSelected(false);
        btnMetal.setSelected(false);
        if (btnJazz.isSelected()) {
            listBand.getItems().setAll(bandManagement.showJazzGroup());
        }
        if (!btnJazz.isSelected()){
            listBand.getItems().setAll();
        }
    }

    public void showMetalEnsemble(ActionEvent actionEvent) {
        btnPercussion.setSelected(false);
        btnClarinets.setSelected(false);
        btnAll.setSelected(false);
        btnMain.setSelected(false);
        btnJazz.setSelected(false);
        if (btnMetal.isSelected()){
            listBand.getItems().setAll(bandManagement.showMetalEnsemble());
        }
        if (!btnMetal.isSelected()){
            listBand.getItems().setAll();
        }
    }

    public void showClarinetsEnsemble(ActionEvent actionEvent) {
        btnPercussion.setSelected(false);
        btnMetal.setSelected(false);
        btnAll.setSelected(false);
        btnMain.setSelected(false);
        btnJazz.setSelected(false);
        if (btnClarinets.isSelected()){
            listBand.getItems().setAll(bandManagement.showClarinetsEnsemble());
        }
        if (!btnClarinets.isSelected()){
            listBand.getItems().setAll();
        }
    }

    public void showPercussionEnsemble(ActionEvent actionEvent) {
        btnClarinets.setSelected(false);
        btnMetal.setSelected(false);
        btnAll.setSelected(false);
        btnMain.setSelected(false);
        btnJazz.setSelected(false);
        if (btnPercussion.isSelected()){
            listBand.getItems().setAll(bandManagement.showPercussionEnsemble());
        }
        if (!btnPercussion.isSelected()){
            listBand.getItems().setAll();
        }
    }

}
