import java.util.ArrayList;
import java.util.List;

public class HangmanGame implements Game{
    public static int MaxGuesses = 5;
    private List<Character> answer;
    private List<Character> guesses;
    private AnswerGenerator answerGenerator = new RandomAnswerGeneratorFromList();

    public HangmanGame()
    {
        guesses = new ArrayList<Character>();
    }

    @Override
    public boolean IsOver()
    {
        return (guesses.size() >= MaxGuesses) || this.guesses.containsAll(this.Answer());
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

        for (int i = 0; i < Answer().size(); i++) {
            Character c = Answer().get(i);
            if (guesses.contains(Character.toLowerCase(c)))
                clue.add(c);
            else
                clue.add('_');
        }

        return clue;
    }

    public void SetAnswerGenerator(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    protected List<Character> Answer() {
        if (answer == null) {
            answer = new ArrayList<Character>();
            for (Character c : answerGenerator.generateAnswer().toCharArray())
                answer.add(c);
        }
        return answer;
    }
}
