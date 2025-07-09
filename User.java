import java.util.ArrayList;
import java.util.List;

class User {
    private final String name;
    private final String mobile;
    private final String username;
    private final String password;
    private final List<BookingHistory> history = new ArrayList<>();

    public User(String name, String mobile, String username, String password) {
        this.name = name;
        this.mobile = mobile;
        this.username = username;
        this.password = password;
    }

    public String getName() { return name; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }

    public void addBooking(String coach, int seat, double fare) {
        history.add(new BookingHistory(coach, seat, fare));
    }

    public boolean hasBooking(String coach, int seat) {
        return history.stream().anyMatch(h -> h.getCoach().equalsIgnoreCase(coach) && h.getSeat() == seat);
    }

    public void removeBooking(String coach, int seat) {
        history.removeIf(h -> h.getCoach().equalsIgnoreCase(coach) && h.getSeat() == seat);
    }

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("No booking history.");
            return;
        }
        System.out.println("Booking History:");
        for (BookingHistory h : history) {
            System.out.println(h);
        }
    }
}