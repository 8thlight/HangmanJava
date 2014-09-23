package com.hangman;

import java.util.ArrayList;
import java.util.List;

public class SimpleAnswerGenerator implements AnswerGenerator
{
    private String nextAnswer;

    public void setNextAnswer(String nextAnswer) {
        this.nextAnswer = nextAnswer;
    }

    @Override
    public String generateAnswer() {
        return nextAnswer;
    }
}
