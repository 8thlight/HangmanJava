package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  private final Random rnd = new Random();
  private final List<Character> guesses = new ArrayList<>();

  private final char[] VOWELS = {'a','e','i','o','u'};

  private List<Character> currentClue;
  private int guessCount = 0;

  @Override
  public char GetGuess(List<Character> currentClue) {
    this.guessCount++;
    this.currentClue = currentClue;

    List<Integer> emptySpotList = getEmptySpotPositions();
    if (emptySpotList.isEmpty()) {
      return ' ';
    }

    

    return 'a';
  }

  public List<Integer> getEmptySpotPositions() {
    List<Integer> resList = new ArrayList<>();
    for (int i = 0; i < this.currentClue.size(); i++) {
      if (this.currentClue.get(i) == '_') {
        resList.add(i);
      }
    }
    return resList;
  }

  public int getTotalGuessCount() {
    return this.guessCount;
  }

}
