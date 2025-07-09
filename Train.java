import java.util.HashMap;
import java.util.Map;

class Train {
    private final Map<String, Coach> coaches = new HashMap<>();

    public Train() {
        coaches.put("ac", new Coach("AC"));
        coaches.put("nonac", new Coach("NonAC"));
        coaches.put("sleeper", new Coach("Sleeper"));
    }

    public int checkAvailability(String coach) {
        return coaches.get(coach.toLowerCase()).getAvailableSeats();
    }

    public void book(User user, String coachType, int count) {
        Coach coach = coaches.get(coachType.toLowerCase());
        coach.bookSeats(user, count);
    }

    public void cancel(User user, String coach, int seatNo) {
        Coach c = coaches.get(coach.toLowerCase());
        c.cancelSeat(user, seatNo);
    }

    public void addToWaitingList(User user, String coachType, int count) {
        coaches.get(coachType.toLowerCase()).addToWaiting(user, count);
    }

    public void prepareChart() {
        for (Coach c : coaches.values()) {
            c.printChart();
        }
    }
}
