package msm.data;

import java.util.List;

public class WindMetal extends Instrument{

    public WindMetal(){

    }

    public WindMetal(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return name + ":" + "(" + "Wind Metal" + ")";
    }

}
