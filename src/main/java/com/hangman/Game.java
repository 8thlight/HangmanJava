package com.hangman;

import java.util.List;

public interface Game {
    List<Character> currentClue();
    int numGuesses();
    boolean isOver();
    void guess(char guess);
    boolean isWinner();
}