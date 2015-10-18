package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
  @Override
  public char GetGuess(List<Character> currentClue) {
    return 'a';
  }
}
