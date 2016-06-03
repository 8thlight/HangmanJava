package com.hangman;
import java.util.ArrayList;
import java.util.List;

class FakeGame implements Game {
    private boolean done;
    private ArrayList<Character> guesses;
    private char lastGuess;
    private List<Character> clue;
    private boolean winner;
    private int numGuesses;

    FakeGame() {
        this.done = false;
        this.guesses = new ArrayList<>();
    }

    void SetDone() {
        done = true;
    }

    public boolean isOver() {
        return done;
    }

    void SetLastGuess(char c) {
        lastGuess = c;
    }

    List<Character> Guesses() {
        return guesses;
    }

    @Override
    public void guess(char guess) {
        guesses.add(guess);
        if (guess == lastGuess)
            SetDone();
    }

    @Override
    public List<Character> currentClue() {
        return clue;
    }

    @Override
    public boolean isWinner() {
      return winner;
    }

    @Override
    public int numGuesses() {
        return numGuesses;
    }

    void SetToWinner() {winner = true;}

    void SetCurrentClue(List<Character> clue) {
        this.clue = clue;
    }

    void SetNumGuesses(int guesses) {
        numGuesses = guesses;
    }
}
