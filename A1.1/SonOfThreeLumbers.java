import java.util.Scanner;

public class SonOfThreeLumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The product of the numbers is " + (first * second * third)); // simple multiplication rule
        System.out.println("The average of the numbers is " + (first + second + third) / 3.0); // divided by 3 cuz only 3 inputs were given
    }
}