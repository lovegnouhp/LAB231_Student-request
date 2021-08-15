/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-06-30      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * USE BELOW METHOD FOR YOUR DATABASE CONNECTION <br>
 * FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)<br>
 * DO NOT EDIT THE BELOW METHOD, <br>
 * YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION
 *
 * @author phuon
 */
public class DBContext {

    /**
     * Insert your other code right after this comment<br>
     * Change/update information of your database connection,<br>
     * DO NOT change name of instance variables in this class
     */
    private final String serverName = "localhost";
    private final String dbName = "J3.L.P0010_Student-request-admin";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "sa";

    /**
     * This method open connection to Database.
     *
     * @return Connection of Database and Application.
     * @throws Exception
     */
    protected Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param con connection of application & database.
     */
    protected void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
        }
    }

    /**
     * This method close PreparedStatement, free system resources.
     *
     * @param ps prepared statement that was executed and not suppose to use.
     */
    protected void closePreparedStatement(PreparedStatement ps) {
        try {
            if (ps != null || !ps.isClosed()) {
                ps.close();
            }
        } catch (SQLException ex) {
        }
    }

    /**
     * This method close ResultSet, free system resources.
     *
     * @param rs a table of data representing a database result set.
     */
    protected void closeResultSet(ResultSet rs) {
        try {
            if (rs != null || !rs.isClosed()) {
                rs.close();
            }
        } catch (SQLException ex) {
        }
    }
}
