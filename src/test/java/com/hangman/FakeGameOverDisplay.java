package com.hangman;

class FakeGameOverDisplay implements GameOverDisplay {
    private boolean gameOverDisplayed;

    FakeGameOverDisplay() {
        gameOverDisplayed = false;
    }

    public void gameOver() {
        gameOverDisplayed = true;
    }

    boolean GameOverDisplayed() {
        return gameOverDisplayed;
    }
}
