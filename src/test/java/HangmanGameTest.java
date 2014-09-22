import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HangmanGameTest implements Observer {

    private Observable observedObject;
    private SimpleAnswerGenerator simpleAnswerGenerator;
    private HangmanGame game;

    @Before
    public void setUp() {
        simpleAnswerGenerator = new SimpleAnswerGenerator();
        game = new HangmanGame();
        observedObject = null;
    }

    @Test
    public void ItIsNotOverWhenTheMaxGuessesAreNotUsedYet() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            assertFalse(game.IsOver());
            game.Guess('c');
        }
    }

    @Test
    public void ItIsOverWhenTheMaxGuessesAreUsed() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxGuesses; i++) {
            game.Guess('c');
        }

        assertTrue(game.IsOver());
    }

    @Test
    public void ItIsOverWhenTheAnswerIsGuessed() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('a');
        game.Guess('b');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedInTheWrongOrder() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheAnswerCanBeGuessedWhenThereAreDuplicates() {
        simpleAnswerGenerator.setNextAnswer("abbb");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheCurrentClueStartsAsAListOfEmptySlots() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        assertEquals(Arrays.asList('_', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueGetsACorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');

        assertEquals(Arrays.asList('e', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueCanHandleMoreThanOneCorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');
        game.Guess('i');

        assertEquals(Arrays.asList('e', '_', 'i', '_'), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueAlsoHasRepeatingLetters() {
        simpleAnswerGenerator.setNextAnswer("jimmy");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('m');

        assertEquals(Arrays.asList('_', '_', 'm', 'm', '_'), game.CurrentClue());
    }

    @Test
    public void CaseIsIrrelevant() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('p');

        assertEquals(Arrays.asList('P', '_', '_', '_', '_', '_'), game.CurrentClue());
    }

    @Test
    public void ItSendsNotificationsOnGuesses() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.addObserver(this);
        game.Guess('c');

        assertSame(observedObject, game);
    }

    @Override
    public void update(Observable o, Object arg) {
        observedObject = o;
    }
}
