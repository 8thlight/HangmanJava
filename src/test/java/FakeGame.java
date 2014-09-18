import java.util.ArrayList;
import java.util.List;

public class FakeGame implements Game {
    private boolean done;
    private ArrayList<Character> guesses;
    private char lastGuess;
    private List<Character> clue;

    public FakeGame() {
        this.done = false;
        this.guesses = new ArrayList<Character>();
    }

    public void SetDone() {
        done = true;
    }

    public boolean IsOver() {
        return done;
    }

    public void SetLastGuess(char c) {
        lastGuess = c;
    }

    public List<Character> Guesses() {
        return guesses;
    }

    @Override
    public void Guess(char guess) {
        guesses.add(guess);
        if (guess == lastGuess)
            SetDone();
    }

    @Override
    public List<Character> CurrentClue() {
        return clue;
    }

    public void SetCurrentClue(List<Character> clue) {
        this.clue = clue;
    }
}
