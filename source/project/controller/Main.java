package project.controller;
import project.statics.ConsoleColors;

public class Main {
    public static void main(String[] args) {
        StoryRunner storyRunner = new StoryRunner();
        storyRunner.run(4);
        System.out.printf("%s", ConsoleColors.RESET);
    }
}
