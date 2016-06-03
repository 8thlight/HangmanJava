package com.hangman;

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

        for(int i=0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            assertFalse(game.IsOver());
            game.Guess('c');
        }
    }

    @Test
    public void ItIsOverWhenTheMaxGuessesAreUsed() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxIncorrectGuesses; i++) {
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
    public void TheAnswerCanBeGuessedWhenTheWordHasCapitalLetters() {
        simpleAnswerGenerator.setNextAnswer("AAbb");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Test
    public void TheGameCanTellYouIfYouAreAWinner() {
        simpleAnswerGenerator.setNextAnswer("AAbb");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('b');
        game.Guess('a');

        assertTrue(game.IsWinner());
    }

    @Test
    public void TheCurrentClueStartsAsAListOfNulls() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        assertEquals(Arrays.asList(null, null, null, null), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueGetsACorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');

        assertEquals(Arrays.asList('e', null, null, null), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueCanHandleMoreThanOneCorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('e');
        game.Guess('i');

        assertEquals(Arrays.asList('e', null, 'i', null), game.CurrentClue());
    }

    @Test
    public void TheCurrentClueAlsoHasRepeatingLetters() {
        simpleAnswerGenerator.setNextAnswer("jimmy");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('m');

        assertEquals(Arrays.asList(null, null, 'm', 'm', null), game.CurrentClue());
    }

    @Test
    public void CaseIsIrrelevant() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('p');

        assertEquals(Arrays.asList('p', null, null, null, null, null), game.CurrentClue());
    }

    @Test
    public void ItSendsNotificationsOnGuesses() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.addObserver(this);
        game.Guess('c');

        assertSame(observedObject, game);
    }

    @Test
    public void ItReturnsTheGuessCount() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.SetAnswerGenerator(simpleAnswerGenerator);

        game.Guess('c');
        game.Guess('p');

        assertEquals(2, game.numGuesses());
    }

    @Test
    public void ItIsAbleToGuessAWordLongerThanMaxGuesses() {
        String longWord = "";

        for (int i = 0; i <= HangmanGame.MaxIncorrectGuesses; i++) {
            char nextChar = (char) ('a' + i);
            longWord += nextChar;
        }

        simpleAnswerGenerator.setNextAnswer(longWord);
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for (int i = 0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            game.Guess((char) ('a' + i));
        }

        assertFalse(game.IsOver());
        game.Guess((char) ('a' + HangmanGame.MaxIncorrectGuesses));

        assertTrue(game.IsOver());
    }

    @Test
    public void ItCountsAlreadyGuessedValuesAsWrongGuesses() {
        String longWord = "";

        for (int i = 0; i <= HangmanGame.MaxIncorrectGuesses; i++) {
            char nextChar = (char) ('a' + i);
            longWord += nextChar;
        }

        simpleAnswerGenerator.setNextAnswer(longWord);
        game.SetAnswerGenerator(simpleAnswerGenerator);

        for (int i = 0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            game.Guess('a');
        }

        assertFalse(game.IsOver());
        game.Guess('a');

        assertTrue(game.IsOver());
    }

    @Override
    public void update(Observable o, Object arg) {
        observedObject = o;
    }
}
