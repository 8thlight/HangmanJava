package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {

    @Test
    public void GuessesSomething() {
        new YourPlayer().GetGuess(Arrays.asList('b'));
    }

    @Test
    public void EnsureSpotTrackingIntegrity() {
        YourPlayer player = new YourPlayer();
        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(3, player.getEmptySpotPositions().size());
    }

    @Test
    public void EnsureGuessCount() {
        YourPlayer player = new YourPlayer();

        assertEquals(0, player.getTotalGuessCount());

        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(1, player.getTotalGuessCount());
    }

    @Test
    public void EnsureNoGuess() {
        YourPlayer player = new YourPlayer();

        assertEquals((char)0, (char)player.getLastGuess());

//        player.GetGuess(Arrays.asList('a'));
//        assertNotEquals((char) 0, (char) player.getLastGuess());
    }

    @Test
    public void EnsureRecentGuesses() {

    }

}
