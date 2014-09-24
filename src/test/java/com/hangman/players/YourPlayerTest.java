package com.hangman.players;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    private YourPlayer player;

    @Before
    public void setup() {
        player = new YourPlayer();
    }

    @Test
    public void AlwaysGuessE() {
        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('e', guess);
    }

    @Test
    public void ifEIsAlreadyGuessedGuessT() {
        char guess1 = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('e', guess1);


        char guess2 = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('t', guess2);
    }


}
