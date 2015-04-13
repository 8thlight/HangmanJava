package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


public class YourPlayer implements Player {

  private final List<Character> charsNotGuessedYet  = new ArrayList<>();
  private final List<Character> charsAlreadyGuessed = new ArrayList<>();

  private final List<String> wordsList = new ArrayList<>();


  public YourPlayer(String[] wordsList) {
    // initialize non-guessed characters
    for (char c = 'a'; c <= 'z'; ++c) {
      this.charsNotGuessedYet.add(c);
    }

    // copy the word list
    this.wordsList.addAll(Arrays.asList(wordsList));
  }

  @Override
  public char GetGuess(List<Character> currentClue) {
    Character guess = null;

    StringBuilder pattern = new StringBuilder(currentClue.size());
    int nextYetUnknownCharacterIndex = 0;
    int i = 0;
    for (Character c : currentClue) {
      if (c.equals('_')) {
        nextYetUnknownCharacterIndex = i;
        pattern.append(".");
      } else {
        // known character, act like if it was already guessed
        this.charsNotGuessedYet.remove(c);
        this.charsAlreadyGuessed.add(c);
        pattern.append(c);
      }
      ++i;
    }
    Pattern wordPattern = Pattern.compile(pattern.toString());

    for (String word : this.wordsList) {
      if ((word.length() == currentClue.size()) && wordPattern.matcher(word).matches()) {
        guess = word.charAt(nextYetUnknownCharacterIndex);
        if (!this.charsAlreadyGuessed.contains(guess)) {
          break;
        }
      }
    }

    if (guess == null) {
      // no word matching, just get the next not-yet-guessed character
      guess = this.charsNotGuessedYet.isEmpty() ?
              'a' :
              this.charsNotGuessedYet.get(0);
    }

    // store char as already guessed
    this.charsNotGuessedYet.remove(guess);
    this.charsAlreadyGuessed.add(guess);
    return guess;
  }

}
