package msm.data;

import java.util.ArrayList;
import java.util.List;

/**
 * This class create a Instrument object
 */
public abstract class Instrument {

    String name;
    List<Instrument> instruments;

    /**
     * This is a empty constructor
     */
    public Instrument() {
    }
    /**
     * This constructor create a Instrument object with name of instrument and initialize
     * a Instrument List
     * @param name name of instrument
     */
    public Instrument(String name) {
        this.name = name;
        this.instruments = new ArrayList<>();
    }

    /**
     * Obtain a name of instrument
     * @return name of instrument
     */
    public String getName() {
        return name;
    }

    /**
     * Establish a name of instrument
     * @param name name of instrument
     */
    public void setName(String name) {
        this.name = name;
    }

}
