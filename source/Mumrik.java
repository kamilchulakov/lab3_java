public class Mumrik extends Character{

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

    public void travel(Location location) {
        if (location == Location.MOMMIE_DOL) System.out.printf("%s вернулся в %s. %n", getName(), location.toString());
        else System.out.printf("%s отправился странствовать на %s. %n", getName(), location.toString());
        //setState(location);
    }

    @Override
    public void randomAction() {
        int a = (int) (Math.random() * 5);
        if (a == 0 | a == 2) impressSomeone();
        else if (a == 4) becomeLost();
        else dream();

    }

    public void becomeLost() {
        System.out.println(getName() + " пропал!");
    }

    public void impressSomeone() {
        System.out.println(getName() + " был на редкость невозмутим и очень много знал, однако никогда не выставлял это напоказ.");
        //setState(getFriend(0));
        tellAStory(getFriend(0));
    }

    public void tellAStory(Character character) {
        System.out.println(getName() + " решил рассказать " + character.getName() + " историю.");
        StoryRunner story = new StoryRunner();
        story.run(4);
        character.modHappiness(50);
    }

}
