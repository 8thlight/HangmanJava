package com.hangman.players;

import com.hangman.WordList;
import junit.framework.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class YourPlayerTest {

    @Test
    public void testCanGetWordsThatMatchLengthSpecified() throws Exception {
        String[] words = {"aboard", "accident"};
        List<String> matches = YourPlayer.getWordMatchingLength(words, 6);
        assertTrue(matches.contains("aboard"));
        assertFalse(matches.contains("accident"));
    }

    @Test
    public void testCanExcludeWordsThatContainMissedChar() throws Exception {
        String[] words = {"aboard", "actual", "active"};
        List<String> matches = YourPlayer.getWordsWithoutChars(words, 'b');
        assertTrue(matches.contains("actual"));
        assertFalse(matches.contains("aboard"));
    }

    @Test
    public void testGivenAPartialMatchedStringFilterOutWordsThatDoNotQualify() throws Exception {
        String[] words = {"aboard", "actual", "active"};
        List<String> matches = YourPlayer.getWordMatchingPattern(words, Arrays.asList('_', 'c', '_', '_', '_', '_'));

        assertTrue(matches.contains("actual"));
        assertFalse(matches.contains("aboard"));
    }

    @Test
    public void testLastGuessedCharIsReturned() throws Exception {
        YourPlayer player = new YourPlayer();
        char first = player.GetGuess(Arrays.asList('e', 'b', 'c'));
        assertEquals(first, player.getLastCharGuessed());
    }

    @Test
    public void testCanGetCorrectLastGuessResult() throws Exception {
        YourPlayer player = new YourPlayer();
        char first = player.GetGuess(Arrays.asList('_', '_', '_'));
        char second = player.GetGuess(Arrays.asList('_', 'e', '_'));
        assertEquals(YourPlayer.RIGHT_GUESS, player.getLastAttemptResult());
        char third = player.GetGuess(Arrays.asList('_', 'e', '_'));
        assertEquals(YourPlayer.WRONG_GUESS, player.getLastAttemptResult());
    }

    @Test
    public void testCanCheckIfWeHaveMadeAtLeastOneRightGuess() throws Exception {
        YourPlayer player = new YourPlayer();
        char first = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertFalse(player.hasOneRightGuess());
        char second = player.GetGuess(Arrays.asList('_', '_', '_'));
        assertFalse(player.hasOneRightGuess());
        char third = player.GetGuess(Arrays.asList('_', 'e', '_'));
        assertTrue(player.hasOneRightGuess());
    }

    @Test
    public void testCanGetTheMostFrequentAppearingCharInWordList() throws Exception {

        String[] words = {"aboard", "actual", "active"};
        char mostFrequent = YourPlayer.getMostFrequentChar(words);
        assertEquals('a', mostFrequent);
    }
}
