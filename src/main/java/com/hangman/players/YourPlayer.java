package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

  private static final char NO_GUESS = 0x00;

  private final Random rnd = new Random();

  private List<Character> commonChars = new ArrayList<>(Arrays.asList('r','s','t','l','n','e'));
  private LinkedList<Character> otherChars = new LinkedList<>(commonChars);
  private Stack<Character> guessStack = new Stack<>();
  private List<Character> currentClue;
  private int guessCount = 0;



  @Override
  public char GetGuess(List<Character> currentClue) {
    this.guessCount++;
    this.currentClue = currentClue;

    List<Integer> emptySpotList = getEmptySpotPositions();
    if (emptySpotList.isEmpty()) {
      return NO_GUESS;
    }

    Character guess = NO_GUESS;
    if (!commonChars.isEmpty()) {
      for (char c : commonChars) {
        if (!currentClue.contains(c)) {
          guess = c;
          break;
        }
      }
    }

    if (guess > NO_GUESS) {
      commonChars.remove(guess);
      guessStack.push(guess);
      return guess;
    }

    guess = getCharacter();

    return guess;
  }

  public List<Integer> getEmptySpotPositions() {
    List<Integer> resList = new ArrayList<>();
    for (int i = 0; i < this.currentClue.size(); i++) {
      if (this.currentClue.get(i) == '_') {
        resList.add(i);
      }
    }
    return resList;
  }

  int getTotalGuessCount() {
    return this.guessCount;
  }

  Character getLastGuess() {
    if (guessStack.isEmpty()) {
      return NO_GUESS;
    }
    return guessStack.peek();
  }

  Character getCharacter() {
    char rndChar = NO_GUESS;
    while (rndChar == NO_GUESS || guessStack.contains(rndChar)) {
      rndChar = getRandomCharacter();
    }
    guessStack.push(rndChar);
    return rndChar;
  }

  private Character getRandomCharacter() {
    int i = rnd.nextInt(26) + 97;
    return (char)i;
  }

}
