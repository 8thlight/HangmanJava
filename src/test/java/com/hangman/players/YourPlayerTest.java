package com.hangman.players;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    YourPlayer player;
    @Before
    public void setup() {
        player = new YourPlayer();

    }
    @Test
    public void HasListOfCharacters() throws Exception {
        List<Character> vowels = player.getVowels();
        char[] consonants = player.getConsonents();
        //assertEquals(vowels.contains()
        //assertArrayEquals(GuessList.vowels, vowels);
        assertArrayEquals(GuessList.consonants, consonants);

    }

    @Test
    public void ReturnsRandomNumber() throws Exception {
        int guess = player.getRandomNumber(10);
        boolean lessThan = guess < 10;
        assertEquals(true, lessThan);
    }
    @Test
    public void ReturnsRandomVowel() throws Exception {
        char guess = player.guessRandom();

        assertEquals(true, Character.isLetter(guess));
    }
    @Test
    public void removesCharacterFromArray() throws Exception {
        char[] array = player.removeChar(new char[]{'a','b','c'}, 'a');

        assertEquals(array[0], 'b');
    }

    @Test
    public void GuessRandomCharacter() {

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals(true, Character.isLetter(guess));
    }

}
