package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
  @Test
  public void AlwaysGuessA() {
    YourPlayer player = new YourPlayer();

    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('e', guess);
  }

  @Test
  public void AlwaysGuessD() {
    YourPlayer player = new YourPlayer();
    char guess = player.GetGuess(Arrays.asList('a', 'b'));
    assertEquals('i', guess);
  }
}
