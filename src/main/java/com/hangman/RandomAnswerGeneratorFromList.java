package com.hangman;

class RandomAnswerGeneratorFromList implements AnswerGenerator {
    private RandomNumberGenerator generator;

    RandomAnswerGeneratorFromList(RandomNumberGenerator generator)
    {
        this.generator = generator;

    }

    RandomAnswerGeneratorFromList()
    {
        this(new PseudoRandomNumberGenerator());
    }

    @Override
    public String generateAnswer() {
        int index = (int) (this.generator.random() * (WordList.words.length - 1));
        return WordList.words[index];
    }
}
