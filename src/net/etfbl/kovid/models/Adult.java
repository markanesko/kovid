package net.etfbl.kovid.models;

import java.util.Date;

public class Adult extends Person{

    public Adult(String uuid, Name fullName, Date birthDate, Gender gender, String houseUuid) {
        super(uuid, fullName, birthDate, gender, houseUuid);
    }

    public Adult(String houseUuid) {
        super(houseUuid);
    }
}
