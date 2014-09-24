package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void ItGuessesEachVowel() {
        YourPlayer player = new YourPlayer();

        char guess;
        // (Answer is "facetious")
        List<Character> clue = Arrays.asList(
                '_', '_', '_', '_', '_', '_', '_', '_', '_'
        );

        guess = player.GetGuess(clue);
        assertEquals(String.valueOf('a'), String.valueOf(guess));
        clue.set(1, 'a');

        guess = player.GetGuess(clue);
        assertEquals(String.valueOf('e'), String.valueOf(guess));
        clue.set(3, 'e');

        guess = player.GetGuess(clue);
        assertEquals(String.valueOf('i'), String.valueOf(guess));
        clue.set(5, 'i');

        guess = player.GetGuess(clue);
        assertEquals(String.valueOf('o'), String.valueOf(guess));
        clue.set(6, 'o');

        guess = player.GetGuess(clue);
        assertEquals(String.valueOf('u'), String.valueOf(guess));
    }
}
