package com.hangman.players;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

  YourPlayer player;

  @Before
  public void setup() {
    player = new YourPlayer();
  }

  @Test
  public void AlwaysGuessA() {
    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

    assertEquals('a', guess);
  }

  @Test
  public void CheckForGuessedAnswers() throws Exception
  {
    LinkedList<Character> guesses = new LinkedList<Character>(Arrays.asList('a', 'b', 'c', 'a', 'b'));
    LinkedList guessList = new LinkedList();

    player.GetGuess(guesses);
    guessList = player.getGuesses();

//    assertEquals(5, guessList.size());


  }


}
