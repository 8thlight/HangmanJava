package com.hangman;

public class SleepTicker implements Ticker {
    @Override
    public void tick() throws Exception {
        Thread.sleep(100);
    }
}
