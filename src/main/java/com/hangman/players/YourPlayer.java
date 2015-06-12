package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
  @Override
  public char GetGuess(List<Character> clue) {
    for(char c = 'a'; c <= 'z'; c++){
      if(!clue.contains(c)){
        return c;
      }
    }
    return 'a';
  }
}
