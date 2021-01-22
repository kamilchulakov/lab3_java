package project.middleware;

import project.character.Character;
import project.character.CharacterFabric;

import java.util.LinkedList;
import java.util.List;

public class Context {
    private Strategy strategy;
    private List<Character> characters;

    public Context() {
        characters = new LinkedList<>();
        this.basicInit();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void process() {
        strategy.execute(characters);
    }

    private void basicInit() {
        characters.addAll(new CharacterFabric().getBasicCharacters());
    }
}
