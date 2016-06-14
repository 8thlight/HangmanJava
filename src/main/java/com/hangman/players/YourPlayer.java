package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class YourPlayer implements Player {
    private String chars = "etaoinshrdlcubmwfgypvkjxqz";
    private int nextIndex = 0;

    @Override
    public char getGuess(List<Character> currentClue) {
        List<Character> toExclude = currentClue.stream()
                .filter(c -> c != null)
                .collect(toList());

        return getNextChar(toExclude);
    }

    public char getNextChar(List<Character> excludes) {
        char c = chars.charAt(nextIndex++);
        return excludes.contains(c) ? getNextChar(excludes) : c;
    }
}
