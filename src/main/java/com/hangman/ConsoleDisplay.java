package com.hangman;

import java.util.Observable;
import java.util.Observer;

public class ConsoleDisplay implements GameOverDisplay, Observer {
    private Writer writer;

    public ConsoleDisplay() {
        this(new ConsoleWriter());
    }

    public ConsoleDisplay(Writer writer) {
        this.writer = writer;
    }
    
    public void GameOver() {
        writer.writeLine("com.hangman.Game Over");
    }
    
    public void update(Observable o, Object arg) {
        Game game = (Game) o;
        String clueAsString = "";

        for(Character c : game.CurrentClue())
            clueAsString += c + " ";

        writer.writeLine("Current Clue Is " + clueAsString);
    }
}
