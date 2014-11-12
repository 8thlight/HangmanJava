package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  public List<Character> guessed = new ArrayList<Character>();
  private ArrayList<Character> availableCharacters = new ArrayList<Character>();
  private int wordLength = 0;
  private int unknown = 0;
  private List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u');

  public YourPlayer() {
    String str = "abcdefghijklmnopqrstuvwxyz";

    for(Character c : str.toCharArray()) {
      availableCharacters.add(c);
    }
  }

  public int getVowelsGuessed() {
    int count = 0;

    for(Character v: vowels) {
      if (guessed.indexOf(v) != -1)
        count++;
    }

    return count;
  }

  public void buildGuessed(List<Character> clue) {
    wordLength = clue.size();

    for (Character c : clue) {
      if (c.equals('_')) {
        unknown++;
        continue;
      }
      if (guessed.indexOf(c) == -1) {
        guessed.add(c);
      }
    }
  }

  public List<Character> getGuessed() {
    return guessed;
  }

  public Character getRandomCharacter() {
    Character c = availableCharacters.remove(randInt());
    return c;
  }

  public Character getRandomVowel() {
    return 'a';
  }

  public void markCharacterAsGuessed(Character c) {
    guessed.add(c);
  }

  public boolean hasMore() {
    return availableCharacters.size() > 0;
  }

  public Character gimmeACharacter() {
    if (!hasMore())
      return '!';

    Character c;

    do {
      c = getRandomCharacter();
    } while (isGuessed(c) && hasMore() );

    markCharacterAsGuessed(c);

    return c;
  }

  public boolean isGuessed(Character c) {
    return guessed.indexOf(c) != -1;
  }


  @Override
  public char GetGuess(List<Character> clue) {
    buildGuessed(clue);
    return gimmeACharacter();
  }

  // http://stackoverflow.com/questions/363681/generating-random-integers-in-a-range-with-java
  public int randInt() {

    int min = 1;
    int max = availableCharacters.size();

    return rand(min, max) - 1;
  }

  public int rand(int min, int max) {
    Random random = new Random();
    return (random.nextInt(max - min + 1) + min);
  }

  public int getWordLength() {
    return wordLength;
  }

  public int getUnknown() {
    return unknown;
  }

}
