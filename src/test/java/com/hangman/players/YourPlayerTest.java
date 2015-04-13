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

        assertEquals('a', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));

        assertEquals('a', guess);
    }

    @Test
    public void DoNotGuessAIfAlreadyGuessed(){
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'a', '_'));

        assertEquals('e', guess);
    }

    @Test
    public void ReturnsTrueIfMoreVowelsToBeReturned(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', 'e', 'i', '_', 'o');
        boolean result = player.moreVowelsToBeReturned(currentClue);

        assertEquals(true, result);
    }

    @Test
    public void ReturnsFalseIfMoreVowelsToBeReturned(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', 'e', 'i', '_', 'o', 'u', 'y');
        boolean result = player.moreVowelsToBeReturned(currentClue);

        assertEquals(false, result);
    }

    @Test
    public void GetNextVowelInList(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', '_', '_', 'i');

        char result = player.nextVowelToReturn(currentClue);

        assertEquals('e', result);
    }

    @Test (expected = IllegalStateException.class)
    public void ThrowsExceptionWhenNoMoreVowelsToBeReturned(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', 'e', 'i', '_', 'o', 'u', 'y');
        player.nextVowelToReturn(currentClue);
    }

    @Test
    public void ReturnConsonantInOrderOfPopularity(){
        YourPlayer player = new YourPlayer();
        List<Character> currentClue = Arrays.asList('a', 'e', 'i', '_', 'o', 'u', 'y');

        char guess = player.GetGuess(currentClue);

        assertEquals('s', guess);
    }

}
