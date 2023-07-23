package Bus_Reservation;

public class Bus { // ONLY THE MODEL OF DB
    private String busno;
    private boolean ac;
    private int capacity;

    Bus(String name , boolean ac , int cap){
        this.busno = name;
        this.ac = ac;
        this.capacity = cap;
    }

}
