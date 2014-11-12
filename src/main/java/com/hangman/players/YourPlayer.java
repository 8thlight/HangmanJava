package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import java.util.Random;

public class YourPlayer implements Player {
  //@Override
	
  char c;
  String clues = "";
	
  public char GetGuess(List<Character> clue) {
	
	Random r = new Random();
	c = (char)(r.nextInt(26) + 'a');
	
	while(clues.contains("" + c)) {
		c = (char)(r.nextInt(26) + 'a');
	}

	clues += c;
	
	return c;
  }
}
