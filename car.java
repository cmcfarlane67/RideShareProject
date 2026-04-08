import java.util.ArrayList;

public class Car {
    private int location;
    private int destination;
    private ArrayList<Passenger> riders;
    private int idNum;

    public Car(int idNum, int location, int destination) {
        this.idNum = idNum;
        this.location = location;
        this.destination = destination;
        riders = new ArrayList<>();
    }

    public int getLocation() {
        return location;
    }

    public int getDestination(){
        return destination;
    }

    public int getDirection() {
        if (destination > location) return 1;
        else return -1;
    }

    public boolean isFinished() {
        return location == destination;
    }

    public boolean hasSpace() {
        return riders.size() < 3;
    }

    public boolean canTakePassenger(Passenger p) {
        return hasSpace() && getDirection() == p.getDirection(location);
    }

    public void addPassenger(Passenger p) {
        if (hasSpace()) {
            riders.add(p);
            p.setInCar(true);
        }
    }

    public void move() {
        if (!isFinished()) location += getDirection();
    }

    public int unloadPassengers() {
        int count = 0;
        for (Passenger p : riders) {
            if (location == p.getDestination()) {
                p.complete();
                count++;
            } else {
                p.setInCar(false);
            }
        }
        riders.clear();
        return count;
    }

    public String toString() {
       return "Car ID " + idNum + " at " + location + " going to " + destination;
    }
}