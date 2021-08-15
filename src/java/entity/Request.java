/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package entity;

import java.sql.Date;

/**
 * This Class represent for Business object Request.<br>
 * The object has properties:<br>
 * <ul>
 * <li>id <code>int</code></li>
 * <li>department <code>entity.Department</code></li>
 * <li>student <code>entity.Student</code></li>
 * <li>dateCreated <code>java.sql.Date</code></li>
 * <li>title <code>java.lang.String</code></li>
 * <li>content <code>java.lang.String</code></li>
 * <li>state <code>int</code></li>
 * <li>closeDate <code>java.sql.Date</code></li>
 * <li>solvedBy <code>entity.Department</code></li>
 * <li>attachedURL <code>java.lang.String</code></li>
 * <li>solution <code>java.lang.String</code></li>
 * </ul>
 *
 * @author phuon
 */
public class Request {

    private int id;
    private Department department;
    private Student student;
    private Date dateCreated;
    private String title;
    private String content;
    private int state;
    private Date closeDate;
    private Account solvedBy;
    private String attachedURL;
    private String solution;

    public Request() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }

    public Account getSolvedBy() {
        return solvedBy;
    }

    public void setSolvedBy(Account solvedBy) {
        this.solvedBy = solvedBy;
    }

    public String getAttachedURL() {
        return attachedURL;
    }

    public void setAttachedURL(String attachedURL) {
        this.attachedURL = attachedURL;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

}
