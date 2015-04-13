package com.hangman.players;


import org.junit.Test;


import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class YourPlayerTest {
    @Test
    public void Guesses_A_When_ThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('a', guess);
    }



    @Test
    public void Guesses_A_When_There_Are_Successful_Characters_Guessed_That_Are_Not_A() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void Guess_z_when_vowel_is_in_answer() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));
        assertEquals('z', guess);

    }

    @Test
    public void Guess_Vowels_Until_a_Vowel_is_Selected()
    {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        char guess2 = player.GetGuess(Arrays.asList('_', '_', '_'));
        char[] vowels = player.vowels;
        assertEquals(String.valueOf(vowels[0]),(String.valueOf(guess)));
        assertEquals(String.valueOf(vowels[1]),(String.valueOf(guess2)));

    }

    @Test
    public void Should_Not_Guess_Same_guess_twice()
    {
        YourPlayer player = new YourPlayer();
        char intitailGuess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertTrue(String.valueOf(intitailGuess).equals(String.valueOf('a')));
        assertFalse(String.valueOf('a').equals(String.valueOf(player.GetGuess(Arrays.asList('_', '_', '_')))));
    }
}
