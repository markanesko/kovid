package net.etfbl.kovid.models;

import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Coord implements Serializable {
    private Integer x;
    private Integer y;


    public Coord(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x.equals(coord.x) && y.equals(coord.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coord{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static Coord getRegularCoord(Integer bound) {
        Integer x = ThreadLocalRandom.current().nextInt(1, bound);
        Integer y = ThreadLocalRandom.current().nextInt(1, bound);
        return new Coord(x, y);
    }

    public static Coord getAmbulanceCoord(Integer bound) {
        Integer other = ThreadLocalRandom.current().nextInt(0, bound + 1);
        if (ThreadLocalRandom.current().nextBoolean()){
            if (ThreadLocalRandom.current().nextBoolean()) {
                return new Coord(0, other);
            } else {
                return new Coord(other, 0);
            }
        } else {
            if (ThreadLocalRandom.current().nextBoolean()) {
                return new Coord(bound + 1, other);
            } else {
                return new Coord(other, bound + 1);
            }
        }
    }
}
