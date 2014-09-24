package com.hangman.players;

import com.hangman.Player;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
    private LinkedList<Character> guesses;
    private List<Character> latestClue;

    public YourPlayer() {
        this.guesses = new LinkedList<Character>();
        final String mostCommonLetters = "etaoinshrdlu";
        for (int i = 0; i < mostCommonLetters.length(); i++)
            guesses.add(mostCommonLetters.charAt(i));
    }

    public YourPlayer(LinkedList<Character> guesses) {
        this.guesses = new LinkedList<Character>();
        for (Character character : guesses) {
            this.guesses.add(character);
        }
    }

    public void setGuesses(List<Character> chars) {
        this.guesses = new LinkedList<Character>();
        for(char guess : chars) {
            this.guesses.add(guess);
        }
    }

    public LinkedList<Character> getGuesses() {
        return guesses;
    }

    @Override
    public char GetGuess(List<Character> clue) {
        latestClue = clue;
        if (guesses.size() > 0)
            return guesses.pop();
        return 0;
    }

    public List<Character> getLatestClue() {
        return latestClue;
    }

    public LinkedList<Character> generateRandomCharacters(int count) {
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";
        LinkedList<Character> characters = new LinkedList<Character>();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            characters.add(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return characters;
    }
}
