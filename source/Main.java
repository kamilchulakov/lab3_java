public class Main {
    public static void main(String[] args) throws LocationException {
        StoryRunner storyRunner = new StoryRunner();
        storyRunner.run(4);
        System.out.printf("%s", ConsoleColors.RESET);
    }
}
