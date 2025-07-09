class BookingHistory {
    private final String coach;
    private final int seat;
    private final double fare;

    public BookingHistory(String coach, int seat, double fare) {
        this.coach = coach;
        this.seat = seat;
        this.fare = fare;
    }

    public String getCoach() { return coach; }
    public int getSeat() { return seat; }

    @Override
    public String toString() {
        return "Coach: " + coach + ", Seat: " + seat + ", Fare: " + fare;
    }
}
