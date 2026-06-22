public class CoffeeMaker {
    private String CoffeeType;
    private int coffeeAmount;
    private boolean on;

    public CoffeeMaker() {
        on = false;
        CoffeeType = "normal";
        coffeeAmount = 10;
    }

    public void pressOnOff() {
        on = !on;
    }

    public boolean isOn() {
        return on;
    }

    public void CoffeeType(String type) {
        if (on && (type == "normal" || type == "espresso")) {
            CoffeeType = type;
        }
    }

    public String getCoffeeType() {
        return CoffeeType;
    }

    public void SetCoffeeAmount(int amount) {
        if (on && amount >= 10 && amount <= 80) {
            coffeeAmount = amount;
        }
    }

    public int getCoffeeAmount() {
        return coffeeAmount;
    }
}

class CoffeeMakerDriver {
    public static void main(String[] args) {
        CoffeeMaker coffeeMaker = new CoffeeMaker();

        coffeeMaker.pressOnOff();

        if (coffeeMaker.isOn()) {
            System.out.println("Status: On");
        }

        coffeeMaker.CoffeeType("espresso");
        coffeeMaker.SetCoffeeAmount(23);

        System.out.println("Caffè type: " + coffeeMaker.getCoffeeType());
        System.out.println("Caffè amount: " + coffeeMaker.getCoffeeAmount() + " ml");

        coffeeMaker.pressOnOff();

        if (!coffeeMaker.isOn()) {
            System.out.println("Status: Off");
        }
    }
}

