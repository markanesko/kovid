package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Person implements Serializable {
    private String uuid;
    private String name;
    private String lastName;
    private Date birthDate;
    private Gender gender;
    private String houseUuid;
    private Double temperature;

    public Person(String uuid, String name, String lastName, Date birthDate, Gender gender, String houseUuid) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.houseUuid = houseUuid;

        this.temperature = initTemperature();

    }

    protected static Double initTemperature() {
        return ThreadLocalRandom.current().nextDouble(36.0, 36.9);
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getHouseUuid() {
        return houseUuid;
    }

    public void setHouseUuid(String houseUuid) {
        this.houseUuid = houseUuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return uuid.equals(person.uuid) && name.equals(person.name) && lastName.equals(person.lastName) && birthDate.equals(person.birthDate) && gender == person.gender && houseUuid.equals(person.houseUuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, lastName, birthDate, gender, houseUuid);
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", houseUuid='" + houseUuid + '\'' +
                '}';
    }
}
