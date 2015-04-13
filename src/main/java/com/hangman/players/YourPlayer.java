package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {

  private Character getRandomCharacter(){
    Random r = new Random();
    char c = (char)(r.nextInt(26) + 'a');
    return c;
  }

  private Character getRandomCharacterUsingClue(List<Character> currentClue){
    Character randomChar = getRandomCharacter();
    if (currentClue.contains(randomChar)){
      System.out.println("'"+randomChar + "' is already guessed -> guess a new one");
      getRandomCharacterUsingClue(currentClue);
    }
    return randomChar;
  }

  private boolean isAllCharactersAsked(List<Character> currentClue){
    for (int i = 0; i < 26; i++){
      char c = (char) (i+ 'a');
      if (!currentClue.contains(c)){
        return false;
      }
    }
    return true;
  }


  @Override
  public char GetGuess(List<Character> currentClue) {
    if (isAllCharactersAsked(currentClue)){
      return 'a';
    };

    return getRandomCharacterUsingClue(currentClue);
  }
}
