package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

      char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('a', guess);
    }

  @Test
  public void GuessAThenB() {
    YourPlayer player = new YourPlayer();
    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('a', guess);
    guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('b', guess);
  }

  //not Testing yet
  public void goodLetters(){
    YourPlayer player = new YourPlayer();

    char guess = player.GetGuess(Arrays.asList('r','s','t','l','n','e'));

    assertEquals('r', guess);
    assertEquals('s', guess);
    assertEquals('t', guess);
    assertEquals('l', guess);
    assertEquals('n', guess);
    assertEquals('e', guess);
  }
}
