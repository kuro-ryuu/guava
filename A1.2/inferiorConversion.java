import java.util.Scanner;

public class inferiorConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature in Fahrenheit:");
        double fahrenheit = Double.parseDouble(scanner.nextLine());
        double celsius = (fahrenheit - 32) * 5 / 9;
        System.out.printf("Temperature in celsius: %.1f Celsius", celsius);

        scanner.close();
    }
}