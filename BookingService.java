import java.util.Scanner;

class BookingService {
    private final Train train = new Train();
    private final Scanner in = new Scanner(System.in);
    private final UserService userService;

    public BookingService(UserService userService) {
        this.userService = userService;
    }

    public void bookTickets(User user) {
        System.out.print("Coach (AC/NonAC/Sleeper): ");
        String coachType = in.next();
        System.out.print("No. of tickets: ");
        int count = in.nextInt();

        if (train.checkAvailability(coachType) >= count) {
            train.book(user, coachType, count);
        } else {
            System.out.println("Not enough seats. Added to waiting list.");
            train.addToWaitingList(user, coachType, count);
        }
    }

    public void cancelTicket(User user) {
        user.printHistory();
        System.out.print("Coach: ");
        String coach = in.next();
        System.out.print("Seat No: ");
        int seat = in.nextInt();

        train.cancel(user, coach, seat);
    }

    public void prepareChart() {
        train.prepareChart();
    }
}