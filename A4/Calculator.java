public class Calculator {
    private int value;

    public Calculator() {
        reset();
    }

    public void reset() {
        value = 0;
    }

    public void add(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Negative integers are not allowed.");
        }
        value += number;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.add(5);
        calculator.add(7);
        calculator.add(3);
        System.out.println("Current value: " + calculator.getValue());
    }
}
