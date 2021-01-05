import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Character {
    private String name;
    private ArrayList<Character> friends = new ArrayList<Character>();
    private int happiness = 0;
    private Location location;
    private String sex = "male";

    protected Character(String name) {
        this(Location.MOMMIE_DOL, name);
    }

    protected Character() {
        this(Location.MOMMIE_DOL,"Character");
    }

    protected Character(Location location, String name) {
        setName(name);
        setLocation(location);
    }

    public void setName(String name) {
        this.name = name;
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

    public Character getRandomFriend() {
        Random random = new Random();
        return friends.get(random.nextInt(friends.size()));
    }

    public void setLocation(Location location) {
        this.location = location;
        //System.out.printf("Место нахождения %s изменилось на %s!%n", getName(), getLocation());
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
        return Objects.hash(name, friends, happiness, sex);
    }

    public abstract void winterAction();

    public abstract void springAction() throws LocationException;

    public abstract void summerAction();

    public abstract void autumnAction();

    public abstract void randomAction() throws LocationException;
}
