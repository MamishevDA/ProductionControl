package ru.ProductionControl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dmitriy.mamishev
 */
public class ConnectDB {

    private static Connection connect = null;

    private static Connection getConnection() {
        try {
            if (connect == null) {
                Class.forName("org.postgresql.Driver").newInstance();
                connect = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres", "postgres", "123");
            }
            return connect;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }

    public static ResultSet getDBQuery(String sql) throws SQLException {
        PreparedStatement prstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        //String sql = "select t.\"Id\", t.\"Description\", t.\"Name\" from \"ProductionControl\".\"Recipe\" t";
        prstm = ConnectDB.getConnection().prepareStatement(sql);
//        String sql = "select t.\"Id\", t.\"Name\" from \"ProductionControl\".\"Recipt\" t where t.\"Id\" = ?";
//        prstm = ConnectDB.getConnection().prepareStatement(sql);
//        prstm.setInt(1, 1);
        rs = prstm.executeQuery();

        return rs;
    }
    
    public static boolean addRecipt(Recipe recipe){
        try {
            PreparedStatement prstm = null;
            String sql = "INSERT INTO \"ProductionControl\".\"Recipe\" (\"Name\", \"Description\", \"MainIngredient\") \n" +
"	VALUES (?, ?, ?)";
            prstm = ConnectDB.getConnection().prepareStatement(sql);
            prstm.setString(1, recipe.getName());
            prstm.setString(2, recipe.getDescription());
            prstm.setString(3, recipe.getMainIngredient());
            prstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public static void main(String args[]) throws SQLException {
        ResultSet rs = ConnectDB.getDBQuery("111");
        while (rs.next()) {
            System.out.println(rs.getInt("Id")
                    + rs.getString("Name"));
        }
      //  System.out.print(ConnectDB.addRecipt("some", "one"));
    }

}
