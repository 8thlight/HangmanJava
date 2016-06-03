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
    public void itIsNotOverWhenTheMaxGuessesAreNotUsedYet() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.setAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            assertFalse(game.isOver());
            game.guess('c');
        }
    }

    @Test
    public void itIsOverWhenTheMaxGuessesAreUsed() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.setAnswerGenerator(simpleAnswerGenerator);

        for(int i=0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            game.guess('c');
        }

        assertTrue(game.isOver());
    }

    @Test
    public void itIsOverWhenTheAnswerIsGuessed() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('a');
        game.guess('b');

        assertTrue(game.isOver());
    }

    @Test
    public void theAnswerCanBeGuessedInTheWrongOrder() {
        simpleAnswerGenerator.setNextAnswer("ab");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('b');
        game.guess('a');

        assertTrue(game.isOver());
    }

    @Test
    public void theAnswerCanBeGuessedWhenThereAreDuplicates() {
        simpleAnswerGenerator.setNextAnswer("abbb");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('b');
        game.guess('a');

        assertTrue(game.isOver());
    }

    @Test
    public void theAnswerCanBeGuessedWhenTheWordHasCapitalLetters() {
        simpleAnswerGenerator.setNextAnswer("AAbb");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('b');
        game.guess('a');

        assertTrue(game.isOver());
    }

    @Test
    public void theGameCanTellYouIfYouAreAWinner() {
        simpleAnswerGenerator.setNextAnswer("AAbb");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('b');
        game.guess('a');

        assertTrue(game.isWinner());
    }

    @Test
    public void theCurrentClueStartsAsAListOfNulls() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.setAnswerGenerator(simpleAnswerGenerator);

        assertEquals(Arrays.asList(null, null, null, null), game.currentClue());
    }

    @Test
    public void theCurrentClueGetsACorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('e');

        assertEquals(Arrays.asList('e', null, null, null), game.currentClue());
    }

    @Test
    public void theCurrentClueCanHandleMoreThanOneCorrectGuess() {
        simpleAnswerGenerator.setNextAnswer("eric");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('e');
        game.guess('i');

        assertEquals(Arrays.asList('e', null, 'i', null), game.currentClue());
    }

    @Test
    public void theCurrentClueAlsoHasRepeatingLetters() {
        simpleAnswerGenerator.setNextAnswer("jimmy");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('m');

        assertEquals(Arrays.asList(null, null, 'm', 'm', null), game.currentClue());
    }

    @Test
    public void caseIsIrrelevant() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('p');

        assertEquals(Arrays.asList('p', null, null, null, null, null), game.currentClue());
    }

    @Test
    public void itSendsNotificationsOnGuesses() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.addObserver(this);
        game.guess('c');

        assertSame(observedObject, game);
    }

    @Test
    public void itReturnsTheGuessCount() {
        simpleAnswerGenerator.setNextAnswer("PLEASE");
        game.setAnswerGenerator(simpleAnswerGenerator);

        game.guess('c');
        game.guess('p');

        assertEquals(2, game.numGuesses());
    }

    @Test
    public void itIsAbleToGuessAWordLongerThanMaxGuesses() {
        String longWord = "";

        for (int i = 0; i <= HangmanGame.MaxIncorrectGuesses; i++) {
            char nextChar = (char) ('a' + i);
            longWord += nextChar;
        }

        simpleAnswerGenerator.setNextAnswer(longWord);
        game.setAnswerGenerator(simpleAnswerGenerator);

        for (int i = 0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            game.guess((char) ('a' + i));
        }

        assertFalse(game.isOver());
        game.guess((char) ('a' + HangmanGame.MaxIncorrectGuesses));

        assertTrue(game.isOver());
    }

    @Test
    public void itCountsAlreadyGuessedValuesAsWrongGuesses() {
        String longWord = "";

        for (int i = 0; i <= HangmanGame.MaxIncorrectGuesses; i++) {
            char nextChar = (char) ('a' + i);
            longWord += nextChar;
        }

        simpleAnswerGenerator.setNextAnswer(longWord);
        game.setAnswerGenerator(simpleAnswerGenerator);

        for (int i = 0; i < HangmanGame.MaxIncorrectGuesses; i++) {
            game.guess('a');
        }

        assertFalse(game.isOver());
        game.guess('a');

        assertTrue(game.isOver());
    }

    @Override
    public void update(Observable o, Object arg) {
        observedObject = o;
    }
}
