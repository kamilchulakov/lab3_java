package project.explorable;

import java.util.ArrayList;

public class Street implements Explorable{
    private Location location;
    private String name;
    private ArrayList<House> houses = new ArrayList<>();

    public Street(String s, Location location) {
        name = s;
        this.location = location;
    }

    public void setHouse(House house) {
        houses.add(house);
    }

    public ArrayList<House> getHouses() {
        return houses;
    }

    @Override
    public String explore() {
        return null;
    }

    @Override
    public String toString() {
        return name;
    }
}
