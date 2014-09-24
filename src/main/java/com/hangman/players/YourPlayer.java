package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  private List<Character> lettersGuessed = new ArrayList<Character>();

  public List<Character> getAlphabet() {
    char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    List<Character> alphabet = new ArrayList<Character>();

    for (char c : letters) {
      alphabet.add(c);
    }

    return alphabet;
  }


  @Override
  public char GetGuess(List<Character> clue) {
    lettersGuessed.add(clue.get(0));
    return clue.get(0);
  }

  public List<Character> getGuessList() {
    return lettersGuessed;
  }

  public List<Character> shuffleAlphabet() {
    long seed = System.currentTimeMillis();
    List<Character> shuffled = getAlphabet();
    Collections.shuffle(shuffled, new Random(seed));

    return shuffled;
  }
}
