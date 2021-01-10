package net.etfbl.kovid.models;

import net.etfbl.kovid.util.Generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class House implements Serializable {
    private Coord coord;
    private String uuid;
    private ArrayList<Person> residents;
    private boolean containsAdult;

    public House(Coord coord, String uuid) {
        this.coord = coord;
        this.uuid = uuid;
        this.residents = new ArrayList<Person>();
    }

    public House(Coord coord) {
        this.coord = coord;

        this.uuid = Generator.generateUuid();
        this.residents = new ArrayList<Person>();
        this.containsAdult = false;
    }

    public House() {

    }

    public boolean isContainsAdult() {
        return containsAdult;
    }

    public void setContainsAdult(boolean containsAdult) {
        this.containsAdult = containsAdult;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public ArrayList<Person> getResidents() {
        return residents;
    }

    public void setResidents(ArrayList<Person> residents) {
        this.residents = residents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return coord.equals(house.coord) && uuid.equals(house.uuid) && residents.equals(house.residents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coord, uuid, residents);
    }

    @Override
    public String toString() {
        return "House{" +
                "coord=" + coord +
                ", uuid='" + uuid + '\'' +
                ", residents=" + residents +
                '}';
    }

    public boolean addResident(Person p) {
        try {
            this.residents.add(p);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public Integer getNumberOfResidents(){
        return residents.size();
    }




}
