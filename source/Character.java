import java.util.ArrayList;
import java.util.Objects;

public abstract class Character {
    private String name;
    private ArrayList<Character> friends = new ArrayList<Character>();
    private int happiness = 0;
    private String sex = "male";
    private State state = new State();

    protected Character(String name) {
        setName(name);
    }
    protected Character() {
        this("Character");
    }


    public void addFriend(Character character) {
        this.friends.add(character);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getState() {
        return state.toString();
    }

    public Character getFriend(int i) {
        return friends.get(i);
    }

    public int getHappiness() {
        return happiness;
    }

    public void setSex(String sex1) {
        sex = sex1;
    }

    public void setState(Location location){
        String before = getState();
        state.stayAt(location);
        System.out.printf("%s изменил состояние %s на %s.%n", getName(), before, getState());
    }
    public void setState(Character character){
        state.stayNear(character);
    }


    public void modHappiness(int happy) {
        int before = happiness;
        happiness += happy;
        if (happiness > before) System.out.printf("У %s улучшилось настроение!%n", getName());
        else if (happiness < before) System.out.printf("У %s ухудшилось настроение!%n", getName());
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

    public void dream() {
        System.out.println(getName() + " мечтательно задумался на долгое время.");
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, friends, happiness, sex);
    }

    public String getSex() {
        return sex;
    }

    public abstract void winterAction();

    public abstract void springAction();

    public abstract void summerAction();

    public abstract void autumnAction();

    public abstract void randomAction();
}
