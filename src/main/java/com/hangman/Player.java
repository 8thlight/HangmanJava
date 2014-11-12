package com.hangman.players;
import com.hangman.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class YourPlayer implements Player {
    public char[] cs = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public static int index = 0;
    public static List<Character> lastGuesses = new ArrayList<Character>();
    
  @Override
  public char GetGuess(List<Character> clue) {
    Random random = new Random(System.currentTimeMillis());
    double r = random.nextDouble();
    int index = (int) (r * (cs.length - 1));
    char guess = cs[index];
    while(lastGuesses.contains(guess)) {
        random = new Random(System.currentTimeMillis());
        r = random.nextDouble();
        index = (int) (r * (cs.length - 1));
        guess = cs[index];
    }
    lastGuesses.add(guess);
    return guess;
  }
}

