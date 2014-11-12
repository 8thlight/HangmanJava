package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

    private LinkedList<Character> vowels = new LinkedList<Character>();

    public YourPlayer() {
        for(char vowel : Arrays.asList('a', 'e', 'i', 'o', 'u'))
            vowels.add(vowel);
    }

    @Override
    public char GetGuess(List<Character> clue) {
        return vowels.pop();
    }
}
