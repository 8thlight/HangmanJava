package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertTrue(player.alphabet.contains(guess));
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

    @Test
    public void AddLetterToGuessedListAfterGuess() {
        YourPlayer player = new YourPlayer();

        player.GetGuess(Arrays.asList('_', '_', '_'));
        List<Character> guessedLetters = player.GetGuessedLetters();

        List<Character> expectedList = new ArrayList<Character>();
        expectedList.add('a');

        assertEquals(expectedList, guessedLetters);
    }
}
