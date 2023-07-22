package Basic;
import java.sql.*;
import java.util.concurrent.Callable;
public class JDBCDemo {
  
    public static void main(String args[]) throws Exception{
      //  InsertDBHardcODE();
      //  InsertDBVar() ;
      //  readDB();
      //  InsertDBPreparedST();
      //  DeleteDB();
      //  UpdateDB();
     // StoredProParaIn();
     StoredProParaOut();
     Autocommite();

    }
      public static void readDB() throws Exception{

        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";
        String query = "select * from employee";

        Connection cn = DriverManager.getConnection(url,username,password); // connection - is a interface 
                       //DriverManager is the one which chooses what DB language is .EX :SQL ,NOSQL ETC..
                       //getconnection() method will SET connection from the DB based on the given parameters

        Statement st = cn.createStatement(); // in order to run the query statement is needed 
        ResultSet rs = st.executeQuery(query); //here executeQuery is return ReturnSet as output so we create a class as ResultSet
       // rs.next();  // increment to next and return true if next column is availabel else return false
       // int num = rs.getInt(1);  //getInt - datatype of column 1 and getINt(1) 1 as column attribute
        
       while(rs.next()){
        System.out.println("ID:"+rs.getInt(1));
        System.out.println("Name:"+rs.getString(2));
        System.out.println("Salary:"+rs.getInt(3));
       }
      }
       
      public static void InsertDBHardcODE() throws Exception{

        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";
        String query = "insert into employee values(123,'priya',90899)";

        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        int rows = st.executeUpdate(query); // it returns a Integer value of how many rows affected
        System.out.println("No.of rows affected:"+rows);

      }
      public static void InsertDBVar() throws Exception{
      String url = "jdbc:mysql://localhost:3306/Jdbc";
      String username = "root";
      String password = "25022003#pP";

      int id = 134;
      String name = "praneshmom";
      int salary = 567890;
      String query = "insert into employee values("+id+",'"+name+"',"+salary+");";

      Connection con = DriverManager.getConnection(url,username,password);
      Statement st = con.createStatement();
      int rows = st.executeUpdate(query);

      System.out.println("No.of rows affected:"+rows);
    }

      public static void InsertDBPreparedST() throws Exception{
      String url = "jdbc:mysql://localhost:3306/Jdbc";
      String username = "root";
      String password = "25022003#pP";

      int id = 135;
      String name = "praneshdad";
      int salary = 70000;

      String query = "insert into employee values(?,?,?);";

      Connection con = DriverManager.getConnection(url, username, password);
      PreparedStatement pst = con.prepareStatement(query); //preparestatement returns PrepareStatement so we created obj for the PreparedStatement class
     
      // we have link the ? to the variables
      pst.setInt(1,id); //setInt datatype , 1 -> which ? , then followed by variable
      pst.setString(2,name);
      pst.setInt(3,salary);

      int rows = pst.executeUpdate(); // here the executeUpdate no need of parameter bcz it is passed in pst itself 
      System.out.println("no.of rows affected:"+rows);
        }


      public static void DeleteDB() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Jdbc";
      String username = "root";
      String password = "25022003#pP";
      int id = 5;
      String query = "delete from employee where id="+id+";";
      Connection con = DriverManager.getConnection(url,username,password);
      Statement st = con.createStatement();
      int num = st.executeUpdate(query);
      System.out.println("no.of rows affected:"+num);

      }
    
      public static void UpdateDB() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";

        int id = 134;
        String query = "update employee set salary =14000 where id ="+id+";";

        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        int num = st.executeUpdate(query);

        System.out.println("no of rows affected:"+num);
      }

      public static void StoredPro() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";

        Connection con = DriverManager.getConnection(url, username, password);
        CallableStatement cts = con.prepareCall("{call SB()}");
        ResultSet rs = cts.executeQuery();
          
       while(rs.next()){
        System.out.println("ID:"+rs.getInt(1));
        System.out.println("Name:"+rs.getString(2));
        System.out.println("Salary:"+rs.getInt(3));
       }
      }
      

      public static void StoredProParaIn() throws Exception{

        // only in parameter
        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";
        int id = 134;
        Connection con = DriverManager.getConnection(url,username,password);
        CallableStatement cst = con.prepareCall("{call SBPara(?)}");

        cst.setInt(1,id);   // here the data is sent as input to the database 
                                           //Callable statement parameter function
        ResultSet rs = cst.executeQuery();  //it returns resultSet so it is mentioned ans created a object for it
        while(rs.next()){
        System.out.println("ID:"+rs.getInt(1));
        System.out.println("Name:"+rs.getString(2));
        System.out.println("Salary:"+rs.getInt(3));
       }
      }

      public static void StoredProParaOut() throws Exception{
          String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";
        int id =134;
        Connection con = DriverManager.getConnection(url, username, password);
        CallableStatement cst = con.prepareCall("{call SBparaOut(?,?)}");
        cst.setInt(1,id); //sending id as parameter using setInt
        cst.registerOutParameter(2,Types.VARCHAR);// we have tp register the out parameter here and also its type
        cst.executeUpdate();// we using this bcz we are updating the name variable to a value
        System.out.println(cst.getString(2));//get string using parameterIndex
        
      }

      public static void Autocommite() throws Exception{
        String url = "jdbc:mysql://localhost:3306/Jdbc";
        String username = "root";
        String password = "25022003#pP";
        
        String query = "update employee set salary = 500000 where id = 134";
        String query1 = "update employee set salary = 78888 where id =151";// error no id is there
        Connection con = DriverManager.getConnection(url, username, password);
        Statement st = con.createStatement();
        con.setAutoCommit(false);// we are setting autocommit to false so no changes in database

        int num = st.executeUpdate(query);
        int num1 = st.executeUpdate(query1);

        if(num>0&&num1>0){// if this condition is true the changes will reflect in Db
          con.commit();
        }

      
      }

       
       

    }
