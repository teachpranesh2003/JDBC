package Bus_Reservation;
import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String args[]) throws SQLException{
       BusDAO busdao = new BusDAO();
       busdao.getBusDisplayInfo();

        int userinput = 1;
        Scanner in = new Scanner(System.in);

        
        while(userinput == 1){
            System.out.println("Enter 1 to Book and 2 to exit");
            userinput = in.nextInt();
            if(userinput==1){
                
               Booking book = new Booking();
               
                if(book.isAvailable()){
                   
                     BookingDAO bookdao = new BookingDAO();
                     bookdao.addBooking(book);
                    System.out.println("Booking conformed");
                }
                else{
                    System.out.println("bus full");
                }
            }
        }

        
        




    }
}
