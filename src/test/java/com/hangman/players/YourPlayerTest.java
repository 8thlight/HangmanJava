package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {

    @Test public void guessesACharacterWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        player.setHighFrequencyCharSet(Arrays.asList('a', 'b', 'c'));

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertTrue(player.getHighFrequencyCharSet().contains(guess));
    }

    @Test public void guessesTWhenThereAreSuccessfulCharactersGuessedThatAreNotE() {
        YourPlayer player = new YourPlayer();

        char c1 = player.getGuess(Arrays.asList(null, null, null));

        assertTrue(player.getHighFrequencyCharSet().contains(c1));

        char c2 = player.getGuess(Arrays.asList('e', null, null));

        assertTrue(player.getHighFrequencyCharSet().contains(c2));
    }

    @Test
    public void guessesADifferentCharacterThanTheOnePresentInCurrentClue() {
        YourPlayer player = new YourPlayer();

        char c = player.getGuess(Arrays.asList('a', 'b', null));

        assertNotEquals(c, 'a');

        assertNotEquals(c, 'b');
    }

    @Test public void guessTheFirstCharAsEAndSecondCharAsTAndThirdCharAsA() {
        YourPlayer player = new YourPlayer();

        char c1 = player.getGuess(Arrays.asList(null, null, null));

        char c2 = player.getGuess(Arrays.asList('e', null, null));

        char c3 = player.getGuess(Arrays.asList('t', null, null));

        assertTrue(player.getHighFrequencyCharSet().contains(c1));

        assertTrue(player.getHighFrequencyCharSet().contains(c2));

        assertTrue(player.getHighFrequencyCharSet().contains(c3));
    }
}
