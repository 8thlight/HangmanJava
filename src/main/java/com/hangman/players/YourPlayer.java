package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
    char[] totalGuesses = new char[9];
    private int indx = 0;

    @Override
    public char GetGuess(List<Character> clue) {
        List<Character> clues  = clue;
        char guessChar  = returnRandomVal(clues);
        totalGuesses[indx]= guessChar;
        indx++;
        return guessChar;

    }

    public char returnRandomVal( List<Character> clue ){
        Random random = new Random();
        int val = random.nextInt(clue.size());
        return clue.get(val);
    }


    public  char[] returnPreviousGuesses(){
        return totalGuesses;
    }
}
