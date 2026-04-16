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
    
    public int getId(){
        return idNum;
    }
    public int getDestination(){
        return destination;
    }

    public int getDirection() {
        if (destination > location) return 1;
        else return -1;
    }

    public ArrayList<Passenger> getRiders() {
        return riders;
    }

    public boolean isFinished() {
        return location == destination;
    }

    public boolean hasSpace() {
        return riders.size() < 3;
    }

    public boolean getDone() {
        return isFinished();
    }

    public int getloc() {
        return location;
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

    public void removePassenger(Passenger p) {
    riders.remove(p);
    }

    public int unloadPassengers(){
        int count = 0;
        ArrayList<Passenger> toRemove = new ArrayList<>();
        for (Passenger p : riders) {
            if (location == p.getDestination()) {
                p.complete();
                toRemove.add(p);
                count++;
            }
        }
        for (Passenger p : toRemove) {
            riders.remove(p);
        }

        return count;
    }
    
    public void pickUpPassengers(Station s){
        ArrayList<Passenger> waiting = new ArrayList<>(s.getWaitingPassengers());
        for (Passenger p : waiting) {
            if (canTakePassenger(p)) {
                addPassenger(p);
                s.removePassenger(p);
            }
        }
    }

    public void dropOffPassengers(ArrayList<Station> stations){
        ArrayList<Passenger> toRemove = new ArrayList<>();
        for (Passenger p : riders) {
            if (location == p.getDestination()){
                p.complete();
                toRemove.add(p);
            }
        }
        for (Passenger p : toRemove) {
            riders.remove(p);
        }
    }

    public String toString() {
       return "Car ID " + idNum + " at " + location + " going to " + destination;
    }
}