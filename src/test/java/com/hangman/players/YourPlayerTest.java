package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();
        List<Character> allChars = new ArrayList<>();

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        for (int i = 0; i < 26; i++){
            char c = (char) (i+ 'a');
            allChars.add(c);
        }

        assertTrue(allChars.contains(guess));
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));

        assertEquals('a', guess);
    }
}
