import java.util.List;

public final class SpringStrategy implements Strategy{
    @Override
    public void execute(List<Character> characters) throws LocationException {
        for (Character character: characters) {
            character.springAction();
        }
    }
}
