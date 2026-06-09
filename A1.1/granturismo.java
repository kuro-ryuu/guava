public class granturismo {
    private String name;

    public granturismo(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        granturismo cat = new granturismo("Whiskers");
        granturismo dog = new granturismo("Rex");

        // Call the meow method on the cat instance
        for (int i = 0; i < 4; i++) { // coulda done it with 4 lines of cat.meow() but gotta make sure im still up to par with my rusty skills foreal
            if (i == 2) {
                dog.meow();
            }
            else {
                cat.meow();
            }
        }
    }
}