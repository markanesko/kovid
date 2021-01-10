package net.etfbl.kovid.models;

import java.util.Date;

public class Adult extends Person{

    public Adult(String uuid, Name fullName, Date birthDate, Gender gender, String houseUuid, Double temperature) {
        super(uuid, fullName, birthDate, gender, houseUuid, temperature);
    }
}
