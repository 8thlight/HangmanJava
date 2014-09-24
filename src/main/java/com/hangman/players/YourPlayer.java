package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  HashMap<Character, Integer> guessedCharacters;

  public YourPlayer() {
      guessedCharacters = new HashMap<Character, Integer>();
  }
  @Override
  public char GetGuess(List<Character> clue) {

      char guess = randomCharacter();

      for(int i=0; i < clue.size(); i++) {
          if (guess == clue.get(i)) guess = randomCharacter();
      }

      guessedCharacters.put(guess, 1);

      return guess;

  }

  public char randomCharacter() {
      return (char) (0 + (int)(Math.random()*25) + 97);
  }

}
