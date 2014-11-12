package com.hangman.players;

import org.junit.Test;

import com.hangman.HangmanGame;
import com.hangman.SimpleAnswerGenerator;

import java.util.Arrays;

import static org.junit.Assert.*;

public class YourPlayerTest {
	
	private SimpleAnswerGenerator simpleAnswerGenerator;
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c', 'd'));

        assertEquals('a', guess);
  
    }
    
    @Test
	public void StoreAllGuess() throws Exception {
        YourPlayer player = new YourPlayer();

        player.GetGuess(Arrays.asList('a', 'b', 'c'));
        
        assertEquals(3, player.GuessList().size());
        
	}
    
    @Test
	public void ReturnNextGuess() throws Exception {
    	YourPlayer player = new YourPlayer();

        player.GetGuess(Arrays.asList('a', 'b', 'c'));
        char nextguess = player.nextGuess();

        assertEquals('b', nextguess);
	}
   
    
    @Test
	public void GuessBaseonList() throws Exception {
    	YourPlayer player = new YourPlayer();
    	HangmanGame game = new HangmanGame();
    	char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));	
    	//simpleAnswerGenerator.setNextAnswer("bca");
        //game.SetAnswerGenerator(simpleAnswerGenerator);
    	
        System.out.print(guess);
        
    	//game.Guess(guess);
    	//game.Guess(guess);
    	//game.Guess(guess);
    	
    	//assertTrue(game.IsOver());
	}
    
}
