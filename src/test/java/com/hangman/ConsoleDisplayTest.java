package com.hangman;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;

import static org.junit.Assert.*;

public class ConsoleDisplayTest extends Observable implements Game {
    private List<Character> currentClue;

    @Test
    public void onGameOverItWritesTheGameOver() {
        FakeWriter writer = new FakeWriter();
        ConsoleDisplay display = new ConsoleDisplay(writer);

        display.gameOver();

        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("com.hangman.Game Over");

        assertEquals(expectedLines, writer.writtenLines());
    }

    @Test
    public void onUpdateOfGameItDisplaysCurrentClue() {
        FakeWriter writer = new FakeWriter();
        ConsoleDisplay display = new ConsoleDisplay(writer);

        currentClue = Arrays.asList(null, 'a', null);
        display.update(this, writer);

        List<String> expectedLines = new ArrayList<String>();
        expectedLines.add("Current Clue Is _ a _ ");

        assertEquals(expectedLines, writer.writtenLines());
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public void guess(char guess) {

    }

    @Override
    public boolean isWinner() {
        return false;
    }

    @Override
    public int numGuesses() {
        return 0;
    }

    @Override
    public List<Character> currentClue() {
        return currentClue;
    }
}
