package com.hangman.players;

import com.hangman.Player;
import com.hangman.WordList;

import java.util.*;

public class YourPlayer implements Player {

  private Map<Character, Integer> characters = new HashMap<Character, Integer>();

  private Set<Character> guessedCharacters = new HashSet<Character>();

  {
    buildCharactersMap();
  }

  @Override
  public char GetGuess(List<Character> currentClue) {
    guessedCharacters.addAll(currentClue);
    Character c = getMostFrequentCharacter();
    guessedCharacters.add(c);
    System.out.println(c);
    return c;
  }

  private void buildCharactersMap() {
    for (String s: WordList.words)
      for (Character c: s.toCharArray()) {
        if (characters.get(c) == null)
          characters.put(c, 1);
        else
          characters.put(c, characters.get(c) + 1);
      }
  }

  public char getMostFrequentCharacter() {

    Map.Entry mostFrequentCharacter = null;

    for (Map.Entry e: characters.entrySet()) {
      if (mostFrequentCharacter == null)
        mostFrequentCharacter = e;

      if (guessedCharacters.contains(e.getKey()))
        continue;

      if ((Integer)mostFrequentCharacter.getValue() < (Integer)e.getValue())
        mostFrequentCharacter = e;

    }

    return (Character)mostFrequentCharacter.getKey();

  }

}
