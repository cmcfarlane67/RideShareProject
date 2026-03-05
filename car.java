public class Car {
    
    private int location;
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