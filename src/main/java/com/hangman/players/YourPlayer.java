package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

    Queue<Character> bestGuesses = new LinkedList<Character>();
    Set<Character> pastCorrectGuesses = new HashSet<Character>();

    public YourPlayer() {
        setBestGuesses();
    }

    private void setBestGuesses() {
        String bestGuessesString = "etaoinshrdlucmfwypvbgkqjxz";
        for(char c : bestGuessesString.toCharArray()) {
            bestGuesses.add(c);
        }
    }

    @Override
    public char GetGuess(List<Character> currentClue) {
        updateCorrectGuesses(currentClue);
        Character guess = bestGuesses.poll();
        if (guess == 'q' && !pastCorrectGuesses.contains('u')) {
            guess = bestGuesses.poll();
        }
        return guess;
    }

    private void updateCorrectGuesses(List<Character> currentClue) {
        for (Character guess: currentClue) {
            if (guess != '_') {
                pastCorrectGuesses.add(guess);
            }
        }
    }

}
