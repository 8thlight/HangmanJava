package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {

	private List<Character> entered = new ArrayList<Character>();
	
  @Override
  public char GetGuess(List<Character> clue) {
	
	  Random r = new Random();
	  char guess = (char)(r.nextInt(26) + 'a');
	 
	  while (entered.contains(guess)) {
		  guess = (char)(r.nextInt(26) + 'a');		  
	  }
	  
	  entered.add(guess);
	  
	  return guess;
  }
}
