package msm.data;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class manage Band objects
 */
public class BandManagement implements FileUtils{

    private List<Band> bands;
    private PrintWriter file2 = null;
    private BufferedReader file = null;

    /**
     * This constructor initialize a Band list
     */
    public BandManagement() {
        this.bands = new ArrayList<>();
    }

    /**
     * Obtains a list of Band objects
     * @return Band objects
     */
    public List<Band> getBands() {
        return bands;
    }

    /**
     * Estabish a list of Band objects
     * @param bands list of Band objects
     */
    public void setBands(List<Band> bands) {
        this.bands = bands;
    }

    /**
     * This method read a file text
     * @param name name of file text
     * @param list name of list
     */
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

    /**
     * This method write on file text
     * @param name name of file text
     * @param list2 name of list
     */
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

    /**
     * Add a Band object on Band list
     * @param b Band object
     */
    public void addBand(Band b) {
        bands.add(b);
    }


    /**
     * Show all content of Band list
     * @return content of Band list
     */
    public List<String> showAll() {
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);
        return data;
    }

    /**
     * Show only one type of bands: Main Band
     * @return list Main Band
     */
    public List<String> showMainBand(){

        List<String> mainBand = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);

        for (String d : data) {
            if (!mainBand.contains(d) && d.contains("(Main Band)")) {
                mainBand.add(d);
            }
        }
        return mainBand;
    }

    /**
     * Show only one type of bands: Jazz Group
     * @return list Jazz Group
     */
    public List<String> showJazzGroup(){

        List<String> jazzGroup = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);

        for (String d : data) {
            if (!jazzGroup.contains(d) && d.contains("(Jazz Group)")) {
                jazzGroup.add(d);
            }
        }
        return jazzGroup;
    }

    /**
     * Show only one type of bands: Clarinets Ensemble
     * @return list Clarinets Ensemble
     */
    public List<String> showClarinetsEnsemble(){

        List<String> clarinetsEnsemble = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);;

        for (String d : data) {
            if (!clarinetsEnsemble.contains(d) && d.contains("(Clarinets Ensemble)")) {
                clarinetsEnsemble.add(d);
            }
        }
        return clarinetsEnsemble;
    }

    /**
     * Show only one type of bands: Metal Ensemble
     * @return list Metal Ensemble
     */
    public List<String> showMetalEnsemble(){

        List<String> metalEnsemble = new ArrayList<>();
        List<String> jazzGroup = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);

        for (String d : data){
            if (!metalEnsemble.contains(d) && d.contains("(Metal Ensemble)")) {
                metalEnsemble.add(d);
            }
        }
        return metalEnsemble;
    }

    /**
     * Show only one type of bands: Percussion Ensemble
     * @return list Percussion Ensemble
     */
    public List<String> showPercussionEnsemble(){

        List<String> percussionEnsemble = new ArrayList<>();
        List<String> data = new ArrayList<>();
        readData("bands.txt", data);

        for (String d : data) {
            if (!percussionEnsemble.contains(d) && d.contains("(Percussion Ensemble)")) {
                percussionEnsemble.add(d);
            }
        }
        return percussionEnsemble;
    }

    /**
     * Calculate a total pay
     * @param performance quantity of performance
     * @param amount quantity of amount
     * @return total pay
     */
    public int calculateTotal(int performance, int amount){
        return performance*amount;
    }

}
