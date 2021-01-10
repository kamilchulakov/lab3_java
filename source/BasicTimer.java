import java.util.Random;

public class BasicTimer implements Timer{
    private Season season;

    public BasicTimer() {
        System.out.printf("%s", ConsoleColors.RESET);
        System.out.println("_________________________________________________");
        System.out.printf("%s", ConsoleColors.BLUE_BACKGROUND);
        this.setSeason(Season.WINTER);
    }

    public BasicTimer(String parameter) {
        if (parameter.equalsIgnoreCase("random")) {
            Random random = new Random();
            Season[] seasons = new Season[] {Season.WINTER, Season.SPRING, Season.SUMMER, Season.AUTUMN};
            season = seasons[random.nextInt(seasons.length)];
            process();
        }
        else {
            System.out.printf("%s", ConsoleColors.RESET);
            System.out.println("_________________________________________________");
            System.out.printf("%s", ConsoleColors.BLUE_BACKGROUND);
            this.setSeason(Season.WINTER);
        }
    }

    @Override
    public Season getSeason() {
        return season;
    }

    public void printCurrentSeason() {
        System.out.printf("Текущее время года: %s.%n", getSeason().toString());
    }

    @Override
    public void setSeason(Season season) {
        this.season = season;
        printCurrentSeason();
    }

    @Override
    public void process() {
        System.out.printf("%s", ConsoleColors.RESET);
        System.out.println("_________________________________________________");
        if (getSeason() == Season.WINTER) {
           System.out.printf("%s", ConsoleColors.GREEN_BACKGROUND);
           setSeason(Season.SPRING);
       }
       else if (getSeason() == Season.SPRING) {
           System.out.printf("%s", ConsoleColors.RED_BACKGROUND);
           setSeason(Season.SUMMER);
       }
       else if (getSeason() == Season.SUMMER) {
           System.out.printf("%s", ConsoleColors.YELLOW_BACKGROUND);
           setSeason(Season.AUTUMN);
       }
       else {
           System.out.printf("%s", ConsoleColors.BLUE_BACKGROUND);
           setSeason(Season.WINTER);
       }

    }

}
