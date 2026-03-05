public class car {

    private int location;

    public car(int startLocation){
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