import java.util.ArrayList;
import java.util.Scanner;

public class walmart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        walmart shopping = new walmart();
        String item = scanner.nextLine();
        System.out.println("What would you like to do? (add, remove, display, check)");
        String command = scanner.nextLine().toLowerCase().trim();

        if (command == "add") {
            item = scanner.nextLine().toLowerCase().trim();
            while (true) {
                System.out.println("Adding item (type 'back' to go back): ");
                shopping.addItem(item);
                System.out.println(item + " successfully added.");
                if (item == "back") {
                    break;
                }
            }
        }

        else if (command == "remove") {
            System.out.println("Removing item: ");
            item = scanner.nextLine();
            shopping.removeItem(item);
            System.out.println(item + " successfully removed.");
        }

        else if (command == "display") {
            System.out.println("Cart: ");
            shopping.displayList();
        }

        else if (command == "check") {
            System.out.println("Checking item: ");
            item = scanner.nextLine();
            shopping.checkItem(item);
        }

        else if (command == "exit") {
            System.out.println("card declined lmao");
        }
        // shopping.addItem(item);
        // item = scanner.nextLine();
        // shopping.removeItem(item);
        // item = scanner.nextLine();
        // shopping.displayList();
        // item = scanner.nextLine();
        // shopping.checkItem(item);
    }


    private ArrayList<String> groceryList = new ArrayList<>();


    public void addItem(String item) {
        groceryList.add(item);
    }

    public void removeItem(String item) {
        groceryList.remove(item);
    }

    public void displayList() {
        System.out.println("Grocery List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println(i);
        }
    }

    public void checkItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println("Item found.");
        }
        else {
            System.out.println("Item not found.");
        }
    }
}
