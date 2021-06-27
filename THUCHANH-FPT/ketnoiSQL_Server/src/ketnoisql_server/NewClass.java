/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ketnoisql_server;

import com.sun.jdi.connect.spi.Connection;
import java.net.*;
import java.sql.*;
/**
 *
 * @author Dang Dinh Vu
 */
public class NewClass {
    public static void main(String[] args) throws ClassNotFoundException {
//        String user = "sa";
//        String pass = "v06052002";
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
////          System.out.println("1");
//        String url = "jdbc:sqlserver://localhost:1433;databaseName =QLDA";
//       
//        Connection con = DriverManager.getConnection(url, user, pass);
//            String SQL = "SELECT TOP 10 * FROM Person.Contact";
//           PreparedStatement presPreparedStatement=Connection.
//
//            // Iterate through the data in the result set and display it.
//            while (rs.next()) {
//                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
//            }
//        } // Handle any errors that may have occurred.// Handle any errors that may have occurred.
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//        } catch (Exception e) {
//        }

     // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://<server>:<port>;databaseName=AdventureWorks;user=<user>;password=<password>";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            String SQL = "SELECT TOP 10 * FROM Person.Contact";
            ResultSet rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            while (rs.next()) {
                System.out.println(rs.getString("FirstName") + " " + rs.getString("LastName"));
            }
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
