package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class YourPlayer implements Player {
    @Override
    public char GetGuess(List<Character> clue) {
        String possibleChars = "abcdefghijklmnopqrstuvwxyz";
        Random rand = new Random(System.currentTimeMillis());
        boolean keepGoing = true;
        char retVal = '@';

        while(keepGoing) {
            int nextTry = rand.nextInt(26);
            boolean charFound = false;
            char pickedChar = possibleChars.charAt(nextTry);

            for (Character clueChar : clue) {
                if (pickedChar == clueChar.charValue()) {
                    charFound = true;
                }
            }

            if (!charFound) {
                retVal = pickedChar;
                break;
            }
        }
        return(retVal);
    }
}
