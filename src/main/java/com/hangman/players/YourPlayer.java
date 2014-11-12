package com.hangman.players;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import com.hangman.Player;

public class YourPlayer implements Player {

	private ArrayDeque<Character> dict;

	public YourPlayer() {
		this.dict = new ArrayDeque<Character>();
		dict.addAll(Arrays.asList('e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'));
	}

	@Override
	public char GetGuess(List<Character> clue) {

		Character nextGuess;
		do {
			nextGuess = dict.pop();
		} while (clue.contains(nextGuess));

		return nextGuess;

	}
}
