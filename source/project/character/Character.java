package project.character;

import project.explorable.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Character {
    private String name;
    private ArrayList<Character> friends = new ArrayList<>();
    private int happiness = 0;
    private Location location = Location.MOMMIE_DOL;
    private Street street = new Street("Гиблая улица", Location.NOWHERE);;
    private House house = new House(this, street);
    private boolean inHouse = false;
    private String sex = "male";
    private Knowledge knowledge = new Knowledge();

    protected Character(String name) {
        this(Location.MOMMIE_DOL, name);
    }

    protected Character() {
        this(Location.MOMMIE_DOL,"Character");
    }

    protected Character(Location location, String name) {
        setName(name);
        setLocation(location);
        Street street1 = new Street("Гиблая улица", Location.NOWHERE);
        setStreet(street1);
        setHouse(new House(this, street1));
        street1.setHouse(new House(this, street1));

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(House house1) {
        house = house1;
    }

    public void setStreet(Street street) {
        this.street = street;
        knowledge.add(street);
    }

    public String getName() {
        return name;
    }

    public void addFriend(Character character) {
        this.friends.add(character);
    }

    public Character getFriend(int position) {
        return friends.get(position);
    }

    public boolean isInHouse() {
        return inHouse;
    }

    public Character getRandomFriend() {
        Random random = new Random();
        return friends.get(random.nextInt(friends.size()));
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setSex(String sex1) {
        sex = sex1;
    }

    public String getSex() {
        return sex;
    }

    public int getHappiness() {
        return happiness;
    }

    public House getHouse() {
        return house;
    }

    public Street getStreet() {
        return street;
    }

    public void modHappiness(int happy) {
        int before = getHappiness();
        happiness += happy;
        if (happiness > before) System.out.printf("У %s улучшилось настроение!%n", getName());
        else if (happiness < before) System.out.printf("У %s ухудшилось настроение!%n", getName());
    }

    public void dream() {
        if (getSex().equals("female")) System.out.println(getName() + " мечтательно задумалась на долгое время.");
        else System.out.println(getName() + " мечтательно задумался на долгое время.");
    }

    public void walkStreet(Street street) {
        System.out.printf("%s решил прогуляться по %s.%n", getName(), street.toString());
        this.street = street;
        House house1 = street.getHouses().get(0);
        visitHouse(house1);
        visitWalingStreetHouse();
    }

    public void walkExploredStreet() {
        walkStreet(knowledge.getStreet());
    }

    public void visitWalingStreetHouse() {
        ArrayList<House> houses = street.getHouses();
        try {
            House house1 = houses.get(0);
            visitHouse(house1);
        } catch (IndexOutOfBoundsException exception) {
            System.out.printf("%s не увидел на %s домов.%n", getName(), getStreet().toString());
            walkExploredStreet();
        }
    }

    public void visitHouse(House house1) {
        if (!inHouse) {
            System.out.printf("%s решил посетить %s.%n", getName(), house1.toString());
            try {
                goIntoOutHouse(house1);
                explore(house1);
            } catch (ClosedDoorException exception) {
                openDoor(house1);
                try {
                    goIntoOutHouse(house1);
                    explore(house1);
                } catch (ClosedDoorException exception2) {
                    System.out.printf("У %s не получилось зайти в %s.%n", getName(), house1.toString());
                }
            }
        }
    }

    public void explore(Explorable explorable) {
        if (!house.equals(explorable) & !inHouse) {
            int a = (int) (Math.random() * 5);
            System.out.printf("%s ", getName());
            if (a == 0 | a == 2) System.out.print("осмотрел ");
            else if (a == 4) System.out.print("долго разгялдывал ");
            else System.out.print("провёл взглядом по ");
            System.out.printf("%s.%n", explorable.toString());
            knowledge.add(explorable);
        }
    }

    public void openDoor(House house1) {
        if (house1.equals(house)) {
            house1.openDoor();
            System.out.printf("%s открыл входную дверь %s.%n", getName(), house1.toString());
        } else {
            System.out.printf("%s пытался взломать чужую дверь.%n", getName());
            Character character = sameStreetFriend();
            if (character != null) System.out.printf("%s написал заявление на %s", character.getName(), getName());
        }
    }

    public void writeClaim(Character character) {
        visitHouse(knowledge.getPoliceOffice());
        System.out.printf("Написал заявление на %s.%n", getName());
    }

    public void goIntoOutHouse(House house1) throws ClosedDoorException{
        if (house1.isDoorOpen() & !isInHouse()) {
            System.out.printf("%s зашел в %s.%n", getName(), house1.toString());
            inHouse = true;
        }
        else if (house1.isDoorOpen() & isInHouse()) {
            System.out.printf("%s зашел в %s.%n", getName(), house1.toString());
            inHouse = false;
        }
        else throw new ClosedDoorException();
    }

    public Character sameStreetFriend() {
        for (Character character: friends
             ) {
            if (character.getStreet().equals(getStreet())) return character;
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return happiness == character.happiness &&
                Objects.equals(name, character.name) &&
                Objects.equals(friends, character.friends) &&
                Objects.equals(sex, character.sex);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, happiness, sex);
    }

    @Override
    public String toString() {
        return getName();
    }

    public abstract void winterAction();

    public abstract void springAction() throws DifferentHouseException;

    public abstract void summerAction();

    public abstract void autumnAction();

    public abstract void randomAction() throws DifferentHouseException;
}
