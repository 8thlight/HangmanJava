import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class HangmanGameTest {

    @Test
    public void ItIsNotOverWhenTheMaxGuessesAreNotUsedYet() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("ab");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            assertFalse(game.IsOver());
            game.Guess('c');
        }
    }

    @Test
    public void ItIsOverWhenTheMaxGuessesAreUsed() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("ab");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            game.Guess('c');
        }

        assertTrue(game.IsOver());
    }

    @Test
    public void ItIsOverWhenTheAnswerIsGuessed() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("ab");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('a');
        game.Guess('b');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedInTheWrongOrder() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("ab");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedWhenThereAreDuplicates() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("abbb");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheCurrentClueStartsAsAListOfEmptySlots() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("eric");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        assertEquals(Arrays.asList('_', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueGetsACorrectGuess() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("eric");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');

        assertEquals(Arrays.asList('e', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueCanHandleMoreThanOneCorrectGuess() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("eric");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');
        game.Guess('i');

        assertEquals(Arrays.asList('e', '_', 'i', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueAlsoHasRepeatingLetters() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("jimmy");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('m');

        assertEquals(Arrays.asList('_', '_', 'm', 'm', '_'), game.CurrentClue());
    }

    @Test
    public void CaseIsIrrelevant() {
        SimpleAnswerGenerator simpleAnswerGenerator = new SimpleAnswerGenerator();
        simpleAnswerGenerator.setNextAnswer("PLEASE");

        HangmanGame game = new HangmanGame();
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('p');

        assertEquals(Arrays.asList('P', '_', '_', '_', '_', '_'), game.CurrentClue());
    }
}
