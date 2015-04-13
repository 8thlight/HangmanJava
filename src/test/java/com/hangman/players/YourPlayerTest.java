package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class YourPlayerTest {

    private YourPlayer player;

    @Before
    public void setUp() {
        player = new YourPlayer();
    }

    @Test
    public void GetLatestClueShouldReturnNothing() {
        assertNull(player.GetLatestClue());
    }

    @Test
    public void GetGuessShouldReturnFirstElementInMostCommonLetterList() {
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(guess, YourPlayer.mostCommon2LeastLetters.get(0).charValue());
    }

    @Test
    public void GetGuessShouldReturnZeroWhenClueIsNull() {
        char c = player.GetGuess(null);
        assertTrue(c == 0);
    }

    @Test
    public void GetGuessShouldAlwaysReturnElementInMostCommonLetterList() {
        for(int i = 0; i < YourPlayer.mostCommon2LeastLetters.size(); i++) {
            char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
            assertTrue(Character.isAlphabetic(guess));
        }
    }

    @Test
    public void GetGuessShouldNotReturnLetterMorN() {
        for(int i = 0; i < YourPlayer.mostCommon2LeastLetters.size(); i++) {
            char c = player.GetGuess(Arrays.asList('m', '_', 'n'));
            assertNotEquals(c, 'm');
            assertNotEquals(c, 'n');
        }
    }

    @Test
    public void GetLatestClueShouldMatchInitialClueList() {
        List <Character> clue = Arrays.asList('_', '_', '_');
        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(clue, player.GetLatestClue());
    }
}
