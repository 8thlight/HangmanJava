package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char expectedGuess = player.getMostFrequentCharacter();
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals(expectedGuess, guess);
    }

    @Test
    public void GuessesAWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));

        assertNotEquals('a', guess);
    }

}
