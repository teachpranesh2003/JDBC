package Bus_Reservation_WithoutDB;
import java.util.*;

public class Main {
    public static void main(String args[]){
        ArrayList<Bus> bus = new ArrayList<Bus>();
        ArrayList<Booking> booking = new ArrayList<Booking>();
        bus.add(new Bus("Amman",true,34));
        bus.add(new Bus("NPS",false,50));
        bus.add(new Bus("BABU",true,1));

        int userinput = 1;
        Scanner in = new Scanner(System.in);

        for(Bus b :bus){
            b.displayBusInfo();
        }
        
        while(userinput == 1){
            System.out.println("Enter 1 to Book and 2 to exit");
            userinput = in.nextInt();
            if(userinput==1){
                Booking book = new Booking();
                if(book.isAvailable(booking,bus)){
                    booking.add(book);
                    System.out.println("Booking conformed");
                }
                else{
                    System.out.println("bus full");
                }
            }
        }

        




    }
}
