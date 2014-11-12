package com.hangman;

public class RandomAnswerGeneratorFromList implements AnswerGenerator {
    private RandomNumberGenerator generator;

    public RandomAnswerGeneratorFromList(RandomNumberGenerator generator)
    {
        this.generator = generator;

    }

    public RandomAnswerGeneratorFromList()
    {
        this(new PseudoRandomNumberGenerator());
    }

    //@Override
    public String generateAnswer() {
        int index = (int) (this.generator.Random() * (WordList.words.length - 1));
        return WordList.words[index];
    }
}
