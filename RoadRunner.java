public class RoadRunner {
    public static void main(String[] args) {
        Road r = new Road();
    
        r.addPassengers(50);
        r.addCars(40);

        for(int i = 0; i < 32; i++){
            System.out.println(r);
            r.update();
        }
        System.out.println("Final resul");
        System.out.println(r);
        System.out.println("Amount of successes" + r.getCompleted());

       
    }
}