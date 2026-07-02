/* Define a class Car (convention capitalizes class names).
 * Car is public (as classes usually are, more on this later).
 */
public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    protected double speed;
    protected double gasolineLevel;
    protected String typeName;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
                                    // The reference is useful if you want to use parameter names that are
                                    // identical to instance variable names (and for more, later on)
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed += 10;
            gasolineLevel -= 1;
        } else
            speed = 0;
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
            gasolineLevel -= 0.5;
        } else
            speed = 0;
    }
    double getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    double getGasolineLevel() {
        return gasolineLevel;
    }
}

class SportsCar extends Car {
    public SportsCar(String typeName) {
        super(typeName);
    }
    
    @Override
    public void accelerate() {
        if (getGasolineLevel() > 0) {
            super.accelerate();
            gasolineLevel -= 2.5;
        }
    }
    
    
    @Override
    void decelerate(int amount) {
        if (getGasolineLevel() > 0 && amount > 0) {
            int effectiveAmount = (int) (amount * 1.5);
            speed = Math.max(0, speed - effectiveAmount);
            gasolineLevel -= 1;
        } else if (getGasolineLevel() <= 0) {
            speed = 0;
        }
    }
}