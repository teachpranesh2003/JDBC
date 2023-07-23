package Bus_Reservation;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {//
     String passengerName;
     String busno;
     Date date;

    Booking(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the name of passanger:");
        passengerName = in.next();
        System.out.println("Enter the BusName:");
        busno =  in.next();
        System.out.println("Enter date dd-mm-yyyy:");
        String dateInput = in.next();//we have to modify the string to date 
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        // it is a class to convert the string to date 
        try {
            date = dateFormat.parse(dateInput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        public  boolean isAvailable() throws SQLException{
            BusDAO busdao = new BusDAO();
            
            int capacity =busdao.getCapacity(busno);
            

            BookingDAO bookdao = new BookingDAO();

            int booked = bookdao.getBookedCount(busno,date);
            
            return booked < capacity?true:false;
        }

    }


