package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  public static char[] vowels = {'a', 'e', 'i', 'o', 'u', 'y'};

  @Override
  public char GetGuess(List<Character> currentClue) {

     List gueses = new ArrayList<String>();

    for(char vowel : vowels)
    {
      if (currentClue.contains(vowel))
      {
        return 'z'; //constanant
      }

      if (!gueses.contains(String.valueOf(vowel)))
      {
        gueses.add(String.valueOf(vowel));
        return vowel;
      }

    }

    return 'a';

  }


}
