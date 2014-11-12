package com.hangman.players;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

import com.hangman.Player;
import com.hangman.WordList;

public class YourPlayer implements Player {

	private ArrayDeque<Character> dict;
	private String[] wordList;
	
	public YourPlayer() {
		this.wordList = WordList.words;
		this.dict = new ArrayDeque<Character>();
		dict.addAll(Arrays.asList('e','t','a','o','i','n','s','h','r','d','l','c','u','m','w','f','g','y','p','b','v','k','j','x','q','z'));
	}

	@Override
	public char GetGuess(List<Character> clue) {

		Character nextGuess;
		do {
			nextGuess = dict.pop();
		} while (clue.contains(nextGuess) || clue.contains(Character.toUpperCase(nextGuess)));

		return nextGuess;

	}
	
	public void setWordList(String[] words) {
		wordList = words;
	}

	public String[] getWordList() {
		return wordList;
	}
}
