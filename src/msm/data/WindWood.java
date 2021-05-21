package msm.data;

public class WindWood extends Instrument {

    public WindWood(){

    }

    public WindWood(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ":" + "(" + "Wind Wood" + ")";
    }
}
