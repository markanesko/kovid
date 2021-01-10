package net.etfbl.kovid.controllers;

import net.etfbl.kovid.models.City;

public class CitySingleton {
    private City city;
    private final static CitySingleton INSTANCE = new CitySingleton();

    private CitySingleton() {}

    public static CitySingleton getInstance() {
        return INSTANCE;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
