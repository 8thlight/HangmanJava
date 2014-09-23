package com.hangman;

import java.util.List;

public interface Player {
    char GetGuess(List<Character> clue);
}
