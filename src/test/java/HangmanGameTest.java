import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class HangmanGameTest {

    @Test
    public void ItIsNotOverWhenTheMaxGuessesAreNotUsedYet() {
        HangmanGame game = new HangmanGame();

        game.SetAnswer("ab");
        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            assertFalse(game.IsOver());
            game.Guess('c');
        }
    }

    @Test
    public void ItIsOverWhenTheMaxGuessesAreUsed() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("ab");

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            game.Guess('c');
        }

        assertTrue(game.IsOver());
    }

    @Test
    public void ItIsOverWhenTheAnswerIsGuessed() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("ab");

        game.Guess('a');
        game.Guess('b');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedInTheWrongOrder() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("ab");

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedWhenThereAreDuplicates() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("abbb");

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheCurrentClueStartsAsAListOfEmptySlots() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("eric");

        assertEquals(Arrays.asList('_', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueGetsACorrectGuess() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("eric");
        game.Guess('e');

        assertEquals(Arrays.asList('e', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueCanHandleMoreThanOneCorrectGuess() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("eric");
        game.Guess('e');
        game.Guess('i');

        assertEquals(Arrays.asList('e', '_', 'i', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueAlsoHasRepeatingLetters() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("jimmy");
        game.Guess('m');

        assertEquals(Arrays.asList('_', '_', 'm', 'm', '_'), game.CurrentClue());
    }

    @Test
    public void CaseIsIrrelevant() {
        HangmanGame game = new HangmanGame();
        game.SetAnswer("PLEASE");

        game.Guess('p');

        assertEquals(Arrays.asList('P', '_', '_', '_', '_', '_'), game.CurrentClue());
    }
}
