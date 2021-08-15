/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-14      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import entity.Department;
import entity.Request;
import java.util.List;

/**
 * This interface contain methods about request<br>
 * <code>java.lang.Exception</code> throws when error occurs
 *
 * @author phuon
 */
public interface IRequestDAO {

    /**
     * This method return all requests available from Database<br>
     * which matched with department id.
     *
     * @param department department which have ID want to find
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Request> getRequests(Department department) throws Exception;

    /**
     * This method return all requests available from Database<br>
     * which title matched with txtTitle.
     *
     * @param txtTitle
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Request> getRequests(String txtTitle) throws Exception;

    /**
     * This method return all requests available from Database<br>
     * which matched with department id last specific days.
     *
     * @param department department which have ID want to find
     * @param numberOfDays number of days to now
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Request> getRequestsRecentDays(Department department, int numberOfDays) throws Exception;

    /**
     * This method return request available from Database<br>
     * which matched with id.
     *
     * @param id request id want to find
     * @return List of request reports from Database.
     * @throws Exception provide information about database access error.
     */
    public Request getRequest(int id) throws Exception;

    /**
     * This method will update request from Database which matched with id.
     *
     * @param request request want to update
     * @throws Exception provide information about database access error.
     */
    public void updateRequest(Request request) throws Exception;
}
