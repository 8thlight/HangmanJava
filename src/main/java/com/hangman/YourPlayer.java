package com.hangman;

import java.util.List;

public class YourPlayer implements Player {
    @Override
    public char GetGuess(List<Character> clue) {
        return 'a';
    }
}
