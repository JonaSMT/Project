package msm.data;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InstrumentManagement implements FileUtils{
    private List<Instrument> instruments;
    private PrintWriter file2 = null;
    private BufferedReader file = null;

    public InstrumentManagement() {
        this.instruments = new ArrayList<>();
    }

    public List<Instrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<Instrument> instruments) {
        this.instruments = instruments;
    }


    public void readData(String name, List<String> list) {
        String line = null;
        try {
            file = new BufferedReader(new FileReader(name));
            while ((line = file.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e){
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
            file2  = new PrintWriter(new BufferedWriter(new FileWriter(name, false)));
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
    public void addInstrument(Instrument i) {
        instruments.add(i);
    }

    public void deleteInstrument(List<String> list, int index, InstrumentManagement iM){

    }

    public List<String> showAll() {
        List<String> data = new ArrayList<>();
        BufferedReader file = null;
        String line = null;
            readData("instruments.txt", data);
            return data;
    }

    public List<String> showWindMetal(){

        List<String> windMetal = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);

        for (String d : data) {
            if (!windMetal.contains(d) && d.contains("(Wind Metal)")) {
                windMetal.add(d);
            }
        }
        return windMetal;
    }

    public List<String> showWindWood(){

        List<String> windWood = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);

        for (String d : data) {
            if (!windWood.contains(d) && d.contains("(Wind Wood)")) {
                windWood.add(d);
            }
        }
        return windWood;
    }

    public List<String> showPercussion(){
        List<String> percussion = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("instruments.txt", data);

        for (String d : data) {
            if (!percussion.contains(d) && d.contains("(Percussion)")) {
                percussion.add(d);
            }
        }
        return percussion;
    }
}


