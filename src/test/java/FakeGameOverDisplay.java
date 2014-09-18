public class FakeGameOverDisplay implements GameOverDisplay {
    private boolean gameOverDisplayed;

    public FakeGameOverDisplay() {
        gameOverDisplayed = false;
    }

    public void GameOver() {
        gameOverDisplayed = true;
    }

    public boolean GameOverDisplayed() {
        return gameOverDisplayed;
    }
}
