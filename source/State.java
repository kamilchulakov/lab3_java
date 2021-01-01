public class State {
    private String text;

    public void stayNear(Character character) {
        text = String.format("Находится около %s.%n", character.getName());
    }

    public void stayAt(Location location) {
        text = String.format("Находится в %s.%n", location.toString());
    }

    @Override
    public String toString() {
        return text;
    }
}
