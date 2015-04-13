package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YourPlayer implements Player {
  List<Character> usedChars = new ArrayList<>();
  @Override
  public char GetGuess(List<Character> currentClue) {
    return returnNextPopularChoice(currentClue);
  }

  public char returnNextPopularChoice(List<Character> currentClue){
    if (!currentClue.contains('e') && !usedChars.contains('e')){
      addToUsedChars('e');
      return 'e';
    }
    if (!currentClue.contains('a') && !usedChars.contains('a')){
      addToUsedChars('a');
      return 'a';
    }
    if (!currentClue.contains('s') && !usedChars.contains('s')){
      addToUsedChars('s');
      return 's';
    }
    if (!currentClue.contains('t') && !usedChars.contains('t')){
      addToUsedChars('t');
      return 't';
    }
    if (!currentClue.contains('r') && !usedChars.contains('r')){
      addToUsedChars('r');
      return 'r';
    }
    if (!currentClue.contains('l') && !usedChars.contains('l')){
      addToUsedChars('l');
      return 'l';
    }
    if(!currentClue.contains('n') && !usedChars.contains('n')){
      addToUsedChars('n');
      return 'n';
    }
    if (!currentClue.contains('i') && !usedChars.contains('i')){
      addToUsedChars('i');
      return 'i';
    }
    if (!currentClue.contains(('o')) && !usedChars.contains('o')){
      addToUsedChars('o');
      return 'o';
    }
    if(!currentClue.contains('c')  && !usedChars.contains('c')){
      addToUsedChars('c');
      return 'c';
    }
    if(!currentClue.contains('d')  && !usedChars.contains('d')){
      addToUsedChars('d');
      return 'd';
    }
    if(!currentClue.contains('b')  && !usedChars.contains('b')){
      addToUsedChars('b');
      return 'b';
    }
    if(!currentClue.contains('f')  && !usedChars.contains('f')){
      addToUsedChars('f');
      return 'f';
    }
    if(!currentClue.contains('j')  && !usedChars.contains('j')){
      addToUsedChars('j');
      return 'j';
    }
    if (!currentClue.contains('u')  && !usedChars.contains('u')) {
      addToUsedChars('u');
      return 'u';
    }
    if (!currentClue.contains('y') && !usedChars.contains('y')) {
      addToUsedChars('y');
      return 'y';
    }
    if(!currentClue.contains('p') && !usedChars.contains('p')){
      addToUsedChars('p');
      return 'p';
    }
    if(!currentClue.contains('g')  && !usedChars.contains('g')){
      addToUsedChars('g');
      return 'g';
    }
    if(!currentClue.contains('h')  && !usedChars.contains('h')){
      addToUsedChars('h');
      return 'h';
    }
    if(!currentClue.contains('z')  && !usedChars.contains('z')){
      addToUsedChars('z');
      return 'z';
    }
    if(!currentClue.contains('m')  && !usedChars.contains('m')){
      addToUsedChars('m');
      return 'm';
    }
    if(!currentClue.contains('x')  && !usedChars.contains('x')){
      addToUsedChars('x');
      return 'x';
    }
    if(!currentClue.contains('k')  && !usedChars.contains('k')){
      addToUsedChars('k');
      return 'k';
    }
    if(!currentClue.contains('q')  && !usedChars.contains('q')){
      addToUsedChars('q');
      return 'q';
    }
    if(!currentClue.contains('v')  && !usedChars.contains('v')){
      addToUsedChars('v');
      return 'v';
    }
    if(!currentClue.contains('w')  && !usedChars.contains('w')){
      addToUsedChars('w');
      return 'w';
    }
    throw new IllegalStateException("All consonants exhausted.");
  }

   public void addToUsedChars(char addThisChar){
      usedChars.add(addThisChar);
   }

}
