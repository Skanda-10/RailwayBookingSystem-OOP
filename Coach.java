import java.util.LinkedList;
import java.util.Queue;

class Coach {
    private final String type;
    private final String[] seats = new String[60];
    private final Queue<BookingRequest> waitingList = new LinkedList<>();
    private final int MAX_WAITING = 10;

    public Coach(String type) {
        this.type = type;
    }

    public int getAvailableSeats() {
        int count = 0;
        for (String s : seats) if (s == null) count++;
        return count;
    }

    public void bookSeats(User user, int count) {
        int booked = 0;
        for (int i = 0; i < seats.length && booked < count; i++) {
            if (seats[i] == null) {
                seats[i] = user.getUsername();
                user.addBooking(type, i + 1, 100.0);
                System.out.println("Booked seat " + (i + 1) + " in " + type);
                booked++;
            }
        }
    }

    public void cancelSeat(User user, int seatNo) {
        if (seatNo < 1 || seatNo > 60 || !user.hasBooking(type, seatNo)) {
            System.out.println("Invalid cancellation.");
            return;
        }
        seats[seatNo - 1] = null;
        user.removeBooking(type, seatNo);
        System.out.println("Seat " + seatNo + " in " + type + " cancelled.");
        handleWaitingList();
    }

    private void handleWaitingList() {
        if (!waitingList.isEmpty()) {
            BookingRequest br = waitingList.poll();
            bookSeats(br.user, br.count);
        }
    }

    public void addToWaiting(User user, int count) {
        if (waitingList.size() < MAX_WAITING) {
            waitingList.add(new BookingRequest(user, count));
            System.out.println("Added to waiting list. Position: " + waitingList.size());
        } else {
            System.out.println("Waiting list full.");
        }
    }

    public void printChart() {
        System.out.println("\nChart for " + type + " Coach:");
        for (int i = 0; i < seats.length; i++) {
            System.out.println("Seat " + (i + 1) + ": " + (seats[i] == null ? "Empty" : seats[i]));
        }
    }
}