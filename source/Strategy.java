import java.util.List;

public interface Strategy {
    public void execute(List<Character> characters) throws LocationException;
}
