import java.util.Scanner;

public class judgement {
    public static boolean preem(int n) {
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please give range thank you");
        System.out.print("beningging: ");
        int beningging = scanner.nextInt();
        System.out.print("RAPTURE: ");
        int RAPTURE = scanner.nextInt();

        if (beningging > RAPTURE) {
            System.out.println("that is NOT how it works vro");
            return; // how do i close this thing bruh like damn bro idk maybe leak less??
        }
        System.out.println("prime in the range:");

        for (int i = beningging; i <= RAPTURE; i++) {
            if (preem(i)) {
                System.out.print(" " +i);
            }
        }

        scanner.close();
    }
}