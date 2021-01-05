import java.util.List;

public final class SummerStrategy implements Strategy{
    @Override
    public void execute(List<Character> characters) throws LocationException {
        for (Character character: characters) {
            character.randomAction();
            character.summerAction();
        }
    }
}
