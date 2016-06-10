package com.hangman.players;

import com.hangman.Player;

import java.util.List;

public class YourPlayer implements Player {
    @Override
    public char getGuess(List<Character> currentClue) {
        if(currentClue.contains('e'))
            return 'a';
        return 'e';
    }
}
