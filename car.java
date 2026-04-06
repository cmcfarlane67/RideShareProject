import java.util.ArrayList;

public class Car {
    private int location;
    private ArrayList<Passenger> people;
    private int initialStation;
    private int destination;
    private boolean forward;
    private boolean moveable;
    private int distanceTraveled;

    public Car(int startLocation, int destination) {
        this.initialStation = startLocation;
        this.destination = destination;
        this.location = startLocation;
        this.people = new ArrayList<>();
        this.forward = destination > startLocation;
        this.moveable = true;
        this.distanceTraveled = 0;
    }

    public Car(int startLocation) {
        this(startLocation, startLocation);
    }

    public void pickup(Passenger p) {
        if (people.size() < 4 && p.getLocation() == location) {
            people.add(p);
        }
    }

    public void dropoffAtCurrentLocation() {
        ArrayList<Passenger> dropped = new ArrayList<>();
        for (Passenger p : people) {
            if (p.getDestination() == location) {
                dropped.add(p);
            }
        }
        people.removeAll(dropped);
    }

    public void move() {
        if (!moveable) return;

        if (location < destination) {
            location++;
            forward = true;
        } else if (location > destination) {
            location--;
            forward = false;
        }
        distanceTraveled++;

        dropoffAtCurrentLocation();
    }

    public ArrayList<Passenger> getPeople() {
        return people;
    }

    public int getLocation() {
        return location;
    }

    public boolean getDirection() {
        return forward;
    }

    public boolean isMoveable() {
        return moveable;
    }

    public void setMoveable(boolean status) {
        moveable = status;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public int getDestination() {
        return destination;
    }

    public String toString() {
        return "Initial station: " + initialStation + 
               " Location: " + location + 
               " Number of people: " + people.size();
    }
}