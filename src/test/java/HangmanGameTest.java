import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class HangmanGameTest {

    @Test
    public void ItIsNotOverWhenTheMaxGuessesAreNotUsedYet() {
        HangmanGame game = new HangmanGame();

        game.SetClue(Arrays.asList('a','b'));
        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            assertFalse(game.IsOver());
            game.Guess('c');
        }
    }

    @Test
    public void ItIsOverWhenTheMaxGuessesAreUsed() {
        HangmanGame game = new HangmanGame();
        game.SetClue(Arrays.asList('a','b'));

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            game.Guess('c');
        }

        assertTrue(game.IsOver());
    }

    @Test
    public void ItIsOverWhenTheAnswerIsGuessed() {
        HangmanGame game = new HangmanGame();
        game.SetClue(Arrays.asList('a', 'b'));

        game.Guess('a');
        game.Guess('b');

        assertTrue(game.IsOver());
    }
}
