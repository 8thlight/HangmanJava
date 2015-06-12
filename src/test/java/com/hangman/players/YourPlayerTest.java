package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {
    List<Character> vowels = new LinkedList<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    @Test
    public void DoesNotGuessAlreadyValidLetter() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', '_', 'a'));

        assertNotEquals('a', guess);
    }

    @Test
    public void DoesNotGuessSameLetterTwice() {
        YourPlayer player = new YourPlayer();

        char firstGuess = player.GetGuess(Arrays.asList('_', '_', '_'));
        char secondGuess = player.GetGuess(Arrays.asList('_', '_', firstGuess));

        assertNotEquals(firstGuess, secondGuess);
    }

    @Test
    public void GuessVowelsFirst() {
        YourPlayer player = new YourPlayer();

        char firstGuess = player.GetGuess(Arrays.asList('_', '_', '_', '_', '_'));

        assertEquals(true, vowels.contains(firstGuess));
    }

    @Test
    public void GuessesConsonantAfterTwoCorrectVowels() {
        YourPlayer player = new YourPlayer();

        char nextGuess = player.GetGuess(Arrays.asList('_', 'a', 'i', '_', '_', '_'));

        assertEquals(false, vowels.contains(nextGuess));
    }
}
