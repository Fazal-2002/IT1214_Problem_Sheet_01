class Ticket {
    private int ticketNumber;
    private String customerName;
    private int seatNumber;

    Ticket(int ticketNumber, String customerName, int seatNumber) {
        this.ticketNumber = ticketNumber;
        this.customerName = customerName;
        this.seatNumber = seatNumber;
    }

    int getTicketNumber() {
        return ticketNumber;
    }

    int getSeatNumber() {
        return seatNumber;
    }

    void display() {
        System.out.println("Ticket #" + ticketNumber + " | Customer: " + customerName + " | Seat: " + seatNumber);
    }
}

class BookingSystem {
    private Ticket[] tickets = new Ticket[10];

    void bookTicket(int ticketNumber, String customerName, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10) {
            System.out.println("Invalid seat number. Must be between 1 and 10.");
            return;
        }

        if (isSeatTaken(seatNumber)) {
            System.out.println("Seat " + seatNumber + " is already booked.");
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == null) {
                tickets[i] = new Ticket(ticketNumber, customerName, seatNumber);
                System.out.println("Ticket booked for " + customerName + " at seat " + seatNumber);
                return;
            }
        }

        System.out.println("All seats are booked.");
    }

    boolean isSeatTaken(int seatNumber) {
        for (Ticket t : tickets) {
            if (t != null && t.getSeatNumber() == seatNumber) {
                return true;
            }
        }
        return false;
    }

    void cancelTicket(int ticketNumber) {
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] != null && tickets[i].getTicketNumber() == ticketNumber) {
                System.out.println("Ticket #" + ticketNumber + " cancelled (Seat " + tickets[i].getSeatNumber() + ").");
                tickets[i] = null;
                return;
            }
        }
        System.out.println("Ticket #" + ticketNumber + " not found.");
    }

    void displayAllTickets() {
        System.out.println("\nCurrent Bookings:");
        boolean anyBooked = false;
        for (Ticket t : tickets) {
            if (t != null) {
                t.display();
                anyBooked = true;
            }
        }
        if (!anyBooked) {
            System.out.println("No tickets booked.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        BookingSystem system = new BookingSystem();

        system.bookTicket(1, "Alice", 1);
        system.bookTicket(2, "Bob", 2);
        system.bookTicket(3, "Charlie", 3);

        system.cancelTicket(2);

        system.bookTicket(4, "David", 2);

        system.displayAllTickets();
    }
}
