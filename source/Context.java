import java.util.LinkedList;
import java.util.List;

public class Context {
    private Strategy strategy;
    private List<Character> characters = new LinkedList<Character>();

    public Context() {
        this.basicInit();
    }

    private void basicInit() {
        Troll troll = new Troll("Муми-тролль");
        Mumrik mumrik = new Mumrik("Снусмумрик");

        troll.addFriend(mumrik);
        mumrik.addFriend(troll);

        characters.add(troll);
        characters.add(mumrik);
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void process() {
        strategy.execute(characters);
    }
}
