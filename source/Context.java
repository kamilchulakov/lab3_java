import java.util.LinkedList;
import java.util.List;

public class Context {
    private Strategy strategy;
    private List<Character> characters;

    public Context() {
        characters = new LinkedList<>();
        this.basicInit();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void process() throws LocationException {
        strategy.execute(characters);
    }

    private void basicInit() {
        Troll troll = new Troll("Муми-тролль");
        Mumrik mumrik = new Mumrik("Снусмумрик");
        Troll troll2 = new Troll("Фрекен Снорк", "female");

        troll.addFriend(mumrik);
        troll.addFriend(troll2);
        troll2.addFriend(troll);
        mumrik.addFriend(troll);


        characters.add(troll);
        characters.add(troll2);
        characters.add(mumrik);
    }
}
