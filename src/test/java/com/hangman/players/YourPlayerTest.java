package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

    YourPlayer player;

    @Before
    public void setUp() throws Exception {
        player = new YourPlayer();
    }

    @Test
    public void AlwaysGuessA() {
        List<Character> guesses = Arrays.asList('a', 'b', 'c');
        char guess = player.GetGuess(guesses);
        assertEquals('a', guess);
    }

    @Test
    public void guessedAlreadyTest() {
        ArrayList<Character> guesses = new ArrayList<Character>();
        List<Character> guess1 = Arrays.asList('a', 'b', 'c','d');
        List<Character> guess2 = Arrays.asList('a', 'b', 'c','d');
        guesses.add(player.GetGuess(guess1));
        guesses.add(player.GetGuess(guess2));
        ArrayList<Character> guessedAlready = player.GuessedAlready();
        assertEquals(guessedAlready, guesses);

    }

    @Test
    public void GetNextGuess() {
        ArrayList<Character> guesses = new ArrayList<Character>();
        List<Character> guess1 = Arrays.asList('a', 'b', 'c');
        guesses.add(player.GetGuess(guess1));
    }
}
