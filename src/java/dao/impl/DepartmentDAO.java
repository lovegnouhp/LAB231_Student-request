/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-04      1.0              PhuongNVHE140784      Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IDepartmentDAO;
import entity.Department;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class supplies all method need to display an Department combobox.<br>
 * The method implements IDepartmentDAO.<br>
 * The method will throw an object of <code>java.lang.Exception</code>
 * class.<br>
 * if there is any error occurring when searching or getting data.
 *
 * @author phuon
 */
public class DepartmentDAO extends DBContext implements IDepartmentDAO {

    /**
     * This method return all departments available from Database.
     *
     * @return List of departments from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Department> getDepartments() throws Exception {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT [ID],[Name] FROM [Department]";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Department d = new Department();
                d.setId(rs.getInt("ID"));
                d.setName(rs.getString("Name"));
                departments.add(d);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return departments;
    }

}
