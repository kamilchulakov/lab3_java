package project.character;

import project.explorable.House;
import project.explorable.Location;
import project.explorable.DifferentHouseException;

public class Troll extends Character {

    public Troll(String name) {
        super(name);
    }

    public Troll(String name, String sex) {
        super(name);
        setSex(sex);
    }

    @Override
    public void winterAction() {
        sleep();
    }

    @Override
    public void springAction(){

        try {
            spendTimeWithRandomFriend();
        }
        catch (DifferentHouseException differentHouseException) {
            dream();
        }

    }

    @Override
    public void summerAction() {
        visitWalingStreetHouse();
    }

    @Override
    public void autumnAction() {
        randomAction();
    }


    @Override
    public void randomAction() {
        int a = (int) (Math.random() * 8);
        if (a == 0 | a == 2)
        {
            try {
                spendTimeWithRandomFriend();
            }
            catch (DifferentHouseException differentHouseException) {
                dream();
            }
        }
        else if (a == 4 | a == 5) goFishing();
        else if (a == 6) wasteTime();
        else if (a == 7) visitRandomFriendsHouse();
        else dream();
    }

    public void visitRandomFriendsHouse() {
        House house1 = getRandomFriend().getHouse();
        visitHouse(house1);
    }

    private void wasteTime() {
        if (getSex().equals("male")) System.out.println(getName() + " бессмысленно потратил время как это обычно бывает..");
        else System.out.println(getName() + " бессмысленно потратила время.");
    }

    private void goFishing() {
        setLocation(Location.LAKE);
        if (getSex().equals("male")) System.out.println(getName() + " сходил на рыбалку.");
        else System.out.println(getName() + " сходила половить карасей. Вы знали, что девочки тоже любят ловить рыбу?.");
        setLocation(Location.MOMMIE_DOL);
    }

    private void spendTimeWithRandomFriend() throws DifferentHouseException {
        Character friend = getRandomFriend();
        if (friend.getLocation() != getLocation()) throw new DifferentHouseException();
        else if (getSex().equals("male")) System.out.printf("%s решил провести время с %s.%n", getName(), friend.getName());
        else System.out.printf("%s решила провести время с %s.%n", getName(), friend.getName());
    }

    private void sleep() {
        if (getSex().equals("male")) System.out.println(getName() + " погрузился в сон.");
        else System.out.println(getName() + " погрузилась в сон.");
        modHappiness(-getHappiness());
    }
}
