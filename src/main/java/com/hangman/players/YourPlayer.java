package com.hangman.players;
import com.hangman.Player;

import java.lang.reflect.Array;
import java.util.*;

public class YourPlayer implements Player {

  private ArrayList<Character>  myGuessA =
    new ArrayList<Character>(Arrays.asList
      ('a', 'e', 'i', 'o', 'u', 'c', 'd', 'k', 'b', 'f', 'g'));

  static private int i = 0;

  @Override
  public char GetGuess(List<Character> clue) {
    i++;
    if(i < myGuessA.size()) {
      return myGuessA.get(i);
    } else {
      return 'z';
    }
  }
}
