package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void guessesEWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('e', guess);
    }

    @Test
    public void guessesEWhenThereAreSuccessfulCharactersGuessedThatAreNotE() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList('m', null, 'n'));

        assertEquals('e', guess);
    }

    @Test
    public void guessesEWhenEIsInTheClue() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, 'e', null));

        assertEquals('e', guess);
    }
}
