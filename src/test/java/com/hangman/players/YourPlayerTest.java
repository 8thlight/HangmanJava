package com.hangman.players;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class YourPlayerTest {
    @Test
    public void alwaysGuessA() {
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

    @Test
    public void generate9RandomCharacters() throws Exception {
        LinkedList<Character> characters;
        YourPlayer player = new YourPlayer();
        characters = player.generateRandomCharacters(9);

        assertEquals(9, characters.size());
    }

    @Test
    public void constructorGeneratesCorrectList() throws Exception {
        LinkedList<Character> characters = new LinkedList<Character>();
        final String mostCommonLetters = "etaoinshrdlu";

        for (int i = 0; i < mostCommonLetters.length(); i++)
            characters.add(mostCommonLetters.charAt(i));

        YourPlayer player = new YourPlayer(characters);

        assertEquals(mostCommonLetters.length(), player.getGuesses().size());
    }

}
