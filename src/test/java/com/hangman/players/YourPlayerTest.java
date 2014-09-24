package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void alwaysGuessA() {
        YourPlayer player = new YourPlayer();
        player.SetGuesses(Arrays.asList('a', 'b', 'c'));
        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('a', guess);
    }

    @Test
    public void setsAllGuessed() throws Exception {
        YourPlayer player = new YourPlayer();
        player.SetGuesses(Arrays.asList('a', 'b', 'c'));

        assertEquals(Arrays.asList('a', 'b', 'c'), player.GetLatestClue());
    }

}
