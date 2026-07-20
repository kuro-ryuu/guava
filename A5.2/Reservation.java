import java.util.Random;

class Theater {
    private int theaterCapacity;
    private int availableSeats;
    private int reservedSeats;

    public Theater(int theaterCapacity, int reservedSeats) {
        this.theaterCapacity = theaterCapacity;
        this.reservedSeats = reservedSeats;
        this.availableSeats = theaterCapacity - reservedSeats;
    }

    public synchronized boolean reserveSeats(int numTickets) {
        if (availableSeats >= numTickets) {
            availableSeats -= numTickets;
            reservedSeats += numTickets;
            return true;
        }
        return false;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }
}

class Customers extends Thread {
    private int customerID;
    private int numTickets;
    private Theater theater;

    public Customers(int customerID, int numTickets, Theater theater) {
        this.customerID = customerID;
        this.numTickets = numTickets;
        this.theater = theater;
    }

    @Override
    public void run() {
        if (theater.reserveSeats(numTickets)) {
            System.out.println("Customer " + customerID + " reserved " + numTickets + " seats.");
        }
        
        else {
            System.out.println("Customer " + customerID + " could not reserve " + numTickets + " seats.");
        }
    }
}

public class Reservation {
    public static void main(String[] args) throws InterruptedException {
        Theater theater = new Theater(15, 0);
        Random random = new Random();
        int customerID = 1;

        while (theater.getAvailableSeats() > 0) {
            int tickets = random.nextInt(5) + 1; // cusomers will take randomly between 1 to 5
            Customers customer = new Customers(customerID++, tickets, theater);
            customer.start();
            customer.join();

            Thread.sleep(200);
        }
    }
}
