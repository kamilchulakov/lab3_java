public class Troll extends Character{

    public Troll(String name) {
        super(name);
    }

    @Override
    public void seasonAction(Season season) {
        if (season == Season.WINTER) {
            sleep();
        }
        else if (season == Season.SPRING) wasteTime();
    }

    @Override
    public void randomAction() {
        seasonAction(Season.WINTER);
    }

    public void wasteTime() {
        System.out.print("");
    }



    public void sleep() {
        if (getSex().equals("male")) System.out.println(getName() + " погрузился в сон.");
        else System.out.println(getName() + " погрузилась в сон.");
        modHappiness(-getHappiness());
    }
}
