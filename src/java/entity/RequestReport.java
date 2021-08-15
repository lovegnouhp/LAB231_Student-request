/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package entity;

/**
 * This Class represent for Business object RequestReport. <br>
 * The object has properties:<br>
 * <ul>
 * <li>department <code>entity.Department</code> </li>
 * <li>numberOfRequest <code>int</code></li>
 * </ul>
 *
 * @author phuon
 */
public class RequestReport {

    private Department department;
    private int numberOfRequest;

    public RequestReport() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumberOfRequest() {
        return numberOfRequest;
    }

    public void setNumberOfRequest(int numberOfRequest) {
        this.numberOfRequest = numberOfRequest;
    }
}
