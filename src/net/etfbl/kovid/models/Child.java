package net.etfbl.kovid.models;

import java.time.Period;
import java.util.Date;



public class Child extends Person{

    private static final int LOW = 0;
    private static final int HIGH = 18;

    public Child(String uuid, Name fullName, Date birthDate, Gender gender, String houseUuid) {
        super(uuid, fullName, birthDate, gender, houseUuid);
    }

    public Child(String houseUuid) {
        super(houseUuid);
    }
}
