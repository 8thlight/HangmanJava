package com.hangman;

import java.util.List;

public interface Player {
    char getGuess(List<Character> clue);
}
