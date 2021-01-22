package project.middleware;

import java.util.List;
import project.character.Character;

public final class WinterStrategy implements Strategy {
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            character.winterAction();
        }
    }
}
