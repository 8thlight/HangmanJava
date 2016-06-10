package com.hangman.players;

import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class YourPlayerTest {
    public static final List<Character> ALL_CHARACTERS = Collections.unmodifiableList(Arrays.asList(
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    ));

    private YourPlayer player;

    @Before
    public void setUp() {
        player = new YourPlayer();
    }

    @Test
    public void guessesEWhenThereAreNoSuccessfulCharactersGuessedYet() {
        char guess = player.getGuess(Arrays.asList(null, null, null));

        assertEquals('e', guess);
    }

    @Test
    public void guessesEWhenThereAreSuccessfulCharactersGuessedThatAreNotE() {
        char guess = player.getGuess(Arrays.asList('m', null, 'n'));

        assertEquals('e', guess);
    }

    @Test
    public void guessesAWhenEIsInTheClue() {
        char guess = player.getGuess(Arrays.asList(null, 'e', null));

        assertEquals('a', guess);
    }

    @Test
    public void guessesIWhenEAndAAreInTheClue() {
        char guess = player.getGuess(Arrays.asList('e', 'a', null));

        assertEquals('i', guess);
    }

    @Test
    public void guessesARandomCharacterWhenTheClueContainsEAI() {
        List<Character> chars = new ArrayList<>(ALL_CHARACTERS);
        chars.removeAll(Arrays.asList('a', 'e', 'i'));
        char guess = player.getGuess(Arrays.asList('e', 'a', 'i', null));

        assertTrue(chars.contains(guess));
    }

    @Test
    public void doesNotGuessTheSameRandomCharacterTwice() {
        char guess1 = player.getGuess(Arrays.asList('e', 'a', 'i', null));
        char guess2 = player.getGuess(Arrays.asList('e', 'a', 'i', null));

        assertNotEquals(guess1, guess2);
    }

}
