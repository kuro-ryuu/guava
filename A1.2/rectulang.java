import java.util.Scanner;

public class rectulang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the lengeth of first leg: ");
        double thigh = Double.parseDouble(scanner.nextLine());
        System.out.println("Give the lengeth of second leg: ");
        double calf = Double.parseDouble(scanner.nextLine());
        double hypothermia = Math.sqrt(thigh * thigh + calf * calf);
        System.out.printf("hippotamus = %.2f cm", hypothermia);

        scanner.close();
    }
}
