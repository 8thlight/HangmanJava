package com.hangman;

import java.util.Observable;
import java.util.Observer;

class ConsoleDisplay implements GameOverDisplay, Observer {
    private Writer writer;

    ConsoleDisplay() {
        this(new ConsoleWriter());
    }

    ConsoleDisplay(Writer writer) {
        this.writer = writer;
    }


    @Override
    public void gameOver() {
        writer.writeLine("com.hangman.Game Over");
    }

    @Override
    public void update(Observable o, Object arg) {
        Game game = (Game) o;
        String clueAsString = "";

        for(Character c : game.currentClue()) {
            if (c != null) {
                clueAsString += c + " ";
            } else {
                clueAsString += "_ ";
            }
        }


        writer.writeLine("Current Clue Is " + clueAsString);
    }
}
