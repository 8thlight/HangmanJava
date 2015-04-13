package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class YourPlayer implements Player {
    List<Character> vowels = Arrays.asList('a','e','i','o','u');
    List<Character> cons = Arrays.asList('s','m');
    List<Character> guessed = new ArrayList<Character>();

    @Override
    public char GetGuess(List<Character> currentClue) {
        if (countMatches(currentClue) >= 2) {
            for (Character ch : cons) {
                if (!guessed.contains(ch)) {
                    return remember(ch);
                }
            }
        }
        else {
            for (Character ch : vowels) {
                if (!guessed.contains(ch)) {
                    return remember(ch);
                }
            }
        }
        return remember('z');
    }

    private int countMatches(List<Character> currentClue) {
        int matches = 0;
        for (Character ch : currentClue) {
            if (!ch.equals('_')) {
                matches++;
            }
        }
        return matches;
    }
    private char remember(char ch) {
        guessed.add(ch);
        return ch;
    }
}
