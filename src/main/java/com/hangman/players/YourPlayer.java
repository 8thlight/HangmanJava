package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
    List<Character> guesses;
    List<Character> best = Arrays.asList('e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r');

    public YourPlayer() {
      guesses = new ArrayList<Character>();
    }

    @Override
    public char GetGuess(List<Character> clue) {
        return nextBestGuess();
    }

    public char nextBestGuess() {
        int i = -1;
        int b;

        for (char g : guesses) {
            b = best.indexOf(g);
            if ( b > i ) {
                i = b;
            }
        }

        guesses.add(best.get(i+1));

        return best.get(i+1);
    }
}
