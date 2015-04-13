package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

    private static final String[] wordsForTest = {
        "abc",
        "acc",
        "something_longer",
        "somethingshorter"
    };


    @Test
    public void GuessesWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer(wordsForTest);

        // last character of the first 3 chars long word
        char shortGuess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals('c', shortGuess);

        // last character of the first 16 chars long word
        char longGuess = player.GetGuess(Arrays.asList('_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_', '_'));
        assertEquals('r', longGuess);
    }

    @Test
    public void GuessesWhenThereAreSuccessfulCharactersGuessedAndThereIsNoMatchingKnownWord() {
        YourPlayer player = new YourPlayer(wordsForTest);

        char guess1 = player.GetGuess(Arrays.asList('m', '_', 'n'));
        assertEquals('a', guess1);
    }

    @Test
    public void GuessesWhenThereAreSuccessfulCharactersGuessedAndThereIsAMatchingKnownWord() {
        YourPlayer player = new YourPlayer(wordsForTest);

        char guess2 = player.GetGuess(Arrays.asList('a', '_', 'b'));
        assertEquals('c', guess2);
    }

    @Test
    public void GuessesFirstCharacterOfACompleteClue() {
        YourPlayer player = new YourPlayer(wordsForTest);

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('a', guess);
    }

}
