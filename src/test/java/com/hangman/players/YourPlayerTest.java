package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {

    @Test
    public void GuessesValidChar() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assert ("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".indexOf(guess) > 0);
    }

    @Test
    public void DoesntGuessKnownChar() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
        assertNotEquals(guess, 'a');
        assertNotEquals(guess, 'b');
        assertNotEquals(guess, 'c');
    }

    // Should be more advanced to ask more...
    @Test
    public void DoesntGuessSameCharTwice() {
        YourPlayer player = new YourPlayer();
        char firstGuess = player.GetGuess(Arrays.asList('_', '_', '_'));
        char secondGuess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertNotEquals(firstGuess, secondGuess);
    }

}
