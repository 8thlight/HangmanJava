import java.util.ArrayList;
import java.util.List;

public class HangmanGame implements Game{
    public static int MaxGuesses = 5;
    private List<Character> answer;
    private List<Character> clue;

    public HangmanGame()
    {
        clue = new ArrayList<Character>();
    }

    @Override
    public boolean IsOver()
    {
        return (clue.size() >= MaxGuesses) || this.clue.containsAll(this.answer);
    }

    @Override
    public void Guess(char guess)
    {
        clue.add(guess);
    }

    @Override
    public List<Character> CurrentClue() {
        return null;
    }

    public void SetClue(List<Character> answer) {
        this.answer = answer;
    }
}
