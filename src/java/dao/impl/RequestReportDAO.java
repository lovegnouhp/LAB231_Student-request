/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package dao.impl;

import dao.DBContext;
import dao.IRequestReportDAO;
import entity.Department;
import entity.RequestReport;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * This class supplies all method need to display request report<br>
 * by department and time.<br>
 * The method implements IRequestReportDAO.<br>
 * The method will throw an object of <code>java.lang.Exception</code>
 * class.<br>
 * if there is any error occurring when searching or getting data.
 *
 * @author phuon
 */
public class RequestReportDAO extends DBContext implements IRequestReportDAO {

    /**
     * This method return all request reports available from Database<br>
     * last specific days.
     *
     * @param numberOfDays number of days to today
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    @Override
    public List<RequestReport> getRequestReportRecentDays(int numberOfDays) throws Exception {
        List<RequestReport> reports = new ArrayList<>();
        String sql = "SELECT\n"
                + "     [CountRequestByDept].[DepartmentID],\n"
                + "	d.[Name] AS [DepartmentName],\n"
                + "	[CountRequestByDept].[NumOfRequest]\n"
                + "FROM (\n"
                + "	SELECT \n"
                + "		[DepartmentID],\n"
                + "		COUNT([DepartmentID]) AS [NumOfRequest]\n"
                + "	FROM (\n"
                + "		SELECT * \n"
                + "		FROM [Request]\n"
                + "		WHERE [DateCreated] >= CAST(DATEADD(DAY, ?, GETDATE()) AS date)\n"
                + "		) AS [RequestByDate]\n"
                + "	GROUP BY [DepartmentID]\n"
                + "	) AS [CountRequestByDept]\n"
                + "	INNER JOIN [Department] d\n"
                + "	ON d.[ID] = [CountRequestByDept].[DepartmentID]";

        Connection connection = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            connection = getConnection();
            stm = connection.prepareStatement(sql);
            stm.setInt(1, 0 - numberOfDays);
            rs = stm.executeQuery();
            while (rs.next()) { // add to list until reach the end of result set
                RequestReport report = new RequestReport();
                Department d = new Department();
                d.setId(rs.getInt("DepartmentID"));
                d.setName(rs.getString("DepartmentName"));
                report.setDepartment(d);
                report.setNumberOfRequest(rs.getInt("NumOfRequest"));
                reports.add(report);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            closeConnection(connection);
            closePreparedStatement(stm);
            closeResultSet(rs);
        }
        return reports;
    }
}
