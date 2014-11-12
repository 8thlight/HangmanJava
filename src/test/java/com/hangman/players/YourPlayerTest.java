package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class YourPlayerTest {

  public YourPlayer player;

  @Before
  public void setup() {
    player = new YourPlayer();
  }

  @Test
  public void buildGuessedList() {
    ArrayList<Character> c = new ArrayList<Character>();

    c.add('a');

    player.buildGuessed(c);

    assertEquals(c, player.getGuessed());
  }

  @Test
  public void doesNotIncludeUnderscoreInGuessed() {
    player.buildGuessed(Arrays.asList('_'));

    List<Character> l = player.getGuessed();

    assertEquals(-1, l.indexOf('_'));
  }


  @Test
  public void shouldGetCharacter() {
    Character c = player.gimmeACharacter();
    assertNotNull(c);
  }

  @Test
  public void shouldGetCharacterNotGuessed() {
    player.GetGuess(Arrays.asList('_'));

    Character c = player.gimmeACharacter();

    assertNotNull(c);
  }

//  @Test
//  public void AlwaysGuessA() {
//    YourPlayer player = new YourPlayer();
//
//    char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));
//
//    assertEquals('a', guess);
//  }
}
