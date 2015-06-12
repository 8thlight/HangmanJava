package com.hangman;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LettersTest {
    @Test
    public void inMostCommonlyUsedOrder_returnsTheAllLettersOfTheEnglishAlphabet() {
        assertThat(Letters.mostCommonlyUsedLetters.size(), is(26));
    }

    @Test
    public void inMostCommonlyUsedOrder_returnsTheMostCommonlyUsedEnglishLettersInOrder() {
        List<Character> expectedLetters = Arrays.asList(
            'e', 't', 'a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'c', 'u', 'm', 'w', 'f', 'g', 'y', 'p', 'b', 'v', 'k', 'j', 'x', 'q', 'z'
        );
        assertThat(Letters.mostCommonlyUsedLetters, is(expectedLetters));
    }

    @Test
    public void mostCommonlyUsedStartingLetters_returnsTheAllLettersOfTheEnglishAlphabet() {
        assertThat(Letters.mostCommonlyUsedStartingLetters.size(), is(26));
    }

    @Test
    public void mostCommonlyUsedStartingLetters_returnsTheMostCommonStartingLettersInOrder() {
        List<Character> expectedLetters = Arrays.asList(
            's', 'a', 'c', 'm', 'p', 'r', 't', 'b', 'f', 'g', 'd', 'l', 'h', 'i', 'e', 'n', 'o', 'w', 'u', 'v', 'j', 'k', 'q', 'y', 'z', 'x'
        );
        assertThat(Letters.mostCommonlyUsedStartingLetters, is(expectedLetters));
    }
}