package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnectionTesting {

    public static void main(String[] args) {
        RetriveResultSet("select * from materials");    
        ChangeData("update materials set title = ? where id = ?", "A Second test", 1);
        RetriveResultSet("select * from materials");
    }
    
    public static void ChangeData(String sql, String title, int id){
        Connection conn = null;
        PreparedStatement stm = null;
        
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                stm = conn.prepareStatement(sql);
                stm.setString(1, title);
                stm.setInt(2, id);
                
                int results = stm.executeUpdate();
                
                System.out.println("Records amended" + results);
   
            } finally {
                if(stm != null) stm.close();
                if(conn != null) conn.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Something went wrong");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e);

        }
    
    }
    
    public static void RetriveResultSet(String sql) {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            try {
                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                stm = conn.createStatement();

                rs = stm.executeQuery(sql);

                while (rs.next()) {
                    System.out.println(rs.getString("title"));
                }
            } finally {
                if(rs!= null) rs.close();
                if(stm != null) stm.close();
                if(conn != null) conn.close();
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Something went wrong");
            System.out.println(e);
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e);

        }
    }
}
