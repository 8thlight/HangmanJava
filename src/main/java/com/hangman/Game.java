package com.hangman;

import java.util.List;

public interface Game {
    List<Character> CurrentClue();

    int numGuesses();

    public boolean IsOver();
    void Guess(char guess);
    public boolean IsWinner();
}