package com.hangman.players;

import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;

public class YourPlayer implements Player {
    private List<Character> guesses;

    public YourPlayer() {
        guesses = new ArrayList<>();
    }

    @Override
    public char getGuess(List<Character> currentClue) {
        if(!currentClue.contains(('e')))
            return 'e';
        if(!currentClue.contains(('a')))
            return 'a';
        if(!currentClue.contains('i'))
            return 'i';

        if(!guesses.contains('b')) {
            guesses.add('b');
            return 'b';
        }

        return 'c';
    }
}
