package com.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class HangmanGame extends Observable implements Game {
    static int MaxIncorrectGuesses = 9;
    private int incorrectGuesses;
    private List<Character> answer;
    private List<Character> correctGuesses;
    private AnswerGenerator answerGenerator = new RandomAnswerGeneratorFromList();

    public HangmanGame()
    {
        correctGuesses = new ArrayList<>();
        incorrectGuesses = 0;
    }

    @Override
    public boolean isOver()
    {
        return incorrectGuesses >= MaxIncorrectGuesses || isWinner();
    }

    @Override
    public void guess(char guess)
    {
        if (isIncorrect(guess))
            incorrectGuesses++;
        else {
            correctGuesses.add(Character.toLowerCase(guess));
        }
        setChanged();
        notifyObservers();
    }

    @Override
    public List<Character> currentClue()
    {
        List<Character> clue = new ArrayList<>();

        for (int i = 0; i < answer().size(); i++) {
            Character c = answer().get(i);
            if (correctGuesses.contains(c))
                clue.add(c);
            else
                clue.add(null);
        }

        return clue;
    }

    @Override
    public boolean isWinner()
    {
      return correctGuesses.containsAll(this.answer());
    }

    @Override
    public int numGuesses() {
        return incorrectGuesses + correctGuesses.size();
    }

    public void setAnswerGenerator(AnswerGenerator answerGenerator) {
        this.answerGenerator = answerGenerator;
    }

    private boolean isIncorrect(char guess) {
        return !this.answer().contains(guess) || this.correctGuesses.contains(guess);
    }

    protected List<Character> answer() {
        if (answer == null) {
            answer = new ArrayList<>();
            for (Character c : answerGenerator.generateAnswer().toLowerCase().toCharArray())
                answer.add(c);
        }
        return answer;
    }
}
