package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a'));

        assertEquals('a', guess);
    }

    @Test
    public void chooseRandomLetter() throws Exception
    {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c','d'));
        assertNotEquals('z', guess);
    }

    @Test
    public void returnPreviousGuesses() throws Exception
    {
        YourPlayer player = new YourPlayer();
        player.GetGuess(Arrays.asList('a'));
        player.GetGuess(Arrays.asList('b'));
        player.GetGuess(Arrays.asList('e'));

         System.out.println(player.returnPreviousGuesses());
        assertEquals('a', player.returnPreviousGuesses()[0]);
        assertEquals('b', player.returnPreviousGuesses()[1]);
        assertEquals('e', player.returnPreviousGuesses()[2]);


    }
}
