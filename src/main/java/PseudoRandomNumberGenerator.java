import java.util.Random;

public class PseudoRandomNumberGenerator implements RandomNumberGenerator {
    @Override
    public double Random() {
        Random random = new Random(System.currentTimeMillis());

        return random.nextDouble();
    }
}
