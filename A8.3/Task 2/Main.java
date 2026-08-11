import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(
                Arrays.asList(10, 5, 8, 20, 15, 3, 12)
        );

        System.out.println("Original list: " + numbers);

        // Remove even numbers
        numbers.removeIf(number -> number % 2 == 0);

        System.out.println("After removing even numbers: " + numbers);

        // Double the odd numbers
        numbers.replaceAll(number -> number * 2);

        System.out.println("After doubling odd numbers: " + numbers);

        // Calculate the sum
        int sum = 0;

        for (Integer number : numbers) {
            sum += number;
        }

        System.out.println("Sum: " + sum);
    }
}
