package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  private ArrayList<Character> alphabet = new ArrayList();

  public YourPlayer(){
    alphabet.add('a');    alphabet.add('b');    alphabet.add('c');    alphabet.add('d');    alphabet.add('e');
    alphabet.add('f');    alphabet.add('g');    alphabet.add('h');    alphabet.add('i');    alphabet.add('j');
    alphabet.add('k');    alphabet.add('l');    alphabet.add('m');    alphabet.add('n');    alphabet.add('o');
    alphabet.add('p');    alphabet.add('q');    alphabet.add('r');    alphabet.add('s');    alphabet.add('t');
    alphabet.add('u');    alphabet.add('v');    alphabet.add('w');    alphabet.add('x');    alphabet.add('y');
    alphabet.add('z');

  }

  @Override
  public char GetGuess(List<Character> clue) {
    //clue is where you are currently at in the game

    int indexOfLetter = 0;

    for(Character currentChar : clue){
      if(alphabet.contains(currentChar)){
        alphabet.remove(alphabet.indexOf(currentChar));
      }
    }

    if(alphabet.contains('r'))
      indexOfLetter = (alphabet.indexOf('r'));
    else if(alphabet.contains('s'))
      indexOfLetter = (alphabet.indexOf('s'));
    else if(alphabet.contains('t'))
      indexOfLetter = (alphabet.indexOf('t'));
    else if(alphabet.contains('l'))
      indexOfLetter = (alphabet.indexOf('l'));
    else if(alphabet.contains('n'))
      indexOfLetter = (alphabet.indexOf('n'));
    else if(alphabet.contains('e'))
      indexOfLetter = (alphabet.indexOf('e'));
    else if(alphabet.contains('a'))
      indexOfLetter = (alphabet.indexOf('a'));
    else if(alphabet.contains('i'))
      indexOfLetter = (alphabet.indexOf('i'));
    else if(alphabet.contains('o'))
      indexOfLetter = (alphabet.indexOf('o'));
    else if(alphabet.contains('u'))
      indexOfLetter = (alphabet.indexOf('u'));
    char letterGuess = alphabet.remove(indexOfLetter);

    return letterGuess;
  }
}
