package com.hangman.players;

import org.junit.Test;
import org.junit.Before;
import java.util.Arrays;
import static org.junit.Assert.*;

public class YourPlayerTest {
    private YourPlayer player;

    @Before
    public void setUp() {
        player = new YourPlayer();
    }

    @Test
    public void guessesEWhenThereAreNoSuccessfulCharactersGuessedYet() {
        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('e', guess);
    }

    @Test
    public void guessesEWhenThereAreSuccessfulCharactersGuessedThatAreNotE() {
        char guess = player.getGuess(Arrays.asList('m', null, 'n'));

        assertEquals('e', guess);
    }

    @Test
    public void guessesAWhenEIsInTheClue() {
        char guess = player.getGuess(Arrays.asList(null, 'e', null));

        assertEquals('a', guess);
    }
}
