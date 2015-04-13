package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

// private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; // 52 chars
// private String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 26 chars

 private String characters = "abcdefghijklmnopqrstuvwxyz"; // 26 chars

  private Set<Integer> askedIndexes = new HashSet<>();

  // Just random guessing
  @Override
  public char GetGuess(List<Character> currentClue) {

    // check if all chars asked thus we don't get into endless loop
    if(askedIndexes.size() == characters.length()){
      return '#'; // we must return something
    }

    // exclude chars coming from the clue
    for(Character c : currentClue){
      int foundIndex = characters.indexOf(c);
      if( foundIndex > 0){
        askedIndexes.add(foundIndex);
      }
    }

    // picking an unasked char
    int nextIndex = new Random().nextInt(characters.length());
    while(askedIndexes.contains(nextIndex)){
      nextIndex = new Random().nextInt(characters.length());
    }
    askedIndexes.add(nextIndex);

    return characters.charAt(nextIndex);
  }

}
