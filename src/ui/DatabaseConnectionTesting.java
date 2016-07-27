
package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnectionTesting {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");
            
            Statement stm = conn.createStatement();
            
            ResultSet rs = stm.executeQuery("select * from materials");
            
            //do something here
            
            rs.close();
            stm.close();
            conn.close();
            
        }catch (Exception e){
            System.out.println("Something went wrong");
            System.out.println(e);
        }
    }
}
