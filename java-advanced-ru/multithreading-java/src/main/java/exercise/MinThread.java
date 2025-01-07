package exercise;

// BEGIN
import java.util.Arrays;

public class MinThread extends Thread {

    private int[] numbers;
    private int min;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = Arrays.stream(numbers)
                .min()
                .orElseThrow();
    }

    public int getMin() {
        return min;
    }
}
// END
