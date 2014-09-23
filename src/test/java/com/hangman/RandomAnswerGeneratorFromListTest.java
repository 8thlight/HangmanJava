package com.hangman;

import com.hangman.RandomAnswerGeneratorFromList;
import com.hangman.RandomNumberGenerator;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomAnswerGeneratorFromListTest implements RandomNumberGenerator {
    private double randomNumber;

    public double Random() {
        return randomNumber;
    }

    @Test
    public void CanRandomlySelectTheFirstGuess()  {
        randomNumber = 0.0;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("aboard", generator.generateAnswer());
    }

    @Test
    public void CanRandomlySelectTheLastGuess()  {
        randomNumber = 1.0;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("zoo", generator.generateAnswer());
    }

    @Test
    public void CanRandomlySelectOneInTheMiddle()  {
        randomNumber = 0.1;

        RandomAnswerGeneratorFromList generator = new RandomAnswerGeneratorFromList(this);

        assertEquals("birth", generator.generateAnswer());
    }
}
