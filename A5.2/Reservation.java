class Theater {
    private int theaterCapacity;
    private int availableSeats;
    private int reservedSeats;
    public Theater(int theaterCapacity, int reservedSeats) {
        this.theaterCapacity = theaterCapacity;
        this.reservedSeats = reservedSeats;
        this.availableSeats = theaterCapacity - reservedSeats;
    }
}

class Customers extends Thread {
    private int customerID;
    private int numTickets;
}

class Reservation extends Thread {
    private Customers customer;
    private Theater theater;
    public Reservation(Customers customer, Theater theater) {
        this.customer = customer;
        this.theater = theater;
    }
}
