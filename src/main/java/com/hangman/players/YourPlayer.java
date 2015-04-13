package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

    private Queue<Character> letters;

    public YourPlayer() {

        letters = new LinkedList<Character>(Arrays.asList('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q', 'z'));
    }

  @Override
  public char GetGuess(List<Character> clue) {

      char c;

      do {
          c = letters.poll();
      }
      while (clue.contains(c));

      return c;
  }
}
