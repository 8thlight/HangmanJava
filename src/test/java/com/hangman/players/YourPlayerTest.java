package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
  public void shouldReturnCorrectWordLength() {
    player.buildGuessed(Arrays.asList('_','_','a'));
    assertEquals(3, player.getWordLength());
  }

  @Test
  public void tracksUnknownClue() {
    player.buildGuessed(Arrays.asList('_','_','a'));
    assertEquals(2, player.getUnknown());
  }

  @Test
  public void shouldGetCharacterNotGuessed() {
    player.GetGuess(Arrays.asList('_'));

    Character c = player.gimmeACharacter();

    assertFalse(c == '!');

    assertNotNull(c);
  }

  @Test
  public void shouldReturnVowelsGuessed() {
    player.GetGuess(Arrays.asList('_', 'a', 'e'));

    assertEquals(2, player.getVowelsGuessed());
  }

  @Test
  public void shouldMarkCharacterAsGuessed() {

    assertEquals(-1, player.getGuessed().indexOf('a'));
    player.markCharacterAsGuessed('a');
    assertFalse(player.getGuessed().indexOf('a') == -1);


  }

  @Test
  public void realGuess() {
    player.buildGuessed(Arrays.asList('_'));

    List<Character> cs = player.getGuessed();
    assertEquals(0, cs.size());

    Character c = player.gimmeACharacter();

    cs = player.getGuessed();
    assertEquals(cs.size(), 1);
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
