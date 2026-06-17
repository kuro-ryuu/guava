import java.util.Scanner;

public class tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the coefficients of the quadratic equation:");
        System.out.print("Enter coefficient a: ");
        double a = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient b: ");
        double b = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter coefficient c: ");
        double c = Double.parseDouble(scanner.nextLine());

        // the condition for the quad to have 2 real solutions iirc?
        double delta = b*b - 4*a*c;

        if (delta < 0) {
            System.out.println("no real solution :(");                                                                                                                                                                                                                                                                    }
        else if (delta == 0) {
            double troot = -b / (2*a);
            System.out.printf("l'unica soluzione: %d" + troot);                                                                                                                                                                                                                                                              }
        else {
            double troot1 = (-b + Math.sqrt(delta)) / (2*a);
            double troot2 = (-b - Math.sqrt(delta)) / (2*a);

            System.out.printf("le radici del l'equazione quadratica sono %.2f e %.2f", troot1, troot2);

        scanner.close();
        }
    }
}