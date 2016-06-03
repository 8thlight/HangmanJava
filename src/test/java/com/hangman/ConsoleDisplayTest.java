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
    public void OnGameOverItWritesTheGameOver() {
        FakeWriter writer = new FakeWriter();
        ConsoleDisplay display = new ConsoleDisplay(writer);

        display.GameOver();

        List<String> expectedLines = new ArrayList<String>();
        expectedLines.add("com.hangman.Game Over");

        assertEquals(expectedLines, writer.writtenLines());
    }

    @Test
    public void OnUpdateOfGameItDisplaysCurrentClue() {
        FakeWriter writer = new FakeWriter();
        ConsoleDisplay display = new ConsoleDisplay(writer);

        currentClue = Arrays.asList(null, 'a', null);
        display.update(this, writer);

        List<String> expectedLines = new ArrayList<String>();
        expectedLines.add("Current Clue Is _ a _ ");

        assertEquals(expectedLines, writer.writtenLines());
    }

    @Override
    public boolean IsOver() {
        return false;
    }

    @Override
    public void Guess(char guess) {

    }

    @Override
    public boolean IsWinner() {
        return false;
    }

    @Override
    public int numGuesses() {
        return 0;
    }

    @Override
    public List<Character> CurrentClue() {
        return currentClue;
    }
}
