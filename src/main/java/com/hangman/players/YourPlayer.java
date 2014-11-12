package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
	
	private List<Character> MyGuessList;
	private int GuessListIndex = 0;
	
	
  public char GetGuess(List<Character> clue) {
	 
	 this.MyGuessList = clue; 

     int randomNum = (int) (Math.random() * clue.size());
	 
     return MyGuessList .get(randomNum);
     
  }

	public List<Character> GuessList() {
		return this.MyGuessList;
	}
	
	public char nextGuess(){
		
		GuessListIndex++; 
		return MyGuessList .get(GuessListIndex);
	}
	
  
  
}
