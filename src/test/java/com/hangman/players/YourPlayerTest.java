package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void ItGuessesEachVowel() {
        YourPlayer player = new YourPlayer();
        char guess;
        // (Answer is "facetious")

        guess = player.GetGuess(Arrays.asList(
                '_', '_', '_', '_', '_', '_', '_', '_', '_'
        ));
        assertEquals(String.valueOf('a'), String.valueOf(guess));

        guess = player.GetGuess(Arrays.asList(
                '_', 'a', '_', '_', '_', '_', '_', '_', '_'
        ));
        assertEquals(String.valueOf('e'), String.valueOf(guess));

        guess = player.GetGuess(Arrays.asList(
                '_', 'a', '_', 'e', '_', '_', '_', '_', '_'
        ));
        assertEquals(String.valueOf('i'), String.valueOf(guess));

        guess = player.GetGuess(Arrays.asList(
                '_', 'a', '_', 'e', '_', 'i', '_', '_', '_'
        ));
        assertEquals(String.valueOf('o'), String.valueOf(guess));

        guess = player.GetGuess(Arrays.asList(
                '_', 'a', '_', 'e', '_', 'i', 'o', '_', '_'
        ));
        assertEquals(String.valueOf('u'), String.valueOf(guess));
    }
}
