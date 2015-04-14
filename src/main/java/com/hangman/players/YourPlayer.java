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

//    private static List<Character> COMMON_REPEATS =
//            Arrays.asList('e', 't', 'o', 'n', 's', 'r', 'd', 'l', 'c', 'm', 'f', 'g', 'p');

    List<Character> exhaustedGuesses = new ArrayList<>();
    Integer remainingBlanks;
    Character lastGuess;

    @Override
    public char GetGuess(List<Character> currentClue) {
        if (isFirstGuess()) {
            remainingBlanks = getRemainingBlanks(currentClue);
            return saveAndGuess(LETTERS[0]);
        }
        return guessNextLetter(currentClue);
    }

    private char guessNextLetter(List<Character> currentClue) {
        if (lastGuessWasCorrect(currentClue)) {
            // TODO: don't repeat guess letters that don't repeat in English
//            if (COMMON_REPEATS.contains(lastGuess)) {
            return saveAndGuess(lastGuess);
//            }
        }
        exhaustedGuesses.add(lastGuess);
        return saveAndGuess(LETTERS[exhaustedGuesses.size()]);
    }

    private boolean lastGuessWasCorrect(List<Character> clue) {
        Integer blanks = getRemainingBlanks(clue);
        if (blanks < remainingBlanks) {
            remainingBlanks = blanks;
            return true;
        }
        return false;
    }

    private boolean isFirstGuess() {
        return exhaustedGuesses.size() == 0 &&
                lastGuess == null &&
                remainingBlanks == null;
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

    private char saveAndGuess(char c) {
        lastGuess = c;
        return c;
    }
}
