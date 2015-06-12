package com.hangman.players;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;

public class YourPlayerTest {
    YourPlayer player = new YourPlayer();

    @Test
    public void DoesNotGuessAIfExists() {
        char guess = player.GetGuess(Arrays.asList('_', 'a'));

        assertNotEquals('a', guess);
    }

    @Test
    public void DoesNotGuessCharactersThatExist() {
      for(char c = 'a'; c <= 'z'; c++){
        List<Character> clue = allLetters();
        clue.remove((Character) c);
        clue.add('_');

        char guess = player.GetGuess(clue);

        assertEquals("Expected: " + c + " got: " + guess, c, guess);
      }
    }

    @Test
    public void guessesTWhenEExists(){
      char guess = player.GetGuess(Arrays.asList('_', 'e'));

      assertEquals('t', guess);
    }

    //case
    private static List<Character> allLetters(){
      List<Character> result = new ArrayList();
      for(char c = 'a'; c <= 'z'; c++){
        result.add(c);
      }
      return result;
    }
}
