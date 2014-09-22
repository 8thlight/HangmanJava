import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HangmanGame implements Game{
    public static int MaxGuesses = 5;
    private List<Character> answer;
    private List<Character> guesses;

    public HangmanGame()
    {
        guesses = new ArrayList<Character>();
    }

    @Override
    public boolean IsOver()
    {
        return (guesses.size() >= MaxGuesses) || this.guesses.containsAll(this.answer);
    }

    @Override
    public void Guess(char guess)
    {
        guesses.add(Character.toLowerCase(guess));
    }

    @Override
    public List<Character> CurrentClue()
    {
        List<Character> clue = new ArrayList<Character>();

        for (int i = 0; i < answer.size(); i++) {
            Character c = answer.get(i);
            if (guesses.contains(Character.toLowerCase(c)))
                clue.add(c);
            else
                clue.add('_');
        }

        return clue;
    }

    public void SetAnswer(String answer) {
        this.answer = new ArrayList<Character>();
        for (Character c : answer.toCharArray()) {
            this.answer.add(c);
        }
    }
}
