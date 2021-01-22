package project.time;

public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;

    public String toString() {
        if (this == WINTER) return "зима";
        else if (this == SPRING) return "весна";
        else if (this == SUMMER) return "лето";
        else if (this == AUTUMN) return "осень";
        return "неизвестно";
    }
}
