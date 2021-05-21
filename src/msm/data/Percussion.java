package msm.data;

public class Percussion extends Instrument{

    public Percussion(){

    }
    public Percussion(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ":" + "(" + "Percussion" + ")";
    }
}
