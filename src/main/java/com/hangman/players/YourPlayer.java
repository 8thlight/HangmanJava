package com.hangman.players;
import com.hangman.Player;
import java.util.ArrayList;
import java.util.List;

public class YourPlayer implements Player {

  public List<Character> alphabet = new ArrayList<Character>();
  private List<Character> guessedLetters = new ArrayList<Character>();

  @Override
  public char GetGuess(List<Character> currentClue) {
    buildAlphabet();
    char letter = alphabet.get(0);
    guessedLetters.add(letter);
    return letter;
  }

  public List<Character> GetGuessedLetters() {
    return guessedLetters;
  }

  private void buildAlphabet() {
    for (int i = 'a'; i <= 'z'; i++) {
      System.out.print(i);
      alphabet.add((char)i);
    }
  }
}
