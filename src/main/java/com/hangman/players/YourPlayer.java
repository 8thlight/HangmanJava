package com.hangman.players;

import com.hangman.Player;

import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player
{
    int firstChar = (int) 'a';

    List<Integer> pickedList = new LinkedList<Integer>();
    @Override
    public char GetGuess(List<Character> currentClue) {
        for (Character clue:currentClue){
            if( ! clue.equals('_')){
                pickedList.add(Integer.valueOf(clue));
            }
        }
        int guess = firstChar;
        if(isPicked(guess)){
            guess = guessFromPickedList(guess);
        }
        System.out.println("guess=" + (char) guess);
        return (char) (guess);
    }

    private int guessFromPickedList(int guess) {
        int charCount=0;
        while (isPicked(guess) && charCount<26) {
            charCount++;
            guess++;
        }
        return guess;
    }
    boolean isPicked(int guess){
        System.out.println("checking " + (char) guess + " at " + pickedList.indexOf(Integer.valueOf(guess)));
        return pickedList.indexOf(Integer.valueOf(guess))>-1;
    }
}
