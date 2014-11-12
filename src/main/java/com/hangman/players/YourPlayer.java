package com.hangman.players;
import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
    private List<Character> alreadyGuessed = new ArrayList<Character>();
    private List<Character> popularSeed = new ArrayList<Character>();
    private List<Character> clue = new ArrayList<Character>();

    @Override
    public char GetGuess(List<Character> clue) {
        boolean hasGuess = false;
        char newGuess = 'a';

        SeedPopularLetters(Arrays.asList('e', 't','a', 'o', 'i', 'n', 's', 'h', 'r', 'd', 'l', 'u', 'c', 'm', 'f', 'w', 'y', 'p', 'v', 'b', 'g', 'k', 'j', 'q', 'x', 'z'));

        this.clue = new ArrayList<Character>(clue);

        newGuess = getNextLetter(newGuess);

        System.out.println(newGuess);

        return newGuess;
        //return 'a';
    }

    private char getNextLetter(char nextLetter) {

        boolean hasGuess = false;
        char newGuess = nextLetter;

        /**********
         * Seeded Guess
         */
        char seedGuess = getNextSeedLetter();
        if (seedGuess != 0) {
            return seedGuess;
        }


        /**********
         * Non - Seeded Guess
         */
        // otherwise we look for the next letter

        for (newGuess = nextLetter; false == hasGuess; ) {
            // found in already guessed and clue?
            boolean found = false;

            // check if char in clue
            for (Character aClue : clue) {
                if (aClue == newGuess) {
                    found = true;
                    //System.out.println(newGuess);
                    newGuess++;
                    break;
                }
            }

            // check if char in alreadyGuessed
            for (Character guessed : alreadyGuessed) {
                if (guessed == newGuess) {
                    found = true;
                    //System.out.println(newGuess);
                    newGuess++;
                    break;
                }
            }

            if (!found) {
                hasGuess = true;
            }
        }

        alreadyGuessed.add(newGuess);

        return newGuess;
        //return 'a';
    }

    private char getNextSeedLetter() {
        boolean hasGuess = false;
        char newGuess = 'a';

        //for (newGuess = getNextLetter(newGuess); false == hasGuess; ) {
        for (Character seed : popularSeed) {
            newGuess = seed;

            //System.out.println(newGuess);

            // found in already guessed and clue?
            boolean found = false;

            // check if char in alreadyGuessed
            for (Character guessed : alreadyGuessed) {
                if (guessed == newGuess) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                hasGuess = true;
                break;
            }
        }

        if (hasGuess == true) {
            alreadyGuessed.add(newGuess);
            return newGuess;
        } else {
            return 0;
        }
    }


    public void SeedPopularLetters(List<Character> popularSeed) {
        this.popularSeed = new ArrayList<Character>(popularSeed);
    }
}
