package com.hangman;

import com.hangman.Game;

import java.util.ArrayList;
import java.util.List;

public class FakeGame implements Game {
    private boolean done;
    private ArrayList<Character> guesses;
    private char lastGuess;
    private List<Character> clue;
    private boolean winner;
    private int numGuesses;

    public FakeGame() {
        this.done = false;
        this.guesses = new ArrayList<Character>();
    }

    public void SetDone() {
        done = true;
    }

    public boolean IsOver() {
        return done;
    }

    public void SetLastGuess(char c) {
        lastGuess = c;
    }

    public List<Character> Guesses() {
        return guesses;
    }

    public void Guess(char guess) {
        guesses.add(guess);
        if (guess == lastGuess)
            SetDone();
    }

    public List<Character> CurrentClue() {
        return clue;
    }

    public boolean IsWinner() {
      return winner;
    }

    public int numGuesses() {
        return numGuesses;
    }

    public void SetToWinner() {winner = true;}

    public void SetCurrentClue(List<Character> clue) {
        this.clue = clue;
    }

    public void SetNumGuesses(int guesses) {
        numGuesses = guesses;
    }
}
