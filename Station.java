import java.util.ArrayList;

public class Station {
    private int id;
    private ArrayList<Passenger> waiting;

    public Station(int id) {
        this.id = id;
        waiting = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public ArrayList<Passenger> getWaitingPassengers() {
        return waiting;
    }

    public void addPassenger(Passenger p) {
        waiting.add(p);
    }

    public void removePassenger(Passenger p) {
        waiting.remove(p);
    }

    public String toString() {
        return "Station " + id + " has " + waiting.size() + " passengers waiting";
    }
}