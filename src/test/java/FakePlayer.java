import java.util.LinkedList;
import java.util.List;

public class FakePlayer implements Player {
    private LinkedList<Character> guesses;
    private List<Character> latestClue;

    public FakePlayer() {
        guesses = new LinkedList<Character>();
    }

    public void SetGuesses(List<Character> chars) {
        this.guesses = new LinkedList<Character>();
        for(char guess : chars) {
            this.guesses.add(guess);
        }
    }

    @Override
    public char GetGuess(List<Character> clue) {
        latestClue = clue;
        if (guesses.size() > 0)
            return guesses.pop();
        return 0;
    }

    public List<Character> GetLatestClue() {
        return latestClue;
    }
}
