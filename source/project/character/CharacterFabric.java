package project.character;

import project.explorable.House;
import project.explorable.Location;
import project.explorable.Street;

import java.util.ArrayList;

public class CharacterFabric {
    public ArrayList<Character> getBasicCharacters() {
        ArrayList<Character> arrayList = new ArrayList<>();
        Troll troll = new Troll("Муми-тролль");
        Mumrik mumrik = new Mumrik("Снусмумрик");
        Troll troll2 = new Troll("Фрекен Снорк", "female");

        troll.addFriend(mumrik);
        troll.addFriend(troll2);
        troll2.addFriend(troll);
        mumrik.addFriend(troll);

        Street street = new Street("Центральная улица", Location.MOMMIE_DOL);
        Street street1 = new Street("Солнечная улица", Location.MOMMIE_DOL);
        Street street2 = new Street("Приозёрная улица", Location.LAKE);


        House house1 = new House(troll, street);
        House house2 = new House(troll2, street1);
        house2.closeDoor();
        House house3 = new House(mumrik, street2);
        house3.closeDoor();

        troll.setHouse(house1);
        troll2.setHouse(house2);
        mumrik.setHouse(house3);

        troll.setStreet(street);
        troll2.setStreet(street);
        mumrik.setStreet(street);

        troll.explore(street1);
        troll.explore(street2);
        troll2.explore(street);
        troll2.explore(street2);
        mumrik.explore(street);
        mumrik.explore(street1);

        arrayList.add(troll);
        arrayList.add(troll2);
        arrayList.add(mumrik);

        return arrayList;
    }
}
