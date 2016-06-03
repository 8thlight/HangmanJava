package com.hangman;

public class FakeTicker implements Ticker {
    private int tickCount;

    int TickCount() {
        return tickCount;
    }

    @Override
    public void tick() {
        tickCount++;
    }
}
