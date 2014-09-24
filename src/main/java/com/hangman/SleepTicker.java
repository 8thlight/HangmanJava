package com.hangman;

public class SleepTicker implements Ticker {
    @Override
    public void tick() {
      try {
        Thread.sleep(100);
      }
      catch (Exception e) {
      }
    }
}
