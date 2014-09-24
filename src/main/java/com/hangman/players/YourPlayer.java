package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

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

    return clue.get(0);
  }
}
