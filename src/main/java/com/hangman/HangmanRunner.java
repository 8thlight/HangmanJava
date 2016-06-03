package com.hangman;
import com.hangman.players.YourPlayer;

public class HangmanRunner implements Runner {

    private GameOverDisplay display;
    private Game game;
    private Player player;
    private Ticker ticker;

    public HangmanRunner(Game game, GameOverDisplay display, Player player, Ticker ticker)
    {
        this.display = display;
        this.game = game;
        this.player = player;
        this.ticker = ticker;
    }

    @Override
    public void run() {
        while(!game.isOver()) {
            char guess = player.getGuess(game.currentClue());
            game.guess(guess);
            ticker.tick();
        }
        display.gameOver();
    }

    @Override
    public boolean isWinner() {
      return game.isWinner();
    }

    @Override
    public int numGuesses() {
        return game.numGuesses();
    }

    public static void main(String [] args) throws Exception {
        HangmanGame game = new HangmanGame();
        ConsoleDisplay display = new ConsoleDisplay();
        game.addObserver(display);

        HangmanRunner runner = new HangmanRunner(game,
                display,
                new YourPlayer(),
                new SleepTicker());
        runner.run();
    }
}
