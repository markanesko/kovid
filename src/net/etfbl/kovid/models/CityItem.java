package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.Objects;

public class CityItem implements Serializable {
    private Object item;
    private boolean occupied;

    public CityItem(Object item, boolean occupied) {
        this.item = item;
        this.occupied = occupied;
    }

    public CityItem(Object item) {
        this.item = item;
        this.occupied = false;
    }

    public CityItem() {
        this.item = new Object();
        this.occupied = false;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityItem cityItem = (CityItem) o;
        return occupied == cityItem.occupied && item.equals(cityItem.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, occupied);
    }

    @Override
    public String toString() {
        return "CityItem{" +
                "occupied=" + occupied +
                '}';
    }
}
