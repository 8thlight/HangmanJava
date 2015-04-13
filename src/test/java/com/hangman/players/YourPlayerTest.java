package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {
    @Test
    public void GuessesEWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals('e', guess);
    }

    @Test
    public void GuessesRWhenThereAreSuccessfulCharactersGuessedThatAreNotE() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('e', '_', 'e'));
        assertEquals('e', guess);
    }

    @Test
    public void DoesNotGuessEWhenAIsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', 'e', '_'));
        assertEquals('e', guess);
    }

    @Test
    public void WillNotAnswerQIfNoU() throws Exception {
        YourPlayer player = new YourPlayer();
        for (int i = 0; i< 25; i++) {
            char guess = player.GetGuess(Arrays.asList('a', '_', '_', '_'));
            assertTrue(guess != 'q');
        }
    }

    @Test
    public void WillEventuallyAnswerQIfUIsPresent() throws Exception {
        YourPlayer player = new YourPlayer();
        boolean qHasBeenUsed = false;
        for (int i = 0; i< 25; i++) {
            char guess = player.GetGuess(Arrays.asList('_', 'u', '_', '_'));
            if (guess == 'q') {
                qHasBeenUsed = true;
            }
        }
        assertTrue(qHasBeenUsed);
    }

}
