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
		else {
			boolean empty = true;
			for (int i = 0; i < clue.size(); i++) {
				if (clue.get(i) != '_') {
					empty = false;
				}
			}
			if (empty) {
				for (int i = 0; i < vowels.length; i++) {
					if (!charGuessed.contains(vowels[i])) {
						guess = vowels[i];
						charGuessed.add(guess);
						break;
					}
				}
			}
			else {
				boolean found = false;
				for (int i = 0; i < WordList.words.length; i++) {
					String word = WordList.words[i];
					int length = word.length();
					if (clue.size() == length) {
						for (int j = 0; j < length; j++) {
							if (clue.get(j) == '_' && !charGuessed.contains(word.charAt(j))) {
								guess = word.charAt(j);
								charGuessed.add(guess);
								found = true;
								break;
							}
						}
					}
					if (found) {
						break;
					}
				}
			}
		}
		return guess;
	}
}
