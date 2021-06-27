package ketnoi;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.*;


public class Ketnoi {
public static  void test() throws Exception
{
     String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=QLDA";
       Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try (Connection con = DriverManager.getConnection(connectionUrl,"sa","v06052002");
                Statement stmt = con.createStatement();
                ) {
//            PreparedStatement
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
        } // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
}
    public static void main(String[] args) {
         try {
            test();
        } catch (Exception e) {
        }
        
       
    }
}
