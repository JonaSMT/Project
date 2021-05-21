package msm.data;

import java.util.*;

public abstract class Member{
    String name;
    int age;
    String dni;
    String memberShip;
    String instrument;
    String band;

    public Member() {
    }

    public Member(String name, int age, String dni, String memberShip, String instrument, String band) {
        this.name = name;
        this.age = age;
        this.dni = dni;
        this.memberShip = memberShip;
        this.instrument = instrument;
        this.band = band;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getMemberShip() {
        return memberShip;
    }

    public void setMemberShip(String memberShip) {
        this.memberShip = memberShip;
    }


}
