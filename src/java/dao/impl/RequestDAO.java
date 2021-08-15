/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-14      1.0              PhuongNVHE140784      Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IRequestDAO;
import entity.Account;
import entity.Department;
import entity.Request;
import entity.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class supplies all method need to get requests by department id<br>
 * or date, id and update new request info.<br>
 * The method implements IRequestDAO.<br>
 * The method will throw an object of <code>java.lang.Exception</code> class<br>
 * if there is any error occurring when searching or getting data.
 *
 * @author phuon
 */
public class RequestDAO extends DBContext implements IRequestDAO {

    /**
     * This method return all requests available from Database<br>
     * which matched with department id.
     *
     * @param department department which have ID want to find
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Request> getRequests(Department department) throws Exception {
        List<Request> requests = new ArrayList<>();

        // departmentID = -1 ~> get all
        String sql = "SELECT r.[ID] AS [rid],[Title],[DateCreated],[CloseDate],[State],\n"
                + "	r.[DepartmentID], d.[Name] AS [DepartmentName]\n"
                + "FROM [Request] r\n"
                + "INNER JOIN [Department] d ON r.[DepartmentID] = d.[ID]\n"
                + "WHERE 1=1";
        if (department.getId() != -1) { // departmentID != -1 ~> get by deptID
            sql += " AND [DepartmentID] = " + department.getId() + ";";
        }

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Department d = new Department();
                d.setId(department.getId());
                d.setName(rs.getString("DepartmentName"));

                Request r = new Request();
                r.setId(rs.getInt("rid"));
                r.setTitle(rs.getString("Title"));
                r.setDateCreated(rs.getDate("DateCreated"));
                r.setCloseDate(rs.getDate("CloseDate"));
                r.setState(rs.getInt("State"));
                r.setDepartment(d);
                requests.add(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return requests;
    }

    /**
     * This method return all requests available from Database<br>
     * which title matched with txtTitle.
     *
     * @param txtTitle
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Request> getRequests(String txtTitle) throws Exception {
        List<Request> requests = new ArrayList<>();

        String sql = "SELECT r.[ID] AS [rid],[Title],[DateCreated],[CloseDate],[State],\n"
                + "	r.[DepartmentID], d.[Name] AS [DepartmentName]\n"
                + "FROM [Request] r\n"
                + "INNER JOIN [Department] d ON r.[DepartmentID] = d.[ID]\n"
                + "WHERE [Title] LIKE ?;";
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + txtTitle + "%");
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Department d = new Department();
                d.setId(rs.getInt("DepartmentID"));
                d.setName(rs.getString("DepartmentName"));

                Request r = new Request();
                r.setId(rs.getInt("rid"));
                r.setTitle(rs.getString("Title"));
                r.setDateCreated(rs.getDate("DateCreated"));
                r.setCloseDate(rs.getDate("CloseDate"));
                r.setState(rs.getInt("State"));
                r.setDepartment(d);
                requests.add(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return requests;
    }

    /**
     * This method return all requests available from Database<br>
     * which matched with department id last specific days.
     *
     * @param department department which have ID want to find
     * @param numberOfDays number of days to now
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<Request> getRequestsRecentDays(Department department, int numberOfDays) throws Exception {
        List<Request> requests = new ArrayList<>();
        String sql = "SELECT r.[ID] AS [rid],[Title],[DateCreated],[CloseDate],[State],\n"
                + "	r.[DepartmentID], d.[Name] AS [DepartmentName]\n"
                + "FROM [Request] r\n"
                + "INNER JOIN [Department] d ON r.[DepartmentID] = d.[ID]\n"
                + "WHERE [DateCreated] >= CAST(DATEADD(DAY, ?, GETDATE()) AS date)\n"
                + "	AND [DepartmentID] = ?";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, 0 - numberOfDays);
            stm.setInt(2, department.getId());
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                Department d = new Department();
                d.setId(rs.getInt("DepartmentID"));
                d.setName(rs.getString("DepartmentName"));

                Request r = new Request();
                r.setId(rs.getInt("rid"));
                r.setTitle(rs.getString("Title"));
                r.setDateCreated(rs.getDate("DateCreated"));
                r.setCloseDate(rs.getDate("CloseDate"));
                r.setState(rs.getInt("State"));
                r.setDepartment(d);
                requests.add(r);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return requests;
    }

    /**
     * This method return request available from Database<br>
     * which matched with id.
     *
     * @param id request id want to find
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public Request getRequest(int id) throws Exception {
        String sql = "SELECT r.[ID] AS [rid],\n"
                + "	[DepartmentID], d.[Name] AS [dName],\n"
                + "	[StudentID],s.[Name] AS [sName],\n"
                + "	[DateCreated],[Title],[Content],\n"
                + "	[State],[CloseDate],\n"
                + "	ISNULL([SolvedBy],'') AS [SolvedBy],\n"
                + "	ISNULL([AttachedURL],'') AS [AttachedURL],\n"
                + "	ISNULL([Solution],'') AS [Solution]\n"
                + "FROM [Request] r\n"
                + "INNER JOIN [Department] d ON r.[DepartmentID] = d.[ID]\n"
                + "INNER JOIN [Student] s ON r.[StudentID] = s.[ID]\n"
                + "WHERE r.[ID] = ?";
        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) { // found requests
                Request request = new Request();
                request.setId(rs.getInt("rid"));
                Department d = new Department();
                d.setId(rs.getInt("DepartmentID"));
                d.setName(rs.getString("dName"));
                request.setDepartment(d);
                Student s = new Student();
                s.setId(rs.getString("StudentID"));
                s.setName(rs.getString("sName"));
                request.setStudent(s);

                request.setDateCreated(rs.getDate("DateCreated"));
                request.setTitle(rs.getString("Title"));
                request.setContent(rs.getString("Content"));
                request.setState(rs.getInt("State"));
                request.setCloseDate(rs.getDate("CloseDate") == null ? null : rs.getDate("CloseDate"));
                Account solvedBy = new Account();
                solvedBy.setUsername(rs.getString("SolvedBy").isEmpty() ? "" : rs.getString("SolvedBy"));
                request.setSolvedBy(solvedBy);

                request.setAttachedURL(rs.getString("AttachedURL").isEmpty() ? "" : rs.getString("AttachedURL"));
                request.setSolution(rs.getString("Solution").isEmpty() ? "" : rs.getString("Solution"));
                request.setDepartment(d);
                return request;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return null;
    }

    /**
     * This method will update request from Database which matched with id.
     *
     * @param rq request want to update
     * @throws Exception provide information about database access error.
     */
    @Override
    public void updateRequest(Request rq) throws Exception {
        String sql = "UPDATE [Request]\n"
                + "SET \n"
                + "	[State] = ?,\n"
                + "	[CloseDate] = ?,\n"
                + "	[SolvedBy] = ?,\n"
                + "	[Solution] = ?\n"
                + " WHERE [ID] = ?";
        Connection connection = null;
        PreparedStatement stm = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, rq.getState());
            stm.setDate(2, rq.getCloseDate());
            stm.setString(3, rq.getSolvedBy().getUsername());
            stm.setString(4, rq.getSolution());
            stm.setInt(5, rq.getId());
            stm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
        }
    }
}
