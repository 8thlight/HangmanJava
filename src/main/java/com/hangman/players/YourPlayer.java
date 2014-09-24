package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
  private boolean isFirstTime = true;
  private ArrayList<Character> _clue;

  private void init(List<Character> clue) {
    _clue = new ArrayList<Character>(clue);
  }

  @Override
  public char GetGuess(List<Character> clue) {
    if (isFirstTime) {
      init(clue);
      isFirstTime = false;
    }

    Character c = _clue.get(0);
    _clue.remove(0);

    return c;
  }
}
