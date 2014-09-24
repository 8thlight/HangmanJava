package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {


  @Test
  public void TestMakeAlphaBet() {
    YourPlayer player = new YourPlayer();

    List<Character> alphabet = player.getAlphabet();
    assertEquals(26, alphabet.size());

  }

  @Test
  public void GuessFirstLetterInArray() {
    YourPlayer player = new YourPlayer();

    List<Character> alphabet = player.getAlphabet();
    char guess = player.GetGuess(alphabet);
    assertEquals('a', guess);

  }
}
