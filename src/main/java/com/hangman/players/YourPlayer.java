package com.hangman.players;

import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class YourPlayer implements Player {

    private Queue<Character> lettersMostToLeastUsed;

    public YourPlayer() {

        lettersMostToLeastUsed = new LinkedList<Character>(Arrays.asList('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q', 'z'));
    }

  @Override
  public char GetGuess(List<Character> clue) {

      char c;

      do {
          c = lettersMostToLeastUsed.poll();
      }
      while (clue.contains(c));

      return c;
  }
}
