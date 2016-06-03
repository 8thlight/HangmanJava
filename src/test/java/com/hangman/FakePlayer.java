package com.hangman;
import java.util.LinkedList;
import java.util.List;

class FakePlayer implements Player {
    private LinkedList<Character> guesses;
    private List<Character> latestClue;

    FakePlayer() {
        guesses = new LinkedList<>();
    }

    void SetGuesses(List<Character> chars) {
        this.guesses = new LinkedList<>();
        this.guesses.addAll(chars);
    }

    @Override
    public char getGuess(List<Character> clue) {
        latestClue = clue;
        if (guesses.size() > 0)
            return guesses.pop();
        return 0;
    }

    List<Character> GetLatestClue() {
        return latestClue;
    }
}
