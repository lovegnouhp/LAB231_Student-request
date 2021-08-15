/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import entity.RequestReport;
import java.util.List;

/**
 * This interface contain methods about RequestReport<br>
 * <code>java.lang.Exception</code> throws when error occurs
 *
 * @author phuon
 */
public interface IRequestReportDAO {

    /**
     * This method return all request reports available from Database<br>
     * last specific days.
     *
     * @param numberOfDays number of days to today
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    public List<RequestReport> getRequestReportRecentDays(int numberOfDays) throws Exception;
}
