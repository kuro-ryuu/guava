import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        people.add(new Person("Alice", 25, "New York"));
        people.add(new Person("Bob", 32, "Chicago"));
        people.add(new Person("Charlie", 20, "New York"));
        people.add(new Person("David", 28, "Boston"));
        people.add(new Person("Emma", 35, "New York"));
        people.add(new Person("Frank", 22, "Chicago"));

        System.out.println("Original list:");
        people.forEach(person -> System.out.println(person));

        people.sort((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()));

        System.out.println("\nSorted by age:");
        people.forEach(person -> System.out.println(person));

        people.removeIf(person -> !person.getCity().equals("New York"));

        System.out.println("\nPeople from New York:");
        people.forEach(person -> System.out.println(person));
    }
}
