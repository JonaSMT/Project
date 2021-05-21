package msm.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import msm.data.InstrumentManagement;
import msm.data.WindMetal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShowInstrumentsFX {
    @FXML
    private RadioButton metal;
    @FXML
    private RadioButton wood;
    @FXML
    private RadioButton percussion;
    @FXML
    private RadioButton all;
    @FXML
    private ListView<String> listInstruments;
    @FXML
    InstrumentManagement instrumentManagement = new InstrumentManagement();


    public void showWindMetal(ActionEvent actionEvent) {
        if(metal.isSelected()) {
            wood.setSelected(false);
            percussion.setSelected(false);
            all.setSelected(false);

            listInstruments.getItems().setAll(instrumentManagement.showWindMetal());
        }
        if (!metal.isSelected()){
            listInstruments.getItems().setAll();
        }
    }

    public void showWindWood(ActionEvent actionEvent) {
        if (wood.isSelected()) {
            metal.setSelected(false);
            percussion.setSelected(false);
            all.setSelected(false);

            listInstruments.getItems().setAll(instrumentManagement.showWindWood());
        }
        if (!wood.isSelected()){
            listInstruments.getItems().setAll();
        }

    }


    public void showPercussion(ActionEvent actionEvent) {
        if (percussion.isSelected()) {
            metal.setSelected(false);
            wood.setSelected(false);
            all.setSelected(false);

            listInstruments.getItems().setAll(instrumentManagement.showPercussion());
        }
        if (!percussion.isSelected()){
            listInstruments.getItems().setAll();
        }
    }

    public void showAllInstruments(ActionEvent actionEvent) {
        if (all.isSelected()) {
            wood.setSelected(false);
            percussion.setSelected(false);
            metal.setSelected(false);
            listInstruments.getItems().setAll(instrumentManagement.showAll());
        }
        if (!all.isSelected()){
            listInstruments.getItems().setAll();
        }
    }
}
