package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList(null, null, null));

        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', null, 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList(null, 'a', null));

        assertEquals('a', guess);
    }
}
