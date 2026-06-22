import java.util.Scanner;

public class monkeyfarmmath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("amount of monkey wall streets: ");
        int quant = scanner.nextInt();
        int[] monkeyFarm = new int[quant];

        for (int i = 0; i < quant; i++) {
            System.out.print("farm " + (i + 1) + " income: ");
            monkeyFarm[i] = scanner.nextInt();
        }

        int MaxIncome = Integer.MIN_VALUE;
        int firstFarm = 0;
        int lastFarm = 0;

        for (int start = 0; start < quant; start++) {
            int currentSum = 0;

            for (int end = start; end < quant; end++) {
                currentSum += monkeyFarm[end];

                if (currentSum > MaxIncome) {
                    MaxIncome = currentSum;
                    firstFarm = start;
                    lastFarm = end;
                }
            }
        }

        System.out.println("\nMaximum income: $" + MaxIncome);
        System.out.println("Farms: " + (firstFarm + 1) + "-" + (lastFarm + 1));

        scanner.close();
    }
}