public enum Location {
    WEST,
    EAST,
    NORTH,
    SOUTH,
    MOMMIE_DOL;
    @Override
    public String toString() {
        if (this == MOMMIE_DOL) return "Муми-дол";
        else if (this == NORTH) return "север";
        else if (this == SOUTH) return "юг";
        else if (this == EAST) return "восток";
        else return "запад";
    }
}
