package com.hangman;

class SimpleAnswerGenerator implements AnswerGenerator
{
    private String nextAnswer;

    void setNextAnswer(String nextAnswer) {
        this.nextAnswer = nextAnswer;
    }

    @Override
    public String generateAnswer() {
        return nextAnswer;
    }
}
