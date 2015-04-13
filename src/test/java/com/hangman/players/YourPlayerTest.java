package com.hangman.players;

import org.junit.*;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import com.hangman.Player;

public class YourPlayerTest {
    Player player;

    @Before
    public void setup() {
        player = new YourPlayer();
    }
    @Test
    public void GuessesAWhenThereAreNoSuccessfulCharactersGuessedYet() {

        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));

        assertEquals('a', guess);
    }

//    @Test
//    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotA() {
//
//        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));
//
//        assertEquals('a', guess);
//    }


    @Test
    public void ShouldTryAllVowelsWhenNoMatch() {
        List<Character> noMatch = Arrays.asList('_', '_', '_');
        assertEquals('a',  player.GetGuess(noMatch));
        assertEquals('e',  player.GetGuess(noMatch));
        assertEquals('i',  player.GetGuess(noMatch));
        assertEquals('o',  player.GetGuess(noMatch));
        assertEquals('u',  player.GetGuess(noMatch));
    }

    @Test
    public void ShouldTryConsonentsWhenTwoMatches() {
        List<Character> noMatch = Arrays.asList('_', 'a', '_', 'o', '_');
        assertEquals('s', player.GetGuess(noMatch));
    }
}
