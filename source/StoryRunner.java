public class StoryRunner {
    Timer timer = new BasicTimer();
    Context context = new Context();

    public void process() throws LocationException {
        if (timer.getSeason() == Season.WINTER) {
            context.setStrategy(new WinterStrategy());
        }
        else if (timer.getSeason() == Season.SPRING) {
            context.setStrategy(new SpringStrategy());
        }
        else if (timer.getSeason() == Season.SUMMER) {
            context.setStrategy(new SummerStrategy());
        }
        else {
            context.setStrategy(new AutumnStrategy());
        }
        context.process();
        timer.process();
    }

    public void run(int seasons) throws LocationException {
        for (int i = 0; i < seasons; i++) {
            this.process();
        }
        System.out.println("И вот конец истории.");
    }
}
