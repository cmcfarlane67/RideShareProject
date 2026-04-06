import java.util.ArrayList;

public class Station {
    private int stationNumber;
    private ArrayList<Passenger> waitingLeft;
    private ArrayList<Passenger> waitingRight;
    private ArrayList<Passenger> done;

    public Station(int myStationNumber) {
        stationNumber = myStationNumber;
        waitingLeft = new ArrayList<>();
        waitingRight = new ArrayList<>();
        done = new ArrayList<>();
    }

    public void addPerson(Passenger p) {
        if (p.getDestination() == stationNumber) {
            done.add(p);
        } else if (p.getDirection()) {
            waitingRight.add(p);
        } else {
            waitingLeft.add(p);
        }
    }

    public Passenger nextLeft() {
        if (!waitingLeft.isEmpty()) {
            return waitingLeft.remove(0);
        }
        return null;
    }

    public Passenger nextRight() {
        if (!waitingRight.isEmpty()) {
            return waitingRight.remove(0);
        }
        return null;
    }

    public int doneCount() {
        return done.size();
    }

    public String toString() {
        return "Station: " + stationNumber + "\n" +
               "Leftbound: " + waitingLeft.toString() + "\n" +
               "Rightbound: " + waitingRight.toString() + "\n" +
               "Done: " + done.toString() + "\n";
    }

    public int getStationNumber() {
        return stationNumber;
    }
}