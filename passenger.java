import java.util.ArrayList;

public class Passenger {
    private int destination;
    private boolean direction;
    private int startLocation;
    private int originalDestination;
    private int location;
    private int idNum;
    private static int nextID = 1;

    public Passenger(int myDestination, int myStart) {
        startLocation = myStart;
        destination = myDestination;
        originalDestination = myDestination;
        location = myStart;
        direction = destination > startLocation;
        idNum = nextID++;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int getDestination() {
        return destination;
    }

    public int getOriginalDestination() {
        return originalDestination;
    }

    public int getID() {
        return idNum;
    }

    public int getLocation() {
        return location;
    }

    public boolean getDirection() {
        return direction;
    }

    public int getStart() {
        return startLocation;
    }

    public String toString() {
        return "ID: " + idNum + " Start: " + startLocation + " Dest: " + destination 
               + " OrigDest: " + originalDestination + " Loc: " + location 
               + " Going right? " + direction;
    }
}