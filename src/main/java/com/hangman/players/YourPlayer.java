package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  public  char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};
  List<Character> gueses = new ArrayList();

  @Override
  public char GetGuess(List<Character> currentClue) {



    for(char vowel : vowels)
    {
      if (currentClue.contains(vowel))
      {
        return 'z'; //\
      }

      if (!gueses.contains(vowel)){
        gueses.add(vowel);
        return vowel;
      }
    }

    return 'a';

  }


}
