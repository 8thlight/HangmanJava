package com.hangman.players;
import com.hangman.Player;

import java.util.*;

import static com.hangman.Letters.*;

public class YourPlayer implements Player {
    private final Set<Character> guessedLetters = new HashSet<>();
    private int initialLetterGuesses = 0;
    private int mostCommonlyUsedLetterGuesses = 0;

    @Override
    public char GetGuess(List<Character> clue) {
        Character firstLetter = clue.get(0);

        if(isUnknown(firstLetter)) {
            Character guess = mostCommonlyUsedStartingLetters.get(initialLetterGuesses++);
            guessedLetters.add(guess);
            return guess;
        } else {
            Character guess = mostCommonlyUsedLetters.get(mostCommonlyUsedLetterGuesses++);

            if(guessedLetters.contains(guess)) {
                return mostCommonlyUsedLetters.get(mostCommonlyUsedLetterGuesses++);
            } else {
                return guess;
            }
        }
    }

    private boolean isUnknown(Character c) {
        return c.equals('_');
    }
}
