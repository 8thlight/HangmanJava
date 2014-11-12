package com.hangman.players;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {

	@Test 
	public void alwaysGuessA() throws Exception  { 
       YourPlayer player = new YourPlayer(); 
       player.setGuesses(Arrays.asList('a', 'b', 'c')); 
       char guess = player.GetGuess(Arrays.asList('a', 'b', 'c')); 
       assertEquals('a', guess); 
   } 

 @Test 
 public void setsAllGuessed() throws Exception { 
     YourPlayer player = new YourPlayer(); 
     player.setGuesses(Arrays.asList('a', 'b', 'c')); 
     player.GetGuess(Arrays.asList('a', 'b', 'c')); 

     assertEquals(Arrays.asList('a', 'b', 'c'), player.getLatestClue()); 
 } 

} 

