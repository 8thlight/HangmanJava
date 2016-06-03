package com.hangman;

import java.util.Random;

class PseudoRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public double random() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextDouble();
    }
}
