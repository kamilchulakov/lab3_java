public enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN;
    String getString() {
        if (this == WINTER) return "зима";
        else if (this == SPRING) return "весна";
        else if (this == SUMMER) return "лето";
        else if (this == AUTUMN) return "осень";
        return "Oh shit, here we go again...";
    }
}
