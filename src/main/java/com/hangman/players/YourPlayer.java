package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
  private final Random random = new Random();
  private final Set<Character> usedLetters = new HashSet<>();
  private final List<Character> letters ;

  public YourPlayer() {
    List<Character>  tempLetters = new ArrayList<>();
    for (char i = 'a'; i <= 'z'; i++) {
       tempLetters.add((char) i);
    }

    letters = Collections.unmodifiableList(tempLetters);
  }

  void addLetter(Character c) {
    usedLetters.add(c);
  }

  @Override
  public char GetGuess(List<Character> currentClue) {
    if (currentClue == null || currentClue.isEmpty()) {
      return ' ';
    }

    if (currentClue.stream().noneMatch((c) -> c == '_')) {
      return ' ';
    }

    if (usedLetters.size() == 26) {
      usedLetters.clear();
    }

    Character newCharacter;

    do {
      newCharacter = getRandomLetter();
    }
    while (usedLetters.contains(newCharacter));

    usedLetters.add(newCharacter);

    return newCharacter;
  }

  private char getRandomLetter() {
    int randomIndex = random.nextInt(letters.size());

    return letters.get(randomIndex);
  }

}
