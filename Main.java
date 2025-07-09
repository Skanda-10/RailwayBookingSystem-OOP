import java.util.*;
public class Main {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            UserService userService = new UserService();
            BookingService bookingService = new BookingService(userService);

            System.out.println("Welcome to Railway Booking Console");

            User currentUser = null;

            while (currentUser == null) {
                System.out.print("Login/Signup: ");
                String action = in.next();

                if (action.equalsIgnoreCase("login")) {
                    System.out.print("Username: ");
                    String username = in.next();
                    System.out.print("Password: ");
                    String password = in.next();
                    currentUser = userService.login(username, password);

                    if (currentUser == null) {
                        System.out.println("Invalid credentials. Try again or signup.");
                    }
                } else if (action.equalsIgnoreCase("signup")) {
                    System.out.print("Name: ");
                    String name = in.next();
                    System.out.print("Mobile No: ");
                    String mobile = in.next();
                    System.out.print("Username: ");
                    String username = in.next();
                    System.out.print("Password: ");
                    String password = in.next();

                    userService.signup(name, mobile, username, password);
                }
            }

            while (true) {
                System.out.println("\n1. Book Tickets\n2. Cancel Ticket\n3. View History\n4. Prepare Chart\n5. Exit");
                System.out.print("Choose: ");
                int choice = in.nextInt();

                switch (choice) {
                    case 1 -> bookingService.bookTickets(currentUser);
                    case 2 -> bookingService.cancelTicket(currentUser);
                    case 3 -> currentUser.printHistory();
                    case 4 -> bookingService.prepareChart();
                    case 5 -> {
                        System.out.println("Thank you. Bye!");
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }