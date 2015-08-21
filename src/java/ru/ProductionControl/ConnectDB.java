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
                connect = DriverManager.getConnection("jdbc:postgresql://127.0.0.1/postgres", "postgres", "123");
            }
            return connect;
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connect;
    }

    public static void main(String args[]) throws SQLException {
        PreparedStatement prstm = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        String sql = "select * from \"public\".\"Brand\" d where d.\"Id\" = ?";
        prstm = ConnectDB.getConnection().prepareStatement(sql);
        prstm.setInt(1, 2);
        rs = prstm.executeQuery();
        rsmd = rs.getMetaData();
        boolean getHead = true;
        while (rs.next()) {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                if (getHead) {
                    System.out.printf(rsmd.getColumnName(i) + " ");
                }

                System.out.printf("[" + rs.getString(i) + "]");
            }
            getHead = false;
            System.out.println();
        }

    }
}
