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

    public static Connection getConnection() {
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

    public static ResultSet getDBQuery(String str) throws SQLException {
        PreparedStatement prstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        String sql = "select t.\"Id\", t.\"Description\", t.\"Name\" from \"ProductionControl\".\"Recipt\" t";
        prstm = ConnectDB.getConnection().prepareStatement(sql);
//        String sql = "select t.\"Id\", t.\"Name\" from \"ProductionControl\".\"Recipt\" t where t.\"Id\" = ?";
//        prstm = ConnectDB.getConnection().prepareStatement(sql);
//        prstm.setInt(1, 1);

        rs = prstm.executeQuery();

        return rs;
    }

    public static void main(String args[]) throws SQLException {

        ResultSet rs = ConnectDB.getDBQuery("111");

        while (rs.next()) {
            System.out.println(rs.getInt("Id")
                    + rs.getString("Name"));
        }
    }

}
