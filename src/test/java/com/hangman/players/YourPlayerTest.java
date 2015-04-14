package com.hangman.players;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YourPlayerTest {

    @Test
    public void onlyGuessLetters() {

        YourPlayer player = new YourPlayer();

        List<Character> guessedLetters = new ArrayList<Character>();
        int count = 0;

        try {
            while (true) {
                char guess = player.GetGuess(guessedLetters);
                guess = Character.toLowerCase(guess);
                Assert.assertTrue(('a' <= guess) && (guess <= 'z'));
                guessedLetters.add(guess);
                count++;
            }
        }
        catch (Exception ex) {
            Assert.assertTrue(count == 26);
        }
    }

    @Test
    public void doNotGuessDuplicateLetter() {

        YourPlayer player = new YourPlayer();
        char guess = player.GetGuess(Arrays.asList('b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        Assert.assertEquals('a', guess);

        player = new YourPlayer();
        guess = player.GetGuess(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));
        Assert.assertEquals('m', guess);

        player = new YourPlayer();
        guess = player.GetGuess(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y'));
        Assert.assertEquals('z', guess);
    }
}
