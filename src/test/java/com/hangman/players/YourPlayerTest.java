package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('a', guess);
    }
    
    @Test
	public void KnowsItHasGuessedA() throws Exception {
		YourPlayer player = new YourPlayer();
		ArrayList<Character> testGuess = new ArrayList<Character>();
		testGuess.add('a');
		
		char guess = player.GetGuess(Arrays.asList('a','_'));
		
		assertEquals(testGuess, player.getPreviousGuesses());
	}
    
    @Test
	public void canAvoidMultipleSameGuesses() throws Exception {
		YourPlayer player = new YourPlayer();
		
		char guess = player.GetGuess(Arrays.asList('_','_', '_'));
		char guess2 = player.GetGuess(Arrays.asList('a','_', '_'));
		assertFalse(guess2 == 'a');
	}
    
    @Test
	public void canGuessMultiples() throws Exception {
		YourPlayer player = new YourPlayer();
		
		char guess = player.GetGuess(Arrays.asList('_','_','_'));
		char guess1 = player.GetGuess(Arrays.asList('a', '_', '_'));
		assertEquals('b', guess1);
	}
}
