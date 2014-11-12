package com.hangman.players;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;

public class YourPlayerTest {
    public YourPlayer player;

    @Before
    public void Setup() {
        player = new YourPlayer();

    }
    //@Test
    //public void AlwaysGuessA() {
    //    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

    //    assertEquals('a', guess);
    //}

    @Test
    public void AlwaysGuessOutsideTheClues() throws Exception {
        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
        assertNotEquals('a', guess);
        assertNotEquals('b', guess);
        assertNotEquals('c', guess);
    }


    @Test
    public void AlwaysGuessWithOtherCharacter() throws Exception
    {
        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
        assertNotEquals('a', guess);
        assertNotEquals('b', guess);
        assertNotEquals('c', guess);
        char newGuess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
        assertNotEquals(guess, newGuess);

    }

    @Test
    public void getRandomCharacter() throws Exception
    {
       char guess = player.randomCharacter();
       assertTrue(guess >= 'a' && guess <= 'z');
    }



}
