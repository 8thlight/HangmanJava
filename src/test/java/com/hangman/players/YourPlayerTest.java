package com.hangman.players;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class YourPlayerTest {
    @Test
    public void AlwaysGuessA() {
        YourPlayer player = new YourPlayer();

        char guess = player.GetGuess(Arrays.asList('a', 'b', 'c'));

        assertEquals('a', guess);
    }

    @Test
    public void GetsNewGuessEachTime() throws Exception {
        YourPlayer player = new YourPlayer();
        ArrayList<Character> wordSoFar = new ArrayList<Character>();

        for (int xctr = 0; xctr < 26; xctr++) {
            wordSoFar.add(new Character('_'));
        }

        char guess = ' ';

        for (int xctr = 0; xctr < 26; xctr++) {
            guess = player.GetGuess(wordSoFar);

            for (Character inList : wordSoFar) {
                //System.out.println("Guess: " + (new Character(guess).toString()) + ", curchar: " + inList.toString());
                assertTrue(inList.charValue() != guess);
            }

            for (int yctr = 0; yctr < 26; yctr++) {
                Character theChar = wordSoFar.get(yctr);
                if (theChar.charValue() == '_') {
                    wordSoFar.set(yctr, guess);
                    break;
                }
            }
        }

    }
}
