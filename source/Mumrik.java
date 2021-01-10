import java.util.Random;

public final class Mumrik extends Character{

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
    public void randomAction() throws LocationException {
        int a = (int) (Math.random() * 5);
        if (a == 0 | a == 2)
        {
            try {
                impressSomeone();
            }
            catch (LocationException locationException) {
                dream();
            }
        }
        else if (a == 4) becomeLost();
        else dream();

    }

    public void becomeLost() {
        setLocation(Location.NOWHERE);
        System.out.println(getName() + " пропал!");
        getRandomFriend().modHappiness(-50);
    }

    public void impressSomeone() throws LocationException{
        System.out.println(getName() + " был на редкость невозмутим и очень много знал, однако никогда не выставлял это напоказ.");
        tellAStory(getRandomFriend());
    }

    public void tellAStory(Character character) throws LocationException {
        if (character.getLocation() != getLocation()) throw new LocationException();
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
