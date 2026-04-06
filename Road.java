import java.util.ArrayList;

public class Road {
    private ArrayList<Car> cars;
    private Station[] stations;
    private int completedPeople;

    public Road() {
        cars = new ArrayList<>();
        stations = new Station[32]; // 32 stations for 0–31 miles
        for (int i = 0; i < 32; i++) {
            stations[i] = new Station(i);
        }
        completedPeople = 0;
    }

    public void addPassengers(int num) {
        for (int i = 0; i < num; i++) {
            int start = (int)(Math.random() * 32);
            int dest = (int)(Math.random() * 32);
            while (dest == start) dest = (int)(Math.random() * 32);

            Passenger p = new Passenger(dest);
            stations[start].addPassenger(p);
        }
    }

    public void addCars(int num) {
        for (int i = 0; i < num; i++) {
            int start = (int)(Math.random() * 32);
            int dest = (int)(Math.random() * 32);
            while (dest == start) dest = (int)(Math.random() * 32);

            cars.add(new Car(start, dest));
        }
    }

    public boolean carsLeft() {
        return !cars.isEmpty();
    }

    public int getCompleted() {
        return completedPeople;
    }

    public void update() {
        // Pick up passengers at each car's location
        for (Car c : cars) {
            Station s = stations[c.getLocation()];
            ArrayList<Passenger> waitingCopy = new ArrayList<>(s.getWaitingPassengers());
            for (Passenger p : waitingCopy) {
                if (c.canTakePassenger(p)) {
                    c.addPassenger(p);
                    s.removePassenger(p);
                }
            }
        }

        // Move cars
        for (Car c : cars) c.move();

        // Unload and remove finished cars
        for (int i = cars.size() - 1; i >= 0; i--) {
            Car c = cars.get(i);
            if (c.isFinished()) {
                completedPeople += c.unloadPassengers();
                cars.remove(i);
            }
        }
    }

    public String toString() {
        return "Cars left: " + cars.size() + ", Completed passengers: " + completedPeople;
    }
}