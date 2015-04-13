package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;

public class YourPlayer implements Player {

    private static final char[] LETTERS = {
            'e', 't', 'a', 'o', 'i', 'n',
            's', 'h', 'r', 'd', 'l', 'c',
            'u', 'm', 'y', 'f', 'g', 'y',
            'p', 'b', 'v', 'k', 'j', 'x',
            'q', 'z'
    };

    List<Character> incorrectGuesses = new ArrayList<>();

    @Override
    public char GetGuess(List<Character> currentClue) {
        return guessNextLetter();
    }

    private char guessNextLetter() {
        return saveAndGuess(LETTERS[incorrectGuesses.size()]);
    }

    private int getRemainingBlanks(List<Character> currentClue) {
        int blanks = 0;
        for (Character c : currentClue) {
            if (c.equals('_')) {
                ++blanks;
            }
        }
        return blanks;
    }

    private char saveAndGuess(char c) {
        incorrectGuesses.add(c);
        return c;
    }
}
