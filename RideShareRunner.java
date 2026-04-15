import java.util.ArrayList;

public class RideShareRunner {
    public static double runSimulation(int numCars){
    ArrayList<Station> stations = new ArrayList<>();
    ArrayList<Car> cars = new ArrayList<>();
    ArrayList<Passenger> allPassengers = new ArrayList<>();

    // create stations
    for(int i = 0; i <= 31; i++){
        stations.add(new Station(i));
        }

    // create passengers
    for(int i = 0; i < 50; i++){
        int start = (int)(Math.random() * 32);
        int dest;

        do{
            dest = (int)(Math.random() * 32);
        } while(dest == start);

        Passenger p = new Passenger(i, dest);
        stations.get(start).addPassenger(p);
        allPassengers.add(p);
    }

    // create cars
    for(int i = 0; i < numCars; i++){
        int start = (int)(Math.random() * 32);
        int dest;

        do{
            dest = (int)(Math.random() * 32);
        } while(dest == start);

        cars.add(new Car(i, start, dest));;
    }

    // simulation loop
    boolean running = true;

    while(running){
        running = false;

        for(Car c : cars){
            if(!c.getDone()){
                running = true;

                Station current = stations.get(c.getloc());

                c.pickUpPassengers(current);
                c.move();
                c.dropOffPassengers(stations);
            }
        }
    }

    // calculate success rate
    int arrivedCount = 0;
    for(Passenger p : allPassengers){
        if(p.hasArrived()){
            arrivedCount++;
        }
    }

    return (arrivedCount * 100.0 / allPassengers.size());
    }

    public static void main(String[] args){

    double result20 = runSimulation(20);
    double result40 = runSimulation(40);

    System.out.println("20 cars success rate: " + result20 + "%");
    System.out.println("40 cars success rate: " + result40 + "%");
}
}

