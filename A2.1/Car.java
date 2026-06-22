public class Car {
    /* An object of class Car will have instance variables speed and gasolineLevel.
     * Both are private (they can not be accessed outside the class methods).
     * Keep instance variables private whenever possible.
     */
    private double speed;
    private double gasolineLevel;
    private String typeName;
    private boolean cruiseControlOn;
    private double targetSpeed;
    private static final int MIN_SPEED = 20;
    private static final int MAX_SPEED = 120;

    /* This is the method (constructor) called when a new instance of Car is created (with new).
     * Constructors may also have arguments.
     */
    public Car(String typeName, double accelerate, double fillTank) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;   // this refers to the object itself.
                                    // The reference is useful if you want to use parameter names that are
                                    // identical to instance variable names (and for more, later on)
    }

    public void setTargetSpeed(double speed) {
        if (targetSpeed >= MIN_SPEED && targetSpeed <= MAX_SPEED)
            targetSpeed = speed;
    }

    public boolean toggleCCOn() {
        if (targetSpeed >= MIN_SPEED && targetSpeed <= MAX_SPEED && gasolineLevel > 0) {
            cruiseControlOn = true;
            return true;
        }
        return false;
    }

    public boolean toggleCCOff() {
        return cruiseControlOn = false;
    }

    public boolean CCStatus() {
        return cruiseControlOn;
    }

    public double targetSpeed() {
        return targetSpeed;
    }

    /* Implementations of some methods.
     * Note that methods refer to and change instance variable values.
     */
    public void accelerate() {
        if (gasolineLevel > 0) {
            speed = 0;
            cruiseControlOn = false;
            return;
        }

        else if (cruiseControlOn) {
            if (speed < targetSpeed) {
                speed += 10;

                if (speed > targetSpeed) {
                    speed = targetSpeed;
                }
            }

            else if (speed > targetSpeed) {
                speed -=10;

                if (speed < targetSpeed) {
                    speed = targetSpeed;
                }
            }

            else if (targetSpeed > MAX_SPEED || targetSpeed < MIN_SPEED) {
                cruiseControlOn = false;
            }
        }

        else {
            speed += 10;
        }
    }


    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
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


class CarDriver {
    public static void main(String[] args) {
        Car myCar;

        myCar = new Car("Toyota Corolla", 0, 0);
        myCar.fillTank();
        myCar.setTargetSpeed(80);

        if (myCar.toggleCCOn())
            System.out.println("Cruise control is on");
        else
            System.out.println("Cruise control is off");

        while (myCar.getSpeed() <myCar.targetSpeed()) {
            myCar.accelerate();
            System.out.println("Speed: " + myCar.getSpeed());
        }

        System.out.println("Target speed reached");
    }
}