import java.util.Scanner;

public class ommelt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("how many grampa???: ");
        double grampa = Double.parseDouble(scanner.nextLine());
        double luoti_g = 13.28;
        double naula_g = 32*luoti_g;
        double leiviskä_g = 20*naula_g;

        // remain leiviska
        int leiviskä = (int) (grampa/leiviskä_g);
        grampa %= leiviskä_g;
        // remain naula
        double naula = (int) (grampa/naula_g);
        grampa %= naula_g;
        // remain luoti
        double luoti = (int) (grampa/luoti_g);


        System.out.printf("Weight (g): %.0f \n", grampa);
        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti", grampa, (int) leiviskä, (int) naula, luoti);

        scanner.close();
    }
}