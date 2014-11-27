package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  private LinkedList<Character> guessList = new LinkedList<Character>();

  @Override
  public char GetGuess(List<Character> clue) {
    LinkedList<Character> clueList = new LinkedList<Character>(clue);
    Character guessed = 'a';
    if(clueList.size() > 0) {
//      guessed = clueList.pop();
//    if(!guessList.contains(guessed))
//      guessList.add(guessed);
        return guessed;
    } else {
      return guessed;
    }
  }

  public LinkedList getGuesses() {
    return guessList;
  }



}
