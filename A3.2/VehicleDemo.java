interface Vehicle {
    public void start();
    public void stop();
    public void getInfo();
}



interface ElectricVehicle {
    public void charge();
    public void getBatteryStatus();
}



abstract class AbstractVehicle implements Vehicle, ElectricVehicle {
    protected String type;
    protected String color;
    protected String fuel;
    protected int distance;
    protected boolean isRunning;

    public AbstractVehicle(String type, String color, String fuel) {
        this.type = type;
        this.color = color;
        this.fuel = fuel;
        this.distance = 0;
        this.isRunning = false;
    }

    @Override
    public void start() {
        this.isRunning = true;
    }

    @Override
    public void stop() {
        this.isRunning = false;
    }

    public void refuel(String fuelType) {
        this.fuel = fuelType;
        System.out.println(this.type + " refueled with " + fuelType);
    }

    public void drive(int distance) {
        if (isRunning) {
            this.distance += distance;
            System.out.println(this.type + " drove " + distance + " km. Total Distance: " + this.distance + " km");
        }
        
        else {
            System.out.println(this.type + " must be started before driving");
        }
    }

    public int getDistance() {
        return this.distance;
    }

    public String getStatus() {
        return this.type + " is " + (isRunning? "running" : "stopped");
    }

    @Override
    public abstract void getInfo();

    @Override
    public void charge() {
        System.out.println(this.type + " cannot be charged - not an electric vehicle.");
    }

    @Override
    public void getBatteryStatus() {
        System.out.println(this.type + " does not have a battery.");
    }
}


class Car extends AbstractVehicle {
    public Car(String type, String color, String fuel) {
        super(type, color, fuel);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Car stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\n>Vehicle type: " + type
        + "\n>Color: Red " + color
        + "\n>Fuel Type: Water " + fuel
        + "\n>Distance: " + distance + " km"
        );
    }
}


class Motorcycle extends AbstractVehicle {
    public Motorcycle(String type, String color, String fuel) {
        super(type, color, fuel);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Motorcycle started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Motorcycle stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\n>Vehicle type: " + type
        + "\n>Color: " + color
        + "\n>Fuel Type: " + fuel
        + "\n>Distance: " + distance + " km"
        );
    }
}


class Bus extends AbstractVehicle {
    public Bus(String type, String color, String fuel) {
        super(type, color, fuel);
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Bus started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Bus stopped");
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\n>Vehicle type: " + type
        + "\n>Color: Crimson " + color
        + "\n>Fuel Type: " + fuel
        + "\n>Distance: " + distance + " km"
        );
    }
}


class ElectricCar extends AbstractVehicle {
    protected int batteryLevel;

    public ElectricCar(String type, String color) {
        super(type, color, "Electric");
        this.batteryLevel = 100;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Electric car started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Electric car stopped");
    }

    @Override
    public void charge() {
        this.batteryLevel = 100;
        this.isRunning = false;
        System.out.println(this.type + " is charging...");
    }

    @Override
    public void getBatteryStatus() {
        System.out.println(this.type + " battery level: " + this.batteryLevel + "%");
    }

    @Override
    public void drive(int distance) {
        if (isRunning) {
            int batteryUsed = distance / 2;
            if (batteryLevel >= batteryUsed) {
                this.distance += distance;
                this.batteryLevel -= batteryUsed;
                System.out.println(this.type + " drove " + distance + " km. Total Distance: " + this.distance + " km. Battery: " + this.batteryLevel + "%");
            }
        }
        
        else {
            System.out.println(this.type + " must be started before driving");
        }
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\n>Vehicle type: " + type
        + "\n>Color: " + color
        + "\n>Fuel Type: " + fuel
        + "\n>Distance: " + distance + " km"
        + "\n>Battery Level: " + batteryLevel + "%"
        );
    }
}


class ElectricMotorcycle extends AbstractVehicle {
    protected int batteryLevel;

    public ElectricMotorcycle(String type, String color) {
        super(type, color, "Electric");
        this.batteryLevel = 100;
    }

    @Override
    public void start() {
        super.start();
        System.out.println("Electric motorcycle started");
    }

    @Override
    public void stop() {
        super.stop();
        System.out.println("Electric motorcycle stopped");
    }

    @Override
    public void charge() {
        this.batteryLevel = 100;
        this.isRunning = false;
        System.out.println(this.type + " is charging...");
    }

    @Override
    public void getBatteryStatus() {
        System.out.println(this.type + " battery level: " + this.batteryLevel + "%");
    }

    @Override
    public void drive(int distance) {
        if (isRunning) {
            int batteryUsed = distance / 3;
            if (batteryLevel >= batteryUsed) {
                this.distance += distance;
                this.batteryLevel -= batteryUsed;
                System.out.println(this.type + " drove " + distance + " km. Total Distance: " + this.distance + " km. Battery: " + this.batteryLevel + "%");
            } else {
                System.out.println(this.type + " doesn't have enough battery");
            }
        } else {
            System.out.println(this.type + " must be started before driving");
        }
    }

    @Override
    public void getInfo() {
        System.out.println(
        "\nVehicle info:"
        + "\n>Vehicle type: " + type
        + "\n>Color: " + color
        + "\n>Fuel Type: " + fuel
        + "\n>Distance: " + distance + " km"
        + "\n>Battery Level: " + batteryLevel + "%"
        );
    }
}


public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle car = new Car("Sedan", "Red", "Water");
        Vehicle motorcycle = new Motorcycle("Yaiba", "Black", "Dirt");
        Vehicle bus = new Bus("Unicycle", "Yellow", "Pedaling");
        
        ElectricVehicle electricCar = new ElectricCar("Electric cat", "lime");
        ElectricVehicle electricMotorcycle = new ElectricMotorcycle("wall-e", "Brown");
        
        car.start();
        car.getInfo();
        ((AbstractVehicle) car).drive(121);
        ((AbstractVehicle) car).charge();
        car.stop();
        
        motorcycle.start();
        motorcycle.getInfo();
        ((AbstractVehicle) motorcycle).drive(149);
        ((AbstractVehicle) motorcycle).refuel("Premium Dirt");
        ((AbstractVehicle) motorcycle).charge();
        motorcycle.stop();
        
        bus.start();
        bus.getInfo();
        ((AbstractVehicle) bus).drive(7123);
        System.out.println(((AbstractVehicle) bus).getStatus());
        ((AbstractVehicle) bus).charge();
        bus.stop();
        System.out.println(((AbstractVehicle) bus).getStatus());
        
        //ecar test
        ((AbstractVehicle) electricCar).getInfo();
        ((AbstractVehicle) electricCar).start();
        ((AbstractVehicle) electricCar).drive(11243);
        ((AbstractVehicle) electricCar).getBatteryStatus();
        electricCar.charge();
        ((AbstractVehicle) electricCar).getBatteryStatus();
        ((AbstractVehicle) electricCar).stop();
        

        //evike test
        ((AbstractVehicle) electricMotorcycle).getInfo();
        ((AbstractVehicle) electricMotorcycle).start();
        ((AbstractVehicle) electricMotorcycle).drive(233124);
        ((AbstractVehicle) electricMotorcycle).drive(32);
        ((AbstractVehicle) electricMotorcycle).getBatteryStatus();
        electricMotorcycle.charge();
        ((AbstractVehicle) electricMotorcycle).getBatteryStatus();
        ((AbstractVehicle) electricMotorcycle).stop();
    }
}