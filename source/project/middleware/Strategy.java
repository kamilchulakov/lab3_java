package project.middleware;

import project.character.Character;
import java.util.List;

public interface Strategy {
    void execute(List<Character> characters);
}
