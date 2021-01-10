package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class City implements Serializable {
    private static final int LOW = 15;
    private static final int HIGH = 31;

    private Integer numChildren;
    private Integer numAdults;
    private Integer numElders;
    private Integer numHouses;
    private Integer numControlPoints;
    private Integer numAmbulanceVehicles;
    private Integer width;
    private Integer height;

    private HashMap<Coord, CityItem> cityMatrix;

    public City(Integer numChildren, Integer numAdults, Integer numElders, Integer numHouses, Integer numControlPoints, Integer numAmbulanceVehicles) {
        this.numChildren = numChildren;
        this.numAdults = numAdults;
        this.numElders = numElders;
        this.numHouses = numHouses;
        this.numControlPoints = numControlPoints;
        this.numAmbulanceVehicles = numAmbulanceVehicles;

        width = height = ThreadLocalRandom.current().nextInt(LOW, HIGH);
        System.out.println(width);

        this.initCityMatrix();
        this.populateCityMatrix();


    }

    private void initCityMatrix() {
        this.cityMatrix = new HashMap<>();

        for (int i = 0; i <= width; i++) {
            for (int j = 0; j <= height; j++) {
                this.cityMatrix.put(new Coord(i, j), new CityItem());
            }
        }
    }

    private void populateCityMatrix() {
        for (int i = 0; i < this.numHouses; i++) {
            Coord houseCoord = Coord.getRegularCoord(width);
            while (this.cityMatrix.get(houseCoord).isOccupied()){
                houseCoord = Coord.getRegularCoord(width);
            }
            this.cityMatrix.replace(houseCoord, new CityItem(new House(), true));
        }

    }

    public Integer getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(Integer numChildren) {
        this.numChildren = numChildren;
    }

    public Integer getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(Integer numAdults) {
        this.numAdults = numAdults;
    }

    public Integer getNumElders() {
        return numElders;
    }

    public void setNumElders(Integer numElders) {
        this.numElders = numElders;
    }

    public Integer getNumHouses() {
        return numHouses;
    }

    public void setNumHouses(Integer numHouses) {
        this.numHouses = numHouses;
    }

    public Integer getNumControlPoints() {
        return numControlPoints;
    }

    public void setNumControlPoints(Integer numControlPoints) {
        this.numControlPoints = numControlPoints;
    }

    public Integer getNumAmbulanceVehicles() {
        return numAmbulanceVehicles;
    }

    public void setNumAmbulanceVehicles(Integer numAmbulanceVehicles) {
        this.numAmbulanceVehicles = numAmbulanceVehicles;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return numChildren.equals(city.numChildren) && numAdults.equals(city.numAdults) && numElders.equals(city.numElders) && numHouses.equals(city.numHouses) && numControlPoints.equals(city.numControlPoints) && numAmbulanceVehicles.equals(city.numAmbulanceVehicles) && width.equals(city.width) && height.equals(city.height);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numChildren, numAdults, numElders, numHouses, numControlPoints, numAmbulanceVehicles, width, height);
    }

    @Override
    public String toString() {
        return "City{" +
                "numChildren=" + numChildren +
                ", numAdults=" + numAdults +
                ", numElders=" + numElders +
                ", numHouses=" + numHouses +
                ", numControlPoints=" + numControlPoints +
                ", numAmbulanceVehicles=" + numAmbulanceVehicles +
                ", width=" + width +
                ", height=" + height +
                ", cityMatrix=" + cityMatrix +
                '}';
    }
}
