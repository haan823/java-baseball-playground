package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

    public static List<Integer> generateRandomNumber() {
        List<Integer> integers = new ArrayList<>();
        Random random = new Random(10);
        while (integers.size() < 3) {
            addRandomNumber(integers, Integer.valueOf(random.nextInt(10)));
        }
        return integers;
    }

    private static void addRandomNumber(List<Integer> integers, int randomNumber) {
        if (!integers.contains(randomNumber)) {
            integers.add(randomNumber);
        }
    }
}
