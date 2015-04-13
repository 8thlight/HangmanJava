package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void GuessesRWhenThereAreNoSuccessfulCharactersGuessedYet() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals('r', guess);
    }

    @Test
    public void GuessesAWhenThereAreSuccessfulCharactersGuessedThatAreNotR() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('m', '_', 'n'));
        assertEquals('r', guess);
    }

    @Test
    public void DoesNotGuessAWhenAIsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', 'r', '_'));
        assertEquals('r', guess);
    }

    @Test
    public void WillAnswerWithRSTLNEInOrder() {
        YourPlayer player = new YourPlayer();
        char guess1 = player.GetGuess(Arrays.asList('_'));
        assertEquals('r', guess1);
        char guess2 = player.GetGuess(Arrays.asList('_'));
        assertEquals('s', guess2);
        char guess3 = player.GetGuess(Arrays.asList('_'));
        assertEquals('t', guess3);
        char guess4 = player.GetGuess(Arrays.asList('_'));
        assertEquals('l', guess4);
        char guess5 = player.GetGuess(Arrays.asList('_'));
        assertEquals('n', guess5);
        char guess6 = player.GetGuess(Arrays.asList('_'));
        assertEquals('e', guess6);
    }

    @Test
    public void WillAnswerAlphabeticallyAfterTheFirst6Attempts() {
        YourPlayer player = new YourPlayer();
        for (int i = 0; i < 6; i++) {
            player.GetGuess(Arrays.asList('_'));
        }
        nextGuessIs(player, 'a');
        nextGuessIs(player, 'b');
        nextGuessIs(player, 'c');
        nextGuessIs(player, 'd');
        nextGuessIs(player, 'f');
        nextGuessIs(player, 'g');
        nextGuessIs(player, 'h');
        nextGuessIs(player, 'i');
        nextGuessIs(player, 'j');
        nextGuessIs(player, 'k');
        nextGuessIs(player, 'l');
        nextGuessIs(player, 'm');
        nextGuessIs(player, 'n');
        nextGuessIs(player, 'o');
        nextGuessIs(player, 'p');
        nextGuessIs(player, 'q');
        nextGuessIs(player, 'u');
        nextGuessIs(player, 'v');
        nextGuessIs(player, 'w');
        nextGuessIs(player, 'x');
        nextGuessIs(player, 'y');
        nextGuessIs(player, 'z');
    }

    private void nextGuessIs(YourPlayer player, char expectedGuess) {
        char guess = player.GetGuess(Arrays.asList('_'));
        assertEquals(expectedGuess, guess);
    }

}
