package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class YourPlayerTest {
    @Test
    public void makesSuccessfulGuess() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertTrue(Character.valueOf(guess) != null);
    }

    @Test
    public void guessesRandomLetterWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();
        List<Character> clues = Arrays.asList('x', 'b', 'g', 'f', 'i');

        clues.stream().forEach(c -> {
            char guess = player.getGuess(Arrays.asList(null, null, c));
            assertTrue(guess != c);
        });
    }
}
