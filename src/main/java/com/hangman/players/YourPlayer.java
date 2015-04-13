package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {

    Queue<Character> bestGuesses = new LinkedList<Character>();

    public YourPlayer() {
        bestGuesses.add('r');
        bestGuesses.add('s');
        bestGuesses.add('t');
        bestGuesses.add('l');
        bestGuesses.add('n');
        bestGuesses.add('e');
        bestGuesses.add('a');
        bestGuesses.add('b');
        bestGuesses.add('c');
        bestGuesses.add('d');
        bestGuesses.add('f');
        bestGuesses.add('g');
        bestGuesses.add('h');
        bestGuesses.add('i');
        bestGuesses.add('j');
        bestGuesses.add('k');
        bestGuesses.add('l');
        bestGuesses.add('m');
        bestGuesses.add('n');
        bestGuesses.add('o');
        bestGuesses.add('p');
        bestGuesses.add('q');
        bestGuesses.add('u');
        bestGuesses.add('v');
        bestGuesses.add('w');
        bestGuesses.add('x');
        bestGuesses.add('y');
        bestGuesses.add('z');
    }

    @Override
    public char GetGuess(List<Character> currentClue) {
        char guess = bestGuesses.poll();
        return guess;
    }

}
