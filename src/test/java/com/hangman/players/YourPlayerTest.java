package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        char guess = newYourPlayer().GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        char guess = newYourPlayer().GetGuess(Arrays.asList('m', '_', 'n'));
        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenAIsThereAreAsInTheClueAsWell() {
        char guess = newYourPlayer().GetGuess(Arrays.asList('_', 'a', '_'));
        assertEquals('a', guess);
    }

    @Test
    public void GuessesSomething() {
        newYourPlayer().GetGuess(Arrays.asList('b'));
    }

    @Test
    public void EnsureRecentGuesses() {

    }

    @Test
    public void EnsureSpotTrackingIntegrity() {
        YourPlayer player = newYourPlayer();
        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(3, player.getEmptySpotPositions().size());
    }

    private static YourPlayer newYourPlayer() {
        return new YourPlayer();
    }
}
