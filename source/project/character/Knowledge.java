package project.character;

import project.explorable.*;

import java.util.ArrayList;

public class Knowledge {
    private ArrayList<Explorable> explored = new ArrayList<>();
    private ArrayList<Street> exploredStreets = new ArrayList<>();
    //private ArrayList<Thing>
    private final House policeOffice = new House(null, new Street("Зелёная улица", Location.MOMMIE_DOL));

    public House getPoliceOffice() {
        return policeOffice;
    }

    public void add(Explorable explorable) {
        if (explorable instanceof Street) exploredStreets.add((Street) explorable);
        explored.add(explorable);
    }
    public Street getStreet() {
        return exploredStreets.get(0);
    }


}
