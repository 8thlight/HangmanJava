package com.hangman.players;
import com.hangman.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class YourPlayer implements Player {
    int counter = 0;

    @Override
    public char GetGuess(List<Character> clue) {
        return letters(counter++);
    }

    public char letters(int index) {
        Character[] letters = new Character[26];
        letters[0] = 'e';
        letters[1] = 't';
        letters[2] = 'a';
        letters[3] = 'o';
        letters[4] = 'i';
        letters[5] = 'n';
        letters[6] = 's';
        letters[7] = 'h';
        letters[8] = 'r';
        letters[9] = 'd';
        letters[10] = 'l';
        letters[11] = 'c';
        letters[12] = 'u';
        letters[13] = 'm';
        letters[14] = 'w';
        letters[15] = 'f';
        letters[16] = 'g';
        letters[17] = 'y';
        letters[18] = 'p';
        letters[19] = 'b';
        letters[20] = 'v';
        letters[21] = 'k';
        letters[22] = 'j';
        letters[23] = 'x';
        letters[24] = 'q';
        letters[25] = 'z';
        return letters[index];
    }
}
