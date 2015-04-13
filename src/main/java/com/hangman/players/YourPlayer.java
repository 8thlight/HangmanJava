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

    char rndChar = getRandomCharacter(null);
    guessStack.push(rndChar);
    //TODO: check guessStack

    return rndChar;
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

  public int getTotalGuessCount() {
    return this.guessCount;
  }

  public Character getLastGuess() {
    if (guessStack.isEmpty()) {
      return NO_GUESS;
    }
    return guessStack.peek();
  }

  private Character getRandomCharacter(List<Character> exlusionList) {
    int i = rnd.nextInt(26) + 97;
    // TODO: check exlusionList first
    return (char)i;
  }

}
