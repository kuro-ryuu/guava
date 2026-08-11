import java.util.Arrays;
import java.util.List;

public class Filternum {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10, 5, 8, 20, 15, 3, 12);

        int sum = numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * 2)
                .reduce(0, (a, b) -> a + b);

        System.out.println("Sum: " + sum);
    }
}

