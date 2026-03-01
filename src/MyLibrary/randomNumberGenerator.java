package MyLibrary;

import java.util.Random;

public class randomNumberGenerator {
    public int randomNumber(int num) {
        Random rand = new Random();
        return rand.nextInt(num) + 1;
    }
}
