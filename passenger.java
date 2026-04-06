public class Passenger {
   
    private int destination;
    private boolean direction; //true for going right, false for left
    private int startLocation;
    private int originalDestination;
    private int location;
    private int idNum;
    private static int nextID = 1;
    

    //constructors
       public Passenger(int myDestination, int myStart) {
        startLocation = myStart;
        destination = myDestination;
        originalDestination = myDestination;
        location = myStart;
        direction = destination > startLocation;
        idNum = nextID++;
    }
   
 
    //methods
    public void setLocation(int location) {
        this.location = location;
    }

    public int getDestination(){
        return destination;
    }

    public int getOriginalDestination() {
        return originalDestination;
    }
    
    public int getID(){
    return idNum;
    }   

    public int getLocation() {
        return location;
    }

    public boolean getDirection(){
        return direction;
    }
 
 
    public int getStart(){
        return startLocation;
    }
 
 
     public String toString() {
        return "ID: " + idNum + " Start: " + startLocation + " Dest: " + destination 
               + " OrigDest: " + originalDestination + " Loc: " + location 
               + " Going right? " + direction;
    }
}

