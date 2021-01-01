import java.util.List;

public class SpringStrategy implements Strategy{
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            character.springAction();
        }
    }
}
