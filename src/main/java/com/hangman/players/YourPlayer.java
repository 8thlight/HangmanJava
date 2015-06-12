package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
  private char[] ALL = {
    'e',
    't',
    'a',
    'o',
    'i',
    'n',
    's',
    'r',
    'h',
    'd',
    'l',
    'u',
    'c',
    'm',
    'f',
    'y',
    'w',
    'g',
    'p',
    'b',
    'v',
    'k',
    'x',
    'q',
    'j',
    'z'
  };

  @Override
  public char GetGuess(List<Character> clue) {
    for(char c : ALL){
      if(!clue.contains(c)){
        return c;
      }
    }
    return 'a';
  }
}
