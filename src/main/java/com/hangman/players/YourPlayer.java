package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {

    private List<Character> guessedChars = new ArrayList<>();

    private List<Character> highFrequencyCharSet = Arrays.asList('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q');

    private int getHighFrequencyCharSetSize() {
        return highFrequencyCharSet.size();
    }

    public List<Character> getHighFrequencyCharSet() {
        return highFrequencyCharSet;
    }

    public void setHighFrequencyCharSet(List<Character> highFrequencyCharSet) {
        this.highFrequencyCharSet = highFrequencyCharSet;
    }

    @Override public char getGuess(List<Character> currentClue) {
        Character guess = getNextCharacter();
        guessedChars.add(guess);
        return guess;
    }

    private char getNextCharacter() {
        Character next = 'e';
        for (Character character : highFrequencyCharSet) {
            if (!guessedChars.contains(character)) {
                next = character;
                break;
            }
        }
        return next;
    }

    /*
    private Character getNextCharacter() {
        Character next = highFrequencyCharSet.get(new Random().nextInt(getHighFrequencyCharSetSize()));
        while (guessedChars.contains(next)) {
            next = getNextCharacter();
        }
        return next;
    }*/
}
