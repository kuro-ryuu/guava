import java.util.Scanner;

public class r2d2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("give number in decimal form uh i mean binary (this is completely a real time mistake that i wont fix): ");
        String binary = scanner.nextLine();
        int decimal = 0;

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            decimal *=2;    // how come thsi took me a whole hour

            if (bit == '1') {
                decimal += 1;    
            }
        }
        System.out.printf("%s = %d", binary, decimal);

        scanner.close();
    }
}
