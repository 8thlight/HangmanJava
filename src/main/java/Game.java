import java.util.List;

public interface Game {
    public boolean IsOver();
    void Guess(char guess);

    List<Character> CurrentClue();
}
