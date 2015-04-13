package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('e', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));

        assertEquals('e', guess);
    }

    @Test
    public void GuessesAWhenAIsThereAreAsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));

        assertEquals('e', guess);
    }

    @Test
    public void GuessesADifferentLetterWhenPreviousGuessIsIncorrect() {
        YourPlayer player = new YourPlayer();
        for (int i = 0; i < 26; ++i) {
            player.GetGuess(Collections.singletonList('_'));
        }
        assertFalse(listHasDuplicates(player.incorrectGuesses));
    }

    private boolean listHasDuplicates(List<Character> candidate) {
        List<Character> seenBefore = new ArrayList<>();
        for (Character c : candidate) {
            if (seenBefore.contains(c)) {
                return false;
            }
            seenBefore.add(c);
        }
        return true;
    }
 }
