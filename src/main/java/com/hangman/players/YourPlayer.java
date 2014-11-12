package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
	
	private ArrayList<Character> myGuesses = new ArrayList<Character>();
	private ArrayList<Character> myLetters = createLetterList();
	
	private ArrayList<Character> createLetterList() {
		ArrayList<Character> returnLetters = new ArrayList<Character>();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] letters = alphabet.toCharArray();
		for(char c : letters) {
			returnLetters.add(c);
		}
		return returnLetters;
	}
	
	//@Override
	public char GetGuess(List<Character> clue) {
		char toReturn = 'a';
		for(Character c : clue) {
			if(myGuesses.contains(c) || c.equals("_")) {
				myLetters.remove(c);
			}
		}
		
		toReturn = myLetters.get(0);
		myGuesses.add(toReturn);
		myLetters.remove(0);
		return toReturn;
	}
	
	public ArrayList<Character> getPreviousGuesses() {
		return myGuesses;
	}
	
}
