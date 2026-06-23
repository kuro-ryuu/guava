interface Vehicle {
    public void start();
    public void stop();
    public void getInfo();
}



public class VehicleDemo {
    public static void main(String[] args) {

    }
}


class Car implements Vehicle {
    public Car(int speed) {
        return Car;
    }

    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\nVehicle type: Car"
        + "\nColor: Red"
        + "\nFuel Type: Water"
        );
    }
}


class Motorcycle implements Vehicle {
    public Motorcycle() {
        return Motorcyle;
    }

    @Override
    public void start() {
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        System.out.println("Motorcycle stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\nVehicle type: Motorcycle"
        + "\nColor: Blue"
        + "\nFuel Type: Cement"
        );
    }
}


class Bus implements Vehicle {
    public Bus(String type, String color, String fuel) {
        this.type = type;
        this.color = color;
        this.fuel = fuel;
    }

    @Override
    public void start() {
        System.out.println("Bus started");
    }

    @Override
    public void stop() {
        System.out.println("Bus stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\nVehicle type: " + type
        + "\nColor: Crimson " + color
        + "\nFuel Type: Soul of the damned " + fuel
        );
    }
}


