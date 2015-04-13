package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

    Queue<Character> bestGuesses = new LinkedList<Character>();

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
        char guess = bestGuesses.poll();
        return guess;
    }

}
