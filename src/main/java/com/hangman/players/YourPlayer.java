package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
  List<Character> guesses;
  List<Character> best = Arrays.asList('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r');

  public YourPlayer() {
      guesses = new ArrayList<Character>();
  }

  @Override
  public char GetGuess(List<Character> clue) {
    char guess = 'e';

    for (char g: guesses) {
        if (g == 'e') {
             guess = 't';
            break;
        }
    }

    guesses.add(guess);
    return guess;
  }
}
