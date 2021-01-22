package project.character;

import project.explorable.Location;
import project.explorable.DifferentHouseException;
import project.controller.StoryRunner;

public final class Mumrik extends Character {

    public Mumrik(String name) {
        super(name);
    }

    @Override
    public void winterAction() {
        travel(Location.SOUTH);
    }

    @Override
    public void springAction() {
        travel(Location.MOMMIE_DOL);
    }

    @Override
    public void summerAction() {
        travel(Location.WEST);
    }

    @Override
    public void autumnAction() {
        travel(Location.MOMMIE_DOL);
    }


    @Override
    public void randomAction(){
        int a = (int) (Math.random() * 9);
        if (a == 0 | a == 2)
        {
            try {
                impressSomeone();
            }
            catch (DifferentHouseException differentHouseException) {
                dream();
            }
        }
        else if (a == 4) becomeLost();
        else if (a == 5 | a == 6) visitWalingStreetHouse();
        else dream();

    }

    public void becomeLost() {
        setLocation(Location.NOWHERE);
        System.out.println(getName() + " пропал!");
        getRandomFriend().modHappiness(-50);
    }

    public void impressSomeone() throws DifferentHouseException {
        System.out.println(getName() + " был на редкость невозмутим и очень много знал, однако никогда не выставлял это напоказ.");
        tellAStory(getRandomFriend());
    }

    public void tellAStory(Character character) throws DifferentHouseException {
        if (character.getHouse() != getHouse() | character.isInHouse() | isInHouse()) throw new DifferentHouseException();
        else {
            System.out.println(getName() + " решил рассказать " + character.getName() + " историю.");
            StoryRunner story = new StoryRunner("random");
            story.run(4);
            character.modHappiness(50);
        }
    }

    private void travel(Location location) {
        setLocation(location);
        if (location == Location.MOMMIE_DOL) System.out.printf("%s вернулся в %s. %n", getName(), location.toString());
        else System.out.printf("%s отправился странствовать на %s. %n", getName(), location.toString());
    }

}
