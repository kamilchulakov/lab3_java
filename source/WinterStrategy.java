import java.util.List;

public class WinterStrategy implements Strategy{
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            character.winterAction();
        }
    }
}
