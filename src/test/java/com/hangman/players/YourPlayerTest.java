package com.hangman.players;

import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void hasCounterInitializedToZeroThatIncrementsWithGuesses() {
        YourPlayer player = new YourPlayer();
        assertEquals(0, player.counter);

        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(1, player.counter);

        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(2, player.counter);

        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(3, player.counter);

        player.GetGuess(Arrays.asList('_', '_', '_'));
        assertEquals(4, player.counter);
    }

    @Test
    public void guessLettersInOrderOfFrequency() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('_', 'b', 'c'));

        assertEquals('e', guess);
        assertEquals('t', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('a', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('o', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('i', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('n', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('s', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('h', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('r', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('d', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('l', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('c', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('u', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('m', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('w', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('f', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('g', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('y', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('p', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('b', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('v', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('k', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('j', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('x', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('q', player.GetGuess(Arrays.asList('_', '_', '_')));
        assertEquals('z', player.GetGuess(Arrays.asList('_', '_', '_')));
    }

    @Test
    public void storeAllLetters() {
        YourPlayer player = new YourPlayer();

        assertEquals(player.letters(0), 'e');
        assertEquals(player.letters(1), 't');
        assertEquals(player.letters(2), 'a');
        assertEquals(player.letters(3), 'o');
        assertEquals(player.letters(4), 'i');
        assertEquals(player.letters(5), 'n');
        assertEquals(player.letters(6), 's');
        assertEquals(player.letters(7), 'h');
        assertEquals(player.letters(8), 'r');
        assertEquals(player.letters(9), 'd');
        assertEquals(player.letters(10), 'l');
        assertEquals(player.letters(11), 'c');
        assertEquals(player.letters(12), 'u');
        assertEquals(player.letters(13), 'm');
        assertEquals(player.letters(14), 'w');
        assertEquals(player.letters(15), 'f');
        assertEquals(player.letters(16), 'g');
        assertEquals(player.letters(17), 'y');
        assertEquals(player.letters(18), 'p');
        assertEquals(player.letters(19), 'b');
        assertEquals(player.letters(20), 'v');
        assertEquals(player.letters(21), 'k');
        assertEquals(player.letters(22), 'j');
        assertEquals(player.letters(23), 'x');
        assertEquals(player.letters(24), 'q');
        assertEquals(player.letters(25), 'z');
    }
}
