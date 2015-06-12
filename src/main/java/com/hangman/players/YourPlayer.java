package com.hangman.players;
import com.hangman.Player;
import com.sun.org.apache.xerces.internal.impl.xs.util.LSInputListImpl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {

  private List<Character> vowels = new LinkedList<Character>(Arrays.asList('e', 'a', 'i', 'o', 'u'));
  private List<Character> consonants = new LinkedList<Character>(Arrays.asList('r', 's', 't', 'l', 'n', 'd', 'g', 'b', 'c', 'm', 'p', 'f', 'h', 'v', 'w', 'y', 'j', 'k', 'q', 'x', 'z'));

  public char GetGuess(List<Character> clue) {
    return MakeEducatedGuess(clue);
  }

  private int EmptySpaces(List<Character> clue) {
    int spaces = 0;

    for(char i : clue) {
      if (i == '_') {
        spaces++;
      }
    }
    return spaces;
  }

  private char MakeEducatedGuess(List<Character> clue) {
    Random randomizer = new Random();
    int spaces = EmptySpaces(clue);

    if (spaces == clue.size()) {
      return vowels.remove(0);
    } else if (spaces == clue.size() - 1) {
      return vowels.remove(0);
    } else {
      return consonants.remove(randomizer.nextInt(consonants.size() -1));
    }
  }
}
