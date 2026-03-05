import java.util.ArrayList;

public class Road {
    private ArrayList<Car> cars;
    private ArrayList<Passenger> passengers;

    public Road(){
        cars = new ArrayList<Car>();
        passengers = new ArrayList<Passenger>();
    }

    public void addCar(Car c){
        cars.add(c);
    }

    public void addPassenger(Passenger p){
        passengers.add(p);
    }

    public void displayCars(){
        for(Car c : cars){
            System.out.println(c);
        }
    }

    public void displayPassengers(){
        for(Passenger p : passengers){
            System.out.println(p);
        }
    }
}
