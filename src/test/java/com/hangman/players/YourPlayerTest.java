package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

      char guess = player.GetGuess(Arrays.asList('b','c','r','s','t','l','n','e'));

        assertEquals('a', guess);
    }

  //@Test
  public void GuessAThenB() {
    YourPlayer player = new YourPlayer();
    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('a', guess);
    guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('b', guess);
  }

  @Test
  public void goodLetters(){
    YourPlayer player = new YourPlayer();

    char guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('r', guess);
    guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('s', guess);
    guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('t', guess);
    guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('l', guess);
    guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('n', guess);
    guess = player.GetGuess(Arrays.asList('_'));
    assertEquals('e', guess);
  }
}
