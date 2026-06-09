public class ponziScheme {
    public static void main(String[] args) {
        int rows = 4;

        for (int i = 1; i <= rows; i++) { 
            // spaces
            for (int j = 0; j <= rows - i - 1; j++) {
                System.out.print(" ");
            }
        
            // sparkling water but with no fizz like what are we doing here, that's just water, you cannot call it sparkling water without the fizz. What kind of person buy sprakling water and then shakes the fizz up to make it normal be foreal
            for (int j = 2; j < 2*i+1; j++) {
                System.out.print("*");
            }
                System.out.println();
        }
    }
}
