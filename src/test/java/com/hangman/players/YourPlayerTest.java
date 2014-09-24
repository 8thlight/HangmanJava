package com.hangman.players;

import org.junit.Test;
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
  public void AlwaysGuessAThenB() {
    YourPlayer player = new YourPlayer();

    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('a', guess);

    guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('b', guess);
  }

  @Test
  public void AlwaysGuessAThenBThenC() {
    YourPlayer player = new YourPlayer();

    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('a', guess);

    guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('b', guess);

    guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
    assertEquals('c', guess);
  }
}
