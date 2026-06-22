import java.util.Scanner;

public class excommunicado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("amount of monkey wall streets: ");
        int quant = scanner.nextInt();
        int[] monkeyFarm = new int[quant];

        for (int i = 0; i < quant; i++) {
            System.out.print("farm " + (i + 1) + " income: ");
            monkeyFarm[i] = scanner.nextInt();
        }

        int[] tier5 = new int[quant];
        int tier5s = 0;
        for (int i = 0; i < quant; i++) {
            boolean samepath = false;

            for (int j = 0; j < tier5s; j++) {
                if (monkeyFarm[i] == tier5[j]) {
                    samepath = true;
                    break;
                }
            }

            if (!samepath) {
                tier5[tier5s] = monkeyFarm[i];
                tier5s++;
            }
        }
        
        System.out.println("\n tier5s optimal income: ");
        for (int i = 0; i < tier5s; i++) {
            System.out.print(tier5[i] + " ");
        }

        scanner.close();
    }
}
