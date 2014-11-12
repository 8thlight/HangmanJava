package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  public List<Character> guessed = new ArrayList<Character>();
  private ArrayList<Character> availableCharacters = new ArrayList<Character>();

  public YourPlayer() {
    String str = "abcdefghijklmnopqrstuvwxyz";

    for(Character c : str.toCharArray()) {
      availableCharacters.add(c);
    }
  }

  public void buildGuessed(List<Character> clue) {
    for (Character c : clue) {
      if (!c.equals('_') && guessed.indexOf(c) == -1) {
        guessed.add(c);
      }
    }
  }

  public List<Character> getGuessed() {
    return guessed;
  }

  public Character gimmeACharacter() {
    if (availableCharacters.size() < 1)
      return 'a';

    Character c = availableCharacters.remove( randInt() );

    while (availableCharacters.size() > 0 && guessed.indexOf(c) != -1) {
      c = availableCharacters.remove( randInt() );
    }

    guessed.add(c);

    return c;
  }

  
  @Override
  public char GetGuess(List<Character> clue) {
    buildGuessed(clue);
    return gimmeACharacter();
  }

  // http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
  public int randInt() {

    int min = 1;
    int max = availableCharacters.size();

    return rand(min, max);
  }

  public int rand(int min, int max) {
    Random random = new Random();
    return (random.nextInt(max - min + 1) + min);
  }
}
