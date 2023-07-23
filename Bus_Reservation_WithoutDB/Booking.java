package Bus_Reservation_WithoutDB;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Booking {
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
        public  boolean isAvailable(ArrayList<Booking>book , ArrayList<Bus> bus){
            int capacity =0;
            for(Bus i : bus){
                if(i.getBusno().equals(busno)){
                    System.out.println(i.getBusno());
                    capacity = i.getCapacity();
                }
            }
            int booked=0;
            for(Booking i : book){
                if(i.busno.equals(busno) && i.date.equals(date)){// here the date and bus name booking capacity increase and check in the same date
                                                          // checking the availability
                    booked++; 
                }
            }

            return booked<capacity?true:false;
        }

    }


