package Bus_Reservation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    private static final String url = "jdbc:mysql://localhost:3306/busRrs";
    private static final String username = "root";
    private static final String password = "25022003#pP";


    public static Connection getBusDBCon() throws SQLException{//sometimes connection may lose so throws is used
        // connection class is returned by the DriverManager class so we are returning the object
        return DriverManager.getConnection(url, username, password);//Connection con =  DriverManager.getConnection(url, username, password);
    }
}
