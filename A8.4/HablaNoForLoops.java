import java.util.Arrays;

public class HablaNoForLoops {

    public static void main(String[] args) {

        int[] numbers = {10, 5, 8, 20, 15, 3, 12};

        double mean = Arrays.stream(numbers)
                .average()
                .orElse(0);

        System.out.println("Mean: " + mean);
    }
}
