package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();
        List<Character> clue = Arrays.asList('_', '_', '_');
        char guess = player.GetGuess(clue);
        assertEquals('a', guess);
    }

    @Test
    public void DontGuessAIfAIsGuessed() {
        YourPlayer player = new YourPlayer();
        List<Character> clue = Arrays.asList('a', '_', '_');
        char guess = player.GetGuess(clue);
        assertFalse(guess == 'a');
    }
}
