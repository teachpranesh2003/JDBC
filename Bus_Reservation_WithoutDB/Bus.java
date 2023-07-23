package Bus_Reservation_WithoutDB;

public class Bus {
    private String busno;
    private boolean ac;
    private int capacity;

    Bus(String name , boolean ac , int cap){
        this.busno = name;
        this.ac = ac;
        this.capacity = cap;
    }


    void displayBusInfo(){
        System.out.println("Busname:"+busno);
        System.out.println("Bus AC:"+ac);
        System.out.println("Bus Capacity:"+capacity);
    }
    public String getBusno(){
        return busno;
    }
    
    public int getCapacity(){
        return capacity;
    }

    public void setCapacity(int val){//mutators
        capacity = val;
    }
    public void setAc(boolean val){
        ac=val;
    }

}
