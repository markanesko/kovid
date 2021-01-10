package net.etfbl.kovid.models;

import java.util.Date;

public class Adult extends Person{
    public Adult(String uuid, String name, String lastName, Date birthDate, Gender gender, String houseUuid) {
        super(uuid, name, lastName, birthDate, gender, houseUuid);
    }
}
