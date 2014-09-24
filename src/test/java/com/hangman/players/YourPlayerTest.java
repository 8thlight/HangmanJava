package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();
        char guess;
        // (Answer is "facetious")

        guess = player.GetGuess(Arrays.asList(
                '_', '_', '_', '_', '_', '_', '_', '_', '_'
        ));
        assertEquals(String.valueOf('a'), String.valueOf(guess));
    }
}
