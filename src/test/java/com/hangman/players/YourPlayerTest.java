package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void guessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('a', guess);
    }

    @Test
    public void guessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList('m', null, 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void guessesAWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, 'a', null));

        assertEquals('a', guess);
    }
}
