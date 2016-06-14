package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class YourPlayerTest {


    @Test
    public void alwaysPickNextPopularChar() {
	    YourPlayer player = new YourPlayer();
	    player.setCharStrategy(Arrays.asList(null, null, null));
	    //note the two most popular characters
	    List<Character> expectedGuesses = new ArrayList<>();
      expectedGuesses.add(player.getPopularChars().get(0));
	    expectedGuesses.add(player.getPopularChars().get(1));
	    //make two guesses
      char guess1 = player.getGuess(Arrays.asList(null, null, null));
      char guess2 = player.getGuess(Arrays.asList(null, null, null));
	    System.out.println(guess1);
	    System.out.println(guess2);
	    //verify those guesses match our popular characters
      assertEquals(expectedGuesses, player.getAttemptedChars());
    }

		@Test
    public void chooseStrategyByClueSize() {
	    YourPlayer player = new YourPlayer();
	    //make a clue of a given size and feed it to player
	    List<Character>wordLength3Chars = Arrays.asList(null, null, null);
	    player.setCharStrategy(wordLength3Chars);
	    player.getGuess(wordLength3Chars);

			List<Character>expectedPopularChars = player.wordLength3Chars;
	    List<Character>actualPopularChars = player.getPopularChars();
	    //verify they are teh same
	    assertEquals(expectedPopularChars, actualPopularChars);
    }

    		@Test
    public void chooseLargestStrategyIfNoMatch() {
	    YourPlayer player = new YourPlayer();

	    //make a clue of an unsupported size and feed it to player
	    List<Character>wordLength11Chars = Arrays.asList(null, null, null, null, null, null, null, null, null, null, null);
	    player.setCharStrategy(wordLength11Chars);
	    player.getGuess(wordLength11Chars);

			List<Character>expectedPopularChars = player.wordLength10Chars;
	    List<Character>actualPopularChars = player.getPopularChars();
	    //verify they are teh same
	    assertEquals(expectedPopularChars, actualPopularChars);
    }

}
