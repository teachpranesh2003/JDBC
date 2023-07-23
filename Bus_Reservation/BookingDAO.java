package Bus_Reservation;
import java.sql.*;
import java.util.Date;



public class BookingDAO {

    public int getBookedCount(String busno, Date date) throws SQLException { // data is util date
        String query="select count(passName) from Booking where busname=? and dates =?;";
        Connection con = DBCon.getBusDBCon(); 
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(date.getTime());
        pst.setString(1,busno);
        pst.setDate(2,sqldate);
        
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
        
        
        
    }

    public void addBooking(Booking book) throws SQLException {
        String query = "insert into booking values(?,?,?);";
        Connection con = DBCon.getBusDBCon();
        PreparedStatement st = con.prepareStatement(query);
        java.sql.Date sqldate = new java.sql.Date(book.date.getTime());
        st.setString(1,book.passengerName);
        st.setString(2, book.busno);
        st.setDate(3,sqldate);

        st.executeUpdate();
        
    }
     
}
