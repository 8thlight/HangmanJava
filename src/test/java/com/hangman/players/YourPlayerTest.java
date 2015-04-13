package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static java.lang.String.valueOf;

public class YourPlayerTest {

    @Test
    public void alwaysGuessesACharacter() {
        YourPlayer player = new YourPlayer();

        for (int i = 0; i < 100; i++) {
            char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

            assertTrue(Character.isAlphabetic(guess));
            assertFalse(Character.isDigit(guess));
        }
    }

    @Test
    public void shouldNotGuessTheSameCharacterUntilAllOtherCharacterTried() {
        YourPlayer player = new YourPlayer();
        player.addLetter('a');

        for (int i = 0; i < 25; i++) {
            char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
            assertNotEquals(valueOf(guess), valueOf('a'));
        }
    }

    @Test
    public void DoesNotGuessWhenWordIsSolved() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', 'a', 'n'));

        assertEquals(" ", valueOf(guess));
    }

    @Test
    public void ShouldReturnIfPassedNullList() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(null);

        assertEquals(" ", valueOf(guess));
    }

    @Test
    public void ShouldReturnIfPassedEmptyList() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Collections.emptyList());

        assertEquals(" ", valueOf(guess));
    }


}
