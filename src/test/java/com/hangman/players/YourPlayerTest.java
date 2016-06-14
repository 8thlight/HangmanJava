package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {
    @Test
    public void guessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('e', guess);
    }

    @Test
    public void guessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList('e', null, 't'));

        assertEquals('a', guess);
    }

    @Test
    public void guessesAWhenEIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, 'e', null));

        assertNotEquals('e', guess);
    }


}
