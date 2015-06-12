package com.hangman.players;

import com.hangman.Letters;
import com.hangman.Player;
import org.junit.Test;

import java.util.Arrays;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static com.hangman.Letters.*;

public class YourPlayerTest {
    @Test
    public void GetGuess_guessesTheFirstMostCommonlyUsedStartingLetterForTheFirstGuess() {
        Player player = new YourPlayer();

        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is(mostCommonlyUsedStartingLetters.get(0)));
    }

    @Test
    public void GetGuess_guessesTheFirstLetterUntilItMatchesIt() {
        Player player = new YourPlayer();

        // initial letters
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('s'));
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('a'));
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('c'));
    }

    @Test
    public void GetGuess_guessesTheRemainingLettersUsingTheMostCommonlyUsedLettersWhenTheFirstLetterIsFound() {
        Player player = new YourPlayer();

        // initial letters
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('s'));
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('a'));

        // most common letters
        assertThat(player.GetGuess(Arrays.asList('a', '_', '_')), is('e'));
    }

    @Test
    public void GetGuess_doesNotGuessLettersThatHaveAlreadyBeenGuessed() {
        Player player = new YourPlayer();

        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('s'));
        assertThat(player.GetGuess(Arrays.asList('_', '_', '_')), is('a'));
        assertThat(player.GetGuess(Arrays.asList('a', '_', '_')), is('e'));
        assertThat(player.GetGuess(Arrays.asList('a', '_', '_')), is('t'));
        assertThat(player.GetGuess(Arrays.asList('a', '_', '_')), is('o'));
    }
}
