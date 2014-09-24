package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  List<Character> guessedCharacters;

  public YourPlayer() {
      guessedCharacters = new ArrayList<Character>();
  }
  @Override
  public char GetGuess(List<Character> clue) {

      char guess = randomCharacter();

      for(int i=0; i < clue.size(); i++) {
          if (guess == clue.get(i)) guess = randomCharacter();
      }


      for(int i=0; i < guessedCharacters.size(); i++) {
          if (guess == guessedCharacters.get(i))
          guess = randomCharacter();
      }
      guessedCharacters.add(guess);

      return guess;

  }

  public char randomCharacter() {
      return (char) (0 + (int)(Math.random()*25) + 97);
  }

}
