package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
  @Override
  public char GetGuess(List<Character> currentClue) {
    if (moreVowelsToBeReturned(currentClue)){
      return nextVowelToReturn(currentClue);
    }

    return returnNextPopularConsonant(currentClue);
  }

  public boolean moreVowelsToBeReturned(List<Character> currentClue){
    List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u', 'y');
    if (currentClue.containsAll(list)){
      return false;
    }else{
      return true;
    }
  }

  public char nextVowelToReturn(List<Character> currentClue){
    if (!currentClue.contains('a')){
      return 'a';
    }
    if (!currentClue.contains('e')){
      return 'e';
    }
    if (!currentClue.contains('i')){
      return 'i';
    }
    if (!currentClue.contains(('o'))){
      return 'o';
    }
    if (!currentClue.contains('u')) {
      return 'u';
    }
    if (!currentClue.contains('y')) {
      return 'y';
    }
    throw new IllegalStateException("All vowels existed. No more vowels remain to be returned");
  }

  public char returnNextPopularConsonant(List<Character> currentClue){
    if (!currentClue.contains('s')){
      return 's';
    }
    if (!currentClue.contains('t')){
      return 't';
    }
    if (!currentClue.contains('r')){
      return 'r';
    }
    if (!currentClue.contains('l')){
      return 'l';
    }
    if(!currentClue.contains('n')){
      return 'n';
    }
    if(!currentClue.contains('p')){
      return 'p';
    }
    if(!currentClue.contains('g')){
      return 'g';
    }
    if(!currentClue.contains('h')){
      return 'h';
    }
    if(!currentClue.contains('z')){
      return 'z';
    }
    if(!currentClue.contains('m')){
      return 'm';
    }
    if(!currentClue.contains('x')){
      return 'x';
    }
    if(!currentClue.contains('c')){
      return 'c';
    }
    if(!currentClue.contains('d')){
      return 'd';
    }
    if(!currentClue.contains('b')){
      return 'b';
    }
    if(!currentClue.contains('f')){
      return 'f';
    }
    if(!currentClue.contains('j')){
      return 'j';
    }
    if(!currentClue.contains('k')){
      return 'k';
    }
    if(!currentClue.contains('q')){
      return 'q';
    }
    if(!currentClue.contains('v')){
      return 'v';
    }
    if(!currentClue.contains('w')){
      return 'w';
    }
    throw new IllegalStateException("All consonants exhausted.");
  }

}
