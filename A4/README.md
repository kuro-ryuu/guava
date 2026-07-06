# This program creates a simple calculator model that keeps track of a running total. The class starts at zero, allows positive integers to be added to it, and prevents negative values by throwing an exception. A temporary main method demonstrates the class by adding a few numbers and printing the final result

```java
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
```

### How the class works:
### The Calculator class stores its current total in the private variable value. The constructor calls reset() so the calculator starts at zero. The add() method increases the total when a positive integer is provided, and it throws an exception if a negative number is entered. The getValue() method returns the current sum, and the main method shows a basic example of using the class to add several numbers together.
