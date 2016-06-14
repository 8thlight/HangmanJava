package com.hangman.players;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {

	@Test
	public void should_increment_guess_count(){
		YourPlayer player = new YourPlayer();
		player.getGuess(Arrays.asList(null, null, null));

		assertEquals(1, player.getGuessCount());
	}

	@Test
	public void should_after_first_two_guesses_guess_a(){
		YourPlayer player = new YourPlayer();
		player.setPreviousGuesses('e','t');
		char guess = player.getGuess(Arrays.asList(null, null, null));

		assertEquals('a', guess);
	}

	@Test
	public void should_not_guess_the_same_thing_twice(){
		YourPlayer player = new YourPlayer();
		Set<Character> guesses = new HashSet<>();

		for(int i=1;i<27;i++){
			guesses.add(player.getGuess(Arrays.asList(null, null, null)));
		}

		assertEquals(26, guesses.size());
	}

	@Test
	public void should_guess_u_if_clue_has_q(){
		YourPlayer player = new YourPlayer();
		char guess = player.getGuess(Arrays.asList('q', null, null));

		assertEquals('u', guess);
	}

	@Test
	public void should_not_guess_u_if_clue_has_q_but_already_guess_u(){
		YourPlayer player = new YourPlayer();
		player.setPreviousGuesses('u');
		char guess = player.getGuess(Arrays.asList('q', null, null));

		assertNotEquals('u', guess);
	}

	@Test
	public void should_guess_h_if_clue_has_t(){
		YourPlayer player = new YourPlayer();
		char guess = player.getGuess(Arrays.asList('t', null, null));

		assertEquals('h', guess);
	}

	@Test
	public void should_not_guess_what_has_already_been_guessed(){
		YourPlayer player = new YourPlayer();
		player.setPreviousGuesses('t');
		char guess = player.getGuess(Arrays.asList('e', null, null));

		assertNotEquals('t', guess);
	}

	@Test
	public void if_clue_length_is_2_guess_a(){
		YourPlayer player = new YourPlayer();
		char guess = player.getGuess(Arrays.asList(null, null));

		assertEquals('a', guess);
	}

	@Test
	public void if_clue_length_is_7_guess_i(){
		YourPlayer player = new YourPlayer();
		char guess = player.getGuess(Arrays.asList(null, null, null, null, null, null, null));

		assertEquals('i', guess);
	}
}
