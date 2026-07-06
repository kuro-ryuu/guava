import Car.Car;


public class CarDriver {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota Corolla", 10, 100);
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