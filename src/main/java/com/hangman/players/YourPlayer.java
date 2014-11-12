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

      List<Character> charsList = Arrays.asList('a', 'b', 'c', 'd', 'e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');


      for(Character letter: charsList) {
          if(clue.contains(letter)) {

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
