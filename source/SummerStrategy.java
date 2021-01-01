import java.util.List;

public class SummerStrategy implements Strategy{

    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            character.randomAction();
            character.summerAction();
        }
    }
}
