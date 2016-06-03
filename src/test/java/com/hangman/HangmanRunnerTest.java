package com.hangman;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
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
    public void displaysGameOverWhenTheGameIsDone() throws Exception {
        game.SetDone();

        runner.run();

        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void tellsYouIfGameIsAWinner() {
        game.SetToWinner();

        assertTrue(runner.isWinner());
    }

    @Test
    public void itGetsTheNumberOfGuessesFromTheGame() {
        game.SetNumGuesses(3);

        assertEquals(3, runner.numGuesses());
    }

    @Test
    public void itPlaysATurnThatCanEndTheGame() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Collections.singletonList('z'));

        runner.run();

        assertEquals(Collections.singletonList('z'), game.Guesses());
        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void itSendsTheCurrentWordToThePlayer() throws Exception {
        List<Character> clue = new LinkedList<>();
        clue.add('_');

        game.SetCurrentClue(clue);

        runner.run();

        assertEquals(clue, player.GetLatestClue());
    }

    @Test
    public void itRunsTurnsUntilGameIsOver() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Arrays.asList('a', 'z'));

        runner.run();

        assertEquals(Arrays.asList('a', 'z'), game.Guesses());
        assertTrue(display.GameOverDisplayed());
    }

    @Test
    public void itTicksOnEachTurnThroughTheGame() throws Exception {
        game.SetLastGuess('z');
        player.SetGuesses(Arrays.asList('a', 'z'));

        runner.run();

        assertEquals(2, ticker.TickCount());
    }
}
