public class HangmanRunner {

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

    public void run() throws Exception {
        while(!game.IsOver()) {
            char guess = player.GetGuess(game.CurrentClue());
            game.Guess(guess);
            ticker.tick();
        }
        display.GameOver();
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
