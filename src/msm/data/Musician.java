package msm.data;

public class Musician extends Member{
    public Musician(String name, int age, String dni, String memberShip, String instrument, String band) {
        super(name, age, dni, memberShip, instrument, band);
    }

    public Musician() {

    }

    @Override
    public String toString() {
        return "Name:" +  name + ":" + "Age:" + age + ":" + "DNI:" + dni + ":" + "Paid:" + memberShip
                + ":" + "Instrument:" + instrument + ":" + band;
    }

}
