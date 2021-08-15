/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-04      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import entity.Department;
import java.util.List;

/**
 * This interface contain methods about Department<br>
 * <code>java.lang.Exception</code> throws when error occurs
 *
 * @author phuon
 */
public interface IDepartmentDAO {

    /**
     * This method return all departments available from Database.
     *
     * @return List of departments from Database.
     * @throws Exception provide information about database access error.
     */
    public List<Department> getDepartments() throws Exception;
}
