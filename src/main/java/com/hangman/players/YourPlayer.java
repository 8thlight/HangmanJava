package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YourPlayer implements Player {

    private ArrayList<Character> guessed = new ArrayList<Character>();
    private int count = 0;

  @Override
  public char GetGuess(List<Character> clue) {

      List<Character> charsList = Arrays.asList('a', 'e', 'i', 'o', 'u', 'r', 's', 't', 'l', 'n','m','n','p', 'b', 'c', 'd','f','g','h','j','k','l','q','v','w','x','y','z');


      for(Character letter: charsList) {
          if(!guessed.contains(letter)) {

              guessed.add(letter);
              count++;
              break;
          }
      }

      char guess;
      if(count>0)
          guess = guessed.get(count-1);
      else
          guess = 'a';
      return guess;

  }

  public ArrayList<Character> GuessedAlready() {
      return guessed;
  }
}
