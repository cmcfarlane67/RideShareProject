public class Passenger {
    private int destination;
    private boolean completed;
    private boolean inCar;

    public Passenger(int destination) {
        this.destination = destination;
        completed = false;
        inCar = false;
    }

    public int getDestination() {
        return destination;
    }

    public boolean isCompleted() {
        return completed;
    }

    public boolean isInCar() {
        return inCar;
    }

    public void setInCar(boolean value) {
        inCar = value;
    }

    public void complete() {
        completed = true;
        inCar = false;
    }

    public int getDirection(int currentLocation) {
        if (destination > currentLocation) return 1;
        else return -1;
    }

    public String toString() {
        return "Passenger to " + destination;
    }
}