package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
  YourPlayer player;
  List<Character> alphabet;

  @Before
  public void setup(){
    player = new YourPlayer();
    alphabet = player.getAlphabet();
  }

  @Test
  public void TestAlphabetIsCorrectSize() {
    assertEquals(26, alphabet.size());
  }

  @Test
  public void GuessFirstLetterInArray() {
    char guess = player.GetGuess(alphabet);
    assertEquals('a', guess);
  }

  @Test
  public void TestListOfGuesses() throws Exception {
    player.GetGuess(alphabet);

    List<Character> lettersGuessed = player.getGuessList();
    char guessed = lettersGuessed.get(0);
    assertEquals('a', guessed);
  }
}
