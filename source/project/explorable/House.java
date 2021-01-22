package project.explorable;

import project.character.Character;

import java.util.Arrays;
import java.util.Objects;

public class House implements Explorable{
    private Character owner;
    private Street street;
    private Room[] rooms;
    private boolean doorOpen = true;

    public House(Character owner1, Street street1) {
        owner = owner1;
        this.street = street1;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House house = (House) o;
        return doorOpen == house.doorOpen && Objects.equals(owner, house.owner) && Objects.equals(street, house.street) && Arrays.equals(rooms, house.rooms);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(owner, street);
        result = 31 * result + Arrays.hashCode(rooms);
        return result;
    }

    @Override
    public String explore() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("дом %s", owner);
    }
}
