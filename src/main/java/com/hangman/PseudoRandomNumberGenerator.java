package com.hangman;

import java.util.Random;

public class PseudoRandomNumberGenerator implements RandomNumberGenerator {

    public double Random() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextDouble();
    }
}
