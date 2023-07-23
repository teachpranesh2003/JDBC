package Bus_Reservation;
import java.sql.*;


public class BusDAO {//Bus DATA ACCESS OBJECT
    public void getBusDisplayInfo() throws SQLException{
        String query = "select * from Bus;";
        Connection con = DBCon.getBusDBCon();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
            System.out.println("BusName:"+rs.getString(1));
            if(rs.getInt(2)==0){
            System.out.println("BusAC: No");
            }
            else{
            System.out.println("BusAC: Yes");
 
            }
            System.out.println("BusCapacity:"+rs.getInt(3));
        }
    }

    public int getCapacity(String bname) throws SQLException{
        Connection con = DBCon.getBusDBCon();
        String query = "select capacity from bus where busname =?";
        

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, bname);
        ResultSet rs = st.executeQuery();
        rs.next();// it needed to move to value from column
            System.out.println(rs.getInt(1));
        return rs.getInt(1);

    }
}
