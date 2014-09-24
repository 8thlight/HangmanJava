package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
  private int _intA = 97;
  private int _counter = 0;
  private Set<Character> _set = new HashSet<Character>();

  @Override
  public char GetGuess(List<Character> clue) {

    char[] chars = Character.toChars(_intA + _counter++);
    Character c = chars[0];
    while (_set.contains(c)) {
      chars = Character.toChars(_intA + _counter++);
      c = chars[0];
    }

    _set.add(c);
    //System.out.println("**" + c);
    return c;
  }
}
