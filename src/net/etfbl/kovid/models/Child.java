package net.etfbl.kovid.models;

import java.time.Period;
import java.util.Date;



public class Child extends Person{

    private static final int LOW = 0;
    private static final int HIGH = 18;

    public Child(String uuid, String name, String lastName, Date birthDate, Gender gender, String houseUuid) {
        super(uuid, name, lastName, birthDate, gender, houseUuid);

        // calculate date with - radnom (0, 18)

    }

}
