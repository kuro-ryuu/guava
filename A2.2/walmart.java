import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class walmart {

    private ArrayList<String> groceryList = new ArrayList<>();
    private HashMap<String, Double> itemCosts = new HashMap<>();
    private HashMap<String, String> itemCategories = new HashMap<>();
    private HashMap<String, Integer> itemQuantities = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        walmart shopping = new walmart();

        while (true) {
            System.out.println("\nWhat would you like to do? (add, remove, display, check, exit)");
            String command = scanner.nextLine().toLowerCase().trim();

            if (command.equals("add")) {

                while (true) {
                    System.out.print("Adding item (type 'back' to go back): ");
                    String item = scanner.nextLine().trim();

                    if (item.equalsIgnoreCase("back")) {
                        break;
                    }

                    shopping.addItemStr(item);
                    System.out.println(item + " successfully added.");
                }
            }
            
            else if (command.equals("remove")) {
                System.out.print("Removing item: ");
                String item = scanner.nextLine().trim();
                shopping.removeItem(item);
                System.out.println(item + " successfully removed.");
            }
            
            else if (command.equals("display")) {
                shopping.displayList();
            }
            
            else if (command.equals("check")) {
                System.out.print("Checking item: ");
                String item = scanner.nextLine().trim();

                if (shopping.checkItem(item)) {
                    System.out.println("it's there");
                } else {
                    System.out.println("reality dissociation");
                }

            }
            
            else if (command.equals("exit")) {
                System.out.println("card declined lmao");
                break;

            }
            
            else {
                System.out.println("Unknown command.");
            }
        }

        scanner.close();
    }

    public void addItemStr(String item) {
        groceryList.add(item);
    }

    public void addItem(String item, double cost, String category, int quantity) {
        itemCosts.put(item, cost);
        itemCategories.put(item, category);
        itemQuantities.put(item, quantity);
        groceryList.add(item);
    }

    public double calculateTotalCost() {
        double total = 0;

        for (String item : itemCosts.keySet()) {
            double cost = itemCosts.get(item);
            int quantity = itemQuantities.getOrDefault(item, 1);
            total += cost * quantity;
        }

        return total;
    }

    public void displayByCategory(String category) {

        System.out.println("Items in category: " + category);

        for (String item : itemCategories.keySet()) {
            if (itemCategories.get(item).equalsIgnoreCase(category)) {
                System.out.println(item + " ($" + itemCosts.get(item) + ")");
            }
        }
    }

    public void updateQuantity(String item, int newQuantity) {

        if (itemQuantities.containsKey(item)) {
            itemQuantities.put(item, newQuantity);
        }
    }

    public void displayAvailableItems() {
        for (String item : itemCosts.keySet()) {
            int quantity = itemQuantities.getOrDefault(item, 1);
            if (quantity > 0) {
                System.out.println(item + " | Cost: $" + itemCosts.get(item)
                + " | Category: "
                + itemCategories.getOrDefault(item, "Uncategorized")
                + " | Quantity: "
                + quantity);
            }
        }
    }

    public void removeItem(String item) {
        itemCosts.remove(item);
        itemCategories.remove(item);
        itemQuantities.remove(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");

        if (groceryList.isEmpty()) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String item) {
        return groceryList.contains(item);
    }
}

class Main {

    public static void main(String[] args) {

        walmart shopping = new walmart();

        shopping.addItem("Isopropyl", 11.50, "Chemical", 5);
        shopping.addItem("Thorium Rod", 3000, "Thing", 2);
        shopping.addItem("Pizza", 2.50, "Foomd", 1);

        System.out.println(
            "Total cost: $" + shopping.calculateTotalCost()
        );

        System.out.println();
        shopping.displayByCategory("Thing");
        System.out.println();
        shopping.updateQuantity("Thorium Rod", 6);
        shopping.displayAvailableItems();
    }
}