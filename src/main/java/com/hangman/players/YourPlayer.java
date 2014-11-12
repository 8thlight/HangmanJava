package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
  private char guessClue;
  private LinkedList<Character> guesses; 
  private List<Character> latestClue; 

  public YourPlayer() { 
       this.guesses = new LinkedList<Character>(); 
       final String commonLetter = "gturdtsake"; 
         for (int i = 0; i < commonLetter.length(); i ++ ) 
             guesses.add(commonLetter.charAt(i)); 
     } 
  
     public YourPlayer(LinkedList<Character> guesses) { 
         this.guesses = new LinkedList<Character>(); 
         for (Character character : guesses) { 
             this.guesses.add(character); 
         } 
     } 
  
     public void setGuesses(List<Character> chars) { 
         this.guesses = new LinkedList<Character>(); 
         for(char guess : chars) { 
             this.guesses.add(guess); 
         } 
     } 
  
     public LinkedList<Character> getGuesses() { 
         return guesses; 
     } 
  
     public char GetGuess(List<Character> clue) { 
         latestClue = clue; 
         if (guesses.size() > 0  ) 
             return guesses.pop(); 
         return 0 ; 
     } 
  
     public List<Character> getLatestClue() { 
         return latestClue; 
     } 
  
  
}

