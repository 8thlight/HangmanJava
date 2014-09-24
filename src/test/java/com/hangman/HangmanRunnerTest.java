package com.hangman;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class HangmanRunnerTest {

    private HangmanRunner runner;
    private FakePlayer player;
    private FakeGame game;
    private FakeGameOverDisplay display;
    private FakeTicker ticker;

    @Before
    public void setUp() {
        display = new FakeGameOverDisplay();
        game = new FakeGame();
        player = new FakePlayer();
        ticker = new FakeTicker();

        runner = new HangmanRunner(game, display, player, ticker);
    }

    @Test
    public void DisplaysGameOverWhenTheGameIsDone() throws Exception {
        game.SetDone();

        runner.run();

        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void TellsYouIfGameIsAWinner() {
        game.SetToWinner();

        assertTrue(runner.isWinner());
    }

    @Test
    public void ItGetsTheNumberOfGuessesFromTheGame() {
        game.SetNumGuesses(3);

        assertEquals(3, runner.numGuesses());
    }

    @Test
    public void ItPlaysATurnThatCanEndTheGame() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Arrays.asList('z'));

        runner.run();

        assertEquals(Arrays.asList('z'), game.Guesses());
        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void ItSendsTheCurrentWordToThePlayer() throws Exception {
        List<Character> clue = new LinkedList<Character>();
        clue.add('_');

        game.SetCurrentClue(clue);

        runner.run();

        assertEquals(clue, player.GetLatestClue());
    }

    @Test
    public void ItRunsTurnsUntilGameIsOver() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Arrays.asList('a', 'z'));

        runner.run();

        assertEquals(Arrays.asList('a', 'z'), game.Guesses());
        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void ItTicksOnEachTurnThroughTheGame() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Arrays.asList('a', 'z'));

        runner.run();

        assertEquals(2, ticker.TickCount());
    }
}
