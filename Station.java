import java.util.*;

public class Station {
    private int stationNumber;
    private ArrayList<Passenger> waitingLeft;
    private ArrayList<Passenger> waitingRight;
    private ArrayList<Passenger> done;

    public Station(int myStationNumber){
        stationNumber = myStationNumber;
        waitingLeft = new ArrayList<Passenger>();
        waitingRight = new ArrayList<Passenger>();
        done = new ArrayList<Passenger>();
    }

    public void addPerson(Passenger p){
        if(p.getDestination() == stationNumber){
            done.add(p);
        } else if (p.getDirection()){
            waitingRight.add(p);
        } else {
            waitingLeft.add(p);
        }
    }

    public Passenger nextLeft(){
        if(waitingLeft.size() > 0){
            return waitingLeft.remove(0);
        } else {
            return null;
        }
    }

    public Passenger nextRight(){
        if(waitingRight.size() > 0){
            return waitingRight.remove(0);
        } else {
            return null;
        }
    }

    public int doneCount(){
        return done.size();
    }

    public String toString(){
        String s = "Station: " + stationNumber + "\n";
        s += "Leftbound: " + waitingLeft.toString() + "\n";
        s += "Rightbound: " + waitingRight.toString() + "\n";
        s += "Done: " + done.toString() + "\n";
        return s;
    }

    public int getStationNumber() {
        return stationNumber;
    }
}