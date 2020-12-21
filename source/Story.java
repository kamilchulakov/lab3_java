import java.util.ArrayList;
import java.util.Collections;

public final class Story implements Runnable{
    private ArrayList<Character> characters = new ArrayList<Character>();
    private Character main;
    private Season season;

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void addCharacters(Character[] characters) {
        Collections.addAll(this.characters, characters);
    }

    public void printCharactersInfo() {
        for (Character character: characters
             ) {
            System.out.println(character.getInfo());
        }
    }

    public void setMain(Character character) {
        main = character;
    }

    public void setSeason(Season season2) {
        season = season2;
    }

    public void nextSeason() {
        season = Season.values()[(season.ordinal() + 1) % 4 ];
        System.out.printf("Пришл%s %s. %n", season.getString().charAt(season.getString().length() - 1),season.getString());
    }

    public void addMainCharacter() {
        Troll mommie = new Troll("Муми-тролль");
        setMain(mommie);
    }

    public void addSnusmumrik() {
        Mumrik snus = new Mumrik("Снусмумрик");
        addCharacter(snus);
        addFriendForMain(snus);
    }

    public void addFrekenSnork() {
        Troll freken = new Troll("Фрекен Снорк");
        freken.setSex("female");
        addCharacter(freken);
        addFriendForMain(freken);
    }

    public void addFriendForMain(Character character) {
        main.addFriend(character);
        character.addFriend(main);
        System.out.println(character.getInfo());
    }

    public void seasonalActions() {
        main.seasonAction(season);
        for (Character character: characters
             ) {
            character.seasonAction(season);
        }
    }

    public void main_run(int i) {
        addMainCharacter();
        addSnusmumrik();
        addFrekenSnork();
        setSeason(Season.AUTUMN);
        for (int j = 0; j < i; j++) {
            nextSeason();
            seasonalActions();
        }
        System.out.println("The end.");
    }

    @Override
    public void run() {
        main_run(3);
    }
}

