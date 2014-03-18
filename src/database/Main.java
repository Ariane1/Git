/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author Ariane
 */
import java.sql.*;

public class Main {

    Connection conn;

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/coffeebreak";
            conn = DriverManager.getConnection(url, "root", "");
            //doInsert("chocolat", 5);
            //doInsert("capuccino", 6);
            //doUpdate();
            //doDelete();
            doDeleteAll();
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            System.err.println(ex.getMessage());
        } catch (InstantiationException ex) {
            System.err.println(ex.getMessage());
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doTests() {
        doSelectTest();

        doInsertTest();
        doSelectTest();
        doUpdateTest();
        doSelectTest();
        doDeleteTest();
        doSelectTest();
    }

    private void doSelectTest() {
        System.out.println("[OUTPUT FROM SELECT]");
        String query = "SELECT COF_NAME, PRICE FROM COFFEES";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String s = rs.getString("COF_NAME");
                float n = rs.getFloat("PRICE");
                System.out.println(s + "   " + n);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doInsertTest() {
        System.out.print("\n[Performing INSERT] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO COFFEES "
                    + "VALUES ('chocolat', 5)");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doUpdateTest() {
        System.out.print("\n[Performing UPDATE] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='chocolat'");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doDeleteTest() {
        System.out.print("\n[Performing DELETING CHOCOLAT FROM COFFEES] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='chocolat'");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //add to coffees table the chocolat and capuccino
    private void doInsert(String typeCoffee, int price) {
        System.out.print("\n[Performing INSERT] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO COFFEES "
                    + "VALUES ('" + typeCoffee + "', " + price + " )");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //add 1euro to price
    private void doUpdate() {
        System.out.print("\n[Performing UPDATE] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE COFFEES SET PRICE = PRICE + 1");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }   
    
    //delete item from cofees table when price >6
    private void doDelete() {
        System.out.print("\n[Performing DELETE] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM COFFEES WHERE PRICE > 6");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    //delete all from cofees table
    private void doDeleteAll() {
        System.out.print("\n[Performing DELETE ALL] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("TRUNCATE TABLE COFFEES");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
