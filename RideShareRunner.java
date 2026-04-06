public class RideShareRunner {
    public static void main(String[] args) {
        int people = 50;

        System.out.println("----- SCENARIO 1: 20 CARS -----");
        runSimulation(people, 20);

        System.out.println("\n----- SCENARIO 2: 40 CARS -----");
        runSimulation(people, 40);
    }

    public static void runSimulation(int people, int cars) {
        Road road = new Road();
        road.addPassengers(people);
        road.addCars(cars);

        while (road.carsLeft()) {
            road.update();
            // Optional: print each step
            // System.out.println(road);
        }

        System.out.println(road.getCompleted() + " passengers made it to their destination.");
        System.out.printf("%.2f%% of passengers made it.\n", (double)road.getCompleted() / people * 100);
    }
}