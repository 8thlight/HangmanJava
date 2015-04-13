package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('e', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', 'e', '_', 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void DoNotGuessAIfAlreadyGuessed(){
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));

        assertEquals('e', guess);
    }

    @Test
    public void ReturnConsonantInOrderOfPopularity(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', 'e', 'i', '_', 'o', 'u', 'y');

        char guess = player.GetGuess(currentClue);

        assertEquals('s', guess);
    }

    @Test
    public void ShouldAddToListOfUsedChars(){
        YourPlayer player = new YourPlayer();

        player.addToUsedChars('a');

        assertEquals(true, player.usedChars.contains('a'));
    }
}
