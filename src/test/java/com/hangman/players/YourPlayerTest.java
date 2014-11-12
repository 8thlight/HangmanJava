package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('b'));

//        assertEquals('a', guess);
    }

    @Test
    public void AlwaysGuessB() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a'));

        //assertEquals('b', guess);
    }

    @Test
    public void AlwaysGuessNextPopularLetter() {
        YourPlayer player = new YourPlayer();

        player.SeedPopularLetters(Arrays.asList('s', 't', 'r'));

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

//        assertEquals('s', guess);
    }
}
