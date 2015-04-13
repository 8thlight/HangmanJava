package com.hangman.players;
import com.hangman.HangmanGame;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {

  private LinkedList<Character> guesses;
  private List<Character> latestClue;

  public static final List<Character> mostCommon2LeastLetters;

  static {
    mostCommon2LeastLetters = Arrays.asList(
            'e', 'a', 'r', 'i', 'o', 't', 'n', 's', 'l', 'c', 'u', 'd', 'p', 'm', 'h', 'g',
            'b', 'f', 'y', 'w', 'k', 'v', 'x', 'z', 'j', 'q');
  }

  public YourPlayer() {
    guesses = new LinkedList<Character>();
    this.SetGuesses(mostCommon2LeastLetters);
  }

  private void SetGuesses(List<Character> chars) {
    this.guesses = new LinkedList<Character>();
    for(char guess : chars) {
      this.guesses.add(guess);
    }
  }

  @Override
  public char GetGuess(List<Character> clue) {
    if (clue == null) {
      return 0;
    }

    latestClue = clue;
    if (guesses.size() > 0) {
      char c = guesses.pop();
      if (!latestClue.contains(c))
        return c;
    }

    return 0;
  }

  public List<Character> GetLatestClue() {
    return latestClue;
  }
}
