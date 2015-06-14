package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
  private List<Character> vowels;
  private char[] consonents;

  public YourPlayer() {
    this.vowels = GuessList.vowels;
    this.consonents = GuessList.consonants;
  }

  @Override
  public char GetGuess(List<Character> clue) {
    char randomChar = guessRandom();
    System.out.println(randomChar);

    return randomChar;
  }

  public int getRandomNumber(int randomNumber) {
      Random random = new Random();
      return random.nextInt(randomNumber);
  }

  public char guessRandom() {
      int randomIndex;
      char randomChar;

      if (vowels.size() != 0) {
          randomIndex = getRandomNumber(vowels.size());
          randomChar = vowels.get(randomIndex);
      } else if (consonents.length != 0) {
          randomIndex = getRandomNumber(consonents.length);
          randomChar = consonents[randomIndex];
      } else {
          System.out.println("poop");
          randomChar = 'a';
      }
      return randomChar;
  }

  public List<Character> getVowels() {
      return vowels;
  }

  public char[] getConsonents() {
      return consonents;
  }

  public char[] removeChar(char[] charArray, char character) {
    char[] modifiedArray;

    modifiedArray = charArray;

    return modifiedArray;
  }
}
