package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.ArrayList;
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

    private ArrayList<House> houseList;
    private ArrayList<Child> childrenList;
    private ArrayList<Adult> adultList;
    private ArrayList<Elder> elderList;
    // control
    // ambulance

    public City(Integer numChildren, Integer numAdults, Integer numElders, Integer numHouses, Integer numControlPoints, Integer numAmbulanceVehicles) {
        this.numChildren = numChildren;
        this.numAdults = numAdults;
        this.numElders = numElders;
        this.numHouses = numHouses;
        this.numControlPoints = numControlPoints;
        this.numAmbulanceVehicles = numAmbulanceVehicles;

        width = height = ThreadLocalRandom.current().nextInt(LOW, HIGH);
        System.out.println(width);

        this.houseList = new ArrayList<>();
        this.childrenList = new ArrayList<>();
        this.adultList = new ArrayList<>();
        this.elderList = new ArrayList<>();

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
        this.generateHouses();
        this.generateControlPoints();
        this.generateElders();
        this.generateAdults();
        this.generateChildren();
    }

    private void generateHouses() {
        for (int i = 0; i < this.numHouses; i++) {
            Coord houseCoord = Coord.getRegularCoord(width);
            while (this.cityMatrix.get(houseCoord).isOccupied()){
                houseCoord = Coord.getRegularCoord(width);
            }
            House newHouse = new House(houseCoord);
            this.houseList.add(newHouse);
            this.cityMatrix.replace(houseCoord, new CityItem(newHouse, true));
        }
    }

    private void generateControlPoints() {
        for (int i = 0; i < this.numControlPoints; i++) {
            Coord controlCoord ;
            do {
                controlCoord = Coord.getRegularCoord(width);
            } while (this.cityMatrix.get(controlCoord).isOccupied());

            // add control point class
        }
    }

    private void generateElders() {
        for (int i = 0; i < this.numElders; i++) {
            Coord elderCoord;
            do {
                elderCoord = Coord.getRegularCoord(width);
            } while (this.cityMatrix.get(elderCoord).isOccupied());

            House randomHouse = this.houseList.get(ThreadLocalRandom.current().nextInt(0, this.houseList.size()));
            Elder newElder = new Elder(randomHouse.getUuid());
            randomHouse.addResident(newElder);
            this.cityMatrix.replace(elderCoord, new CityItem(newElder, true));
        }
    }

    private void generateAdults(){
        for (int i = 0; i < this.numAdults; i++) {
            Coord adultCoord;
            do {
                adultCoord = Coord.getRegularCoord(width);
            } while (this.cityMatrix.get(adultCoord).isOccupied());


            House randomHouse = this.houseList.get(ThreadLocalRandom.current().nextInt(0, this.houseList.size()));
            Adult newAdult = new Adult(randomHouse.getUuid());
            randomHouse.addResident(newAdult);
            randomHouse.setContainsAdult(true);
            this.cityMatrix.replace(adultCoord, new CityItem(newAdult, true));
        }
    }

    private void generateChildren() {
        for (int i = 0; i < this.numAdults; i++) {
            Coord childCoord;
            do{
                childCoord = Coord.getRegularCoord(width);
            } while (this.cityMatrix.get(childCoord).isOccupied());
            House randomHouse;
            do {
                randomHouse = this.houseList.get(ThreadLocalRandom.current().nextInt(0, this.houseList.size()));
            } while (!randomHouse.isContainsAdult());

            Child newChild = new Child(randomHouse.getUuid());
            randomHouse.addResident(newChild);
            this.cityMatrix.replace(childCoord, new CityItem(newChild, true));

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
