package com.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HangmanGame extends Observable implements Game {
    public static int MaxIncorrectGuesses = 9;
    private int incorrectGuesses;
    private List<Character> answer;
    private List<Character> correctGuesses;
    private AnswerGenerator answerGenerator = new RandomAnswerGeneratorFromList();

    public HangmanGame()
    {
        correctGuesses = new ArrayList<Character>();
        incorrectGuesses = 0;
    }

    //@Override
    public boolean IsOver()
    {
        return incorrectGuesses >= MaxIncorrectGuesses || IsWinner();
    }

    //@Override
    public void Guess(char guess)
    {
        if (isIncorrect(guess))
            incorrectGuesses++;
        else {
            correctGuesses.add(Character.toLowerCase(guess));
        }
        setChanged();
        notifyObservers();
    }

    //@Override
    public List<Character> CurrentClue()
    {
        List<Character> clue = new ArrayList<Character>();

        for (int i = 0; i < Answer().size(); i++) {
            Character c = Answer().get(i);
            if (correctGuesses.contains(c))
                clue.add(c);
            else
                clue.add('_');
        }

        return clue;
    }

    //@Override
    public boolean IsWinner()
    {
      return correctGuesses.containsAll(this.Answer());
    }

    //@Override
    public int numGuesses() {
        return incorrectGuesses + correctGuesses.size();
    }

    public void SetAnswerGenerator(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    private boolean isIncorrect(char guess) {
        return !this.Answer().contains(guess) || this.correctGuesses.contains(guess);
    }

    protected List<Character> Answer() {
        if (answer == null) {
            answer = new ArrayList<Character>();
            for (Character c : answerGenerator.generateAnswer().toLowerCase().toCharArray())
                answer.add(c);
        }
        return answer;
    }
}
