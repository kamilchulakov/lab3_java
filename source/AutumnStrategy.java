import java.util.List;

public class AutumnStrategy implements Strategy{
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            character.autumnAction();
        }
    }
}
