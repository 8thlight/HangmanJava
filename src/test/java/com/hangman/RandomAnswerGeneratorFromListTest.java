package com.hangman;

import org.junit.Test;
import static org.junit.Assert.*;

public class RandomAnswerGeneratorFromListTest implements RandomNumberGenerator {
    private double randomNumber;

    public double random() {
        return randomNumber;
    }

    @Test
    public void canRandomlySelectTheFirstGuess()  {
        randomNumber = 0.0;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("aboard", generator.generateAnswer());
    }

    @Test
    public void canRandomlySelectTheLastGuess()  {
        randomNumber = 1.0;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("zoo", generator.generateAnswer());
    }

    @Test
    public void canRandomlySelectOneInTheMiddle()  {
        randomNumber = 0.1;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("birth", generator.generateAnswer());
    }
}
