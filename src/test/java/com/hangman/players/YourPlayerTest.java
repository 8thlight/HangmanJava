package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
    public void GetLatestClueSHouldMatchInitialClueList() {
        List <Character> clue = Arrays.asList('_', '_', '_');
        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(clue, player.GetLatestClue());
    }
}
