package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {
    @Test
    public void guessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('e', guess);
    }

    @Test
    public void guessesLetterNotInCurrentClueList() {
        YourPlayer player = new YourPlayer();

        char guess = player.getGuess(Arrays.asList('m', null, 'n'));

        boolean guessNotInList = assertGuessNotInList(guess, Arrays.asList('m', null, 'n'));
        assertEquals(true, guessNotInList);
    }

    static boolean assertGuessNotInList(char guess, List<Character> currentClueList) {
        return (!(currentClueList.contains(guess)));
    }
}
