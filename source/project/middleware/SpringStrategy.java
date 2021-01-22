package project.middleware;

import project.explorable.DifferentHouseException;

import java.util.List;
import project.character.Character;

public final class SpringStrategy implements Strategy {
    @Override
    public void execute(List<Character> characters) {
        for (Character character: characters) {
            try {
                character.springAction();
            } catch (DifferentHouseException differentHouseException) {
                character.dream();
            }
        }
    }
}
