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

    public void pickup(Passenger p) {
        if (people.size() < 4) {
            people.add(p);
        }
    }

    public Passenger dropoff(int pos) {
        if (pos >= 0 && pos < people.size()) {
            return people.remove(pos);
        }
        return null;
    }

    public void remove(Passenger p) {
        people.remove(p);
    }

    public boolean getDirection() {
        return forward;
    }

    public ArrayList<Passenger> getPeople() {
        return people;
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

    public Car(int startLocation){
        location = startLocation;
    }

    public int getLocation(){
        return location;
    }

    public void moveRight(){
        location++;
    }

    public void moveLeft(){
        location--;
    }
}