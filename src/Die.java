import java.util.Random;

public class Die {

    private static Random random = new Random();
    private int currentValue;
    private int numberOfSides;

    public Die(int numberOfSides) {
        this.numberOfSides = numberOfSides;
    }
    public void roll() {
        this.currentValue = random.nextInt(numberOfSides) + 1;
    }

    public int getNumberOfSides() {
        return this.numberOfSides;
    }

    public int getCurrentValue() {
        return currentValue;
    }
}

