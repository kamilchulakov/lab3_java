public class Troll extends Character{

    public Troll(String name) {
        super(name);
    }

    @Override
    public void winterAction() {
        sleep();
    }

    @Override
    public void springAction() {
        dream();
    }

    @Override
    public void summerAction() {
        wasteTime();
    }

    @Override
    public void autumnAction() {
        goFishing();
    }


    @Override
    public void randomAction() {
        dream();
    }

    public void wasteTime() {
        System.out.println(getName() + " бессмысленно потратил время.");
    }

    public void goFishing() {
        System.out.println(getName() + " сходил на рыбалку.");
    }

    public void sleep() {
        if (getSex().equals("male")) System.out.println(getName() + " погрузился в сон.");
        else System.out.println(getName() + " погрузилась в сон.");
        modHappiness(-getHappiness());
    }
}
