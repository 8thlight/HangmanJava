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
    public void GuessesRWhenThereAreSuccessfulCharactersGuessedThatAreNotR() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('r', '_', 'r'));
        assertEquals('r', guess);
    }

    @Test
    public void DoesNotGuessRWhenAIsInTheClueAsWell() {
        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('_', 'e', '_'));
        assertEquals('r', guess);
    }

    @Test
    public void WillAnswerWithMostCommonLetters() {
        YourPlayer player = new YourPlayer();
        nextGuessIs(player, 'e');
        nextGuessIs(player, 't');
        nextGuessIs(player, 'a');
        nextGuessIs(player, 'o');
        nextGuessIs(player, 'i');
        nextGuessIs(player, 'n');
        nextGuessIs(player, 's');
        nextGuessIs(player, 'h');
        nextGuessIs(player, 'r');
        nextGuessIs(player, 'd');
        nextGuessIs(player, 'l');
        nextGuessIs(player, 'u');
        nextGuessIs(player, 'c');
        nextGuessIs(player, 'm');
        nextGuessIs(player, 'f');
        nextGuessIs(player, 'w');
        nextGuessIs(player, 'y');
        nextGuessIs(player, 'p');
        nextGuessIs(player, 'v');
        nextGuessIs(player, 'b');
        nextGuessIs(player, 'g');
        nextGuessIs(player, 'k');
        nextGuessIs(player, 'q');
        nextGuessIs(player, 'j');
        nextGuessIs(player, 'x');
        nextGuessIs(player, 'z');
    }

    private void nextGuessIs(YourPlayer player, char expectedGuess) {
        char guess = player.GetGuess(Arrays.asList('_'));
        assertEquals(expectedGuess, guess);
    }

}
