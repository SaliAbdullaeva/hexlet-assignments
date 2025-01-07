package exercise;

// BEGIN
import java.util.Arrays;

public class MaxThread extends Thread {

    private int[] numbers;
    private int max;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        max = Arrays.stream(numbers)
                .max()
                .orElseThrow();
    }

    public int getMax() {
        return max;
    }
}
// END
