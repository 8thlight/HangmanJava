import java.util.List;

public class HangmanGame implements Game{
    @Override
    public boolean IsOver() {
        return false;
    }

    @Override
    public void Guess(char guess) {

    }

    @Override
    public List<Character> CurrentClue() {
        return null;
    }
}
