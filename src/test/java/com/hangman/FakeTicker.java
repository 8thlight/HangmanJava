package com.hangman;

import com.hangman.Ticker;

public class FakeTicker implements Ticker {
    private int tickCount;

    public int TickCount() {
        return tickCount;
    }

    public void tick() {
        tickCount++;
    }
}
