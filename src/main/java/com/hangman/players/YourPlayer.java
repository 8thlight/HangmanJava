package com.hangman.players;
import com.hangman.Player;
import com.hangman.WordList;

import java.util.*;

public class YourPlayer implements Player {
	
	private ArrayList<Character> charGuessed = new ArrayList<Character>();
	private char vowels[] = new char[]{'a','e','i','o','u','y'};
	
	public char GetGuess(List<Character> clue) {
		char guess = vowels[0];
		if (charGuessed.isEmpty()) {
			charGuessed.add(guess);
		}
		else if (!clue.contains(vowels)) {
			for (int i = 0; i < vowels.length; i++) {
				if (!charGuessed.contains(vowels[i])) {
					guess = vowels[i];
					charGuessed.add(guess);
					break;
				}
			}
		}
		else {
			for (int i = 0; i < WordList.words.length; i++) {
				String word = WordList.words[i];
				int length = word.length();
				if (clue.size() == length) {
					for (int j = 0; j < length; j++) {
						if (clue.get(j) == '_') {
							guess = word.charAt(j);
							charGuessed.add(guess);
							break;
						}
					}
				}
			}
		}
		return guess;
	}
}
