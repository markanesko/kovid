package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Person implements Serializable {
    private String uuid;
    private Name fullName;
    private Date birthDate;
    private Gender gender;
    private String houseUuid;
    private Double temperature;

    public Person(String uuid, Name fullName, Date birthDate, Gender gender, String houseUuid, Double temperature) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.houseUuid = houseUuid;
        this.temperature = temperature;
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

    public Name getFullName() {
        return fullName;
    }

    public void setFullName(Name fullName) {
        this.fullName = fullName;
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
        return uuid.equals(person.uuid) && fullName.equals(person.fullName) && birthDate.equals(person.birthDate) && gender == person.gender && houseUuid.equals(person.houseUuid) && temperature.equals(person.temperature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName, birthDate, gender, houseUuid, temperature);
    }

    @Override
    public String toString() {
        return "Person{" +
                "uuid='" + uuid + '\'' +
                ", fullName=" + fullName +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                ", houseUuid='" + houseUuid + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
