package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MaterialCatalogDatabaseVersion implements MaterialCatalogInterface {

    public MaterialCatalogDatabaseVersion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void addMaterial(Material newMaterial) {

        Connection conn = null;
        PreparedStatement stm = null;

        try {

            try {

                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                if (newMaterial instanceof Book) {
                    Book newBook = (Book) newMaterial;

                    String sql = "insert into materials (barcode, titile, author, isbn, numberofpages, branch, type) values(?,?,?,?,?,?, 'BOOK')";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, newBook.getID());
                    stm.setString(2, newBook.getTitle());
                    stm.setString(3, newBook.getAuthor());
                    stm.setString(4, newBook.getIsbn());
                    stm.setInt(5, newBook.getNumberOfPages());
                    stm.setString(6, "AnyTown Branch");

                } else if (newMaterial instanceof DVD) {
                    DVD newDVD = (DVD) newMaterial;

                    String sql = "insert into materials (barcode, titile, catalognumber, runningtime, licenced, branch, type) values(?,?,?,?,?,?, 'DVD')";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, newDVD.getID());
                    stm.setString(2, newDVD.getTitle());
                    stm.setString(3, newDVD.getCatalogNumber());
                    stm.setInt(4, newDVD.getRunningTime());
                    stm.setBoolean(5, newDVD.getLicenced());
                    stm.setString(6, "AnyTown Branch");
                }

                int results = stm.executeUpdate();
                System.out.println("Records added: " + results);

            } finally {
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }

            //execute the prepared statement
        } catch (SQLException e) {
            System.out.println("Something went wrong");
            System.out.println(e);

        }
    }

    @Override
    public Map<String, Material> getMaterialMap() {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                stm = conn.createStatement();

                rs = stm.executeQuery("select * from materials");

                Map<String, Material> allMaterials = new LinkedHashMap<String, Material>();

                while (rs.next()) {
                    String materialType = rs.getString("type");

                    if (materialType.equalsIgnoreCase("BOOK")) {
                        Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                        allMaterials.put(rs.getString("barcode"), newBook);
                    } else if (materialType.equalsIgnoreCase("DVD")) {
                        DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"), rs.getInt("runningtime"));
                        allMaterials.put(rs.getString("barcode"), newDVD);
                    }
                }
                return allMaterials;

            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Material findMaterial(String title) throws MaterialNotFoundException {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                stm = conn.createStatement();

                rs = stm.executeQuery("select * from materials where title like '%" + title + "%'");

                if (rs.next()) {
                    String materialType = rs.getString("type");

                    if (materialType.equalsIgnoreCase("BOOK")) {
                        Book newBook = new Book(rs.getString("barcode"), rs.getString("title"), rs.getString("author"), rs.getString("isbn"), rs.getString("branch"), rs.getInt("numberofpages"));
                        return newBook;
                    } else if (materialType.equalsIgnoreCase("DVD")) {
                        DVD newDVD = new DVD(rs.getString("barcode"), rs.getString("title"), rs.getString("branch"), rs.getString("director"), rs.getString("catalognumber"), rs.getInt("runningtime"));
                        return newDVD;
                    } else {
                        throw new MaterialNotFoundException();
                    }
                } else {
                    throw new MaterialNotFoundException();
                }

            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getNumberOfMaterials() {
        Connection conn = null;
        Statement stm = null;
        ResultSet rs = null;
        try {

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/library", "root", "aca1984");

                stm = conn.createStatement();

                rs = stm.executeQuery("select count(id) from materials");
                rs.next();

                return rs.getInt(1);

            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
