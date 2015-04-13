package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class YourPlayer implements Player {

    private static final char[] LETTERS = {
            'e', 't', 'a', 'o', 'i', 'n',
            's', 'h', 'r', 'd', 'l', 'c',
            'u', 'm', 'y', 'f', 'g', 'y',
            'p', 'b', 'v', 'k', 'j', 'x',
            'q', 'z'
    };

    List<Character> incorrectGuesses = new ArrayList<>();
    Set<Character> correctGuesses = new TreeSet<>();
    Integer remainingBlanks;

    @Override
    public char GetGuess(List<Character> currentClue) {
        return guessNextLetter(currentClue);
    }

    private char guessNextLetter(List<Character> currentClue) {
        if (lastGuessWasCorrect(currentClue)) {
            return saveAndGuess(LETTERS[correctGuesses.size() - 1]);
        }
        return saveAndGuess(LETTERS[incorrectGuesses.size()]);
    }

    private Integer getRemainingBlanks(List<Character> currentClue) {
        int blanks = 0;
        for (Character c : currentClue) {
            if (c.equals('_')) {
                ++blanks;
            }
        }
        return blanks;
    }

    private boolean lastGuessWasCorrect(List<Character> clue) {
        Integer blanks = getRemainingBlanks(clue);
        if (remainingBlanks != null && !blanks.equals(remainingBlanks)) {
            remainingBlanks = blanks;
            addCorrectGuess();
            return true;
        }
        return false;
    }

    private void addCorrectGuess() {
        int index = incorrectGuesses.size();
        if (index > 0) {
            --index;
        }
        char lastGuess = incorrectGuesses.remove(index);
        correctGuesses.add(lastGuess);
    }

    private char saveAndGuess(char c) {
        incorrectGuesses.add(c);
        return c;
    }
}
