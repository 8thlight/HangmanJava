package com.hangman.players;

import com.hangman.Player;

import java.util.*;

public class YourPlayer implements Player {
    private Stack<Character> priorityStack = new Stack();
    private Stack<Character> secondaryStack = new Stack();

    private List<Character> priorityCharacters = new ArrayList();
    private List<Character> secondaryCharacters = new ArrayList();

    private boolean emptyCurrentClueList = true;

    public YourPlayer(){
        priorityCharacters = Arrays.asList('u', 'l', 'd', 'r', 'h', 's', 'n', 'i', 'o', 'a', 't', 'e');

        secondaryCharacters = Arrays.asList('b', 'c', 'd', 'f', 'g', 'j', 'k', 'm', 'p', 'q', 'v', 'w', 'x', 'y', 'z');

        for (Character letter : priorityCharacters){
            priorityStack.push(letter);
        }

        for (Character letter : secondaryCharacters){
            secondaryStack.push(letter);
        }
    }

    @Override
    public char getGuess(List<Character> currentClue) {
        checkIfEmptyCurrentClueList(currentClue);

        if (emptyCurrentClueList){
            return priorityStack.pop();
        }
        else {
            return getNextGuess();
        }
    }

    private void checkIfEmptyCurrentClueList(List<Character> currentClue){
        for (Character element : currentClue)
            if (element != null){
                emptyCurrentClueList = false;
            }
    }
    private char getNextGuess(){
        if (priorityStack.isEmpty()){
            return getGuessFromSecondaryStack();
        }
        else {
            return priorityStack.pop();
        }
    }

    private char getGuessFromSecondaryStack(){
        if (secondaryStack.isEmpty()){
            // No more guesses left ... ???
            return 'A';
        }
        else {
            return secondaryStack.pop();
        }
    }
}
