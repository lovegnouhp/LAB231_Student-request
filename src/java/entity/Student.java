/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package entity;

/**
 * This Class represent for Business object Student. <br>
 * The object has properties:<br>
 * <ul>
 * <li>id <code>int</code> </li>
 * <li>name <code>java.lang.String</code></li>
 * </ul>
 *
 * @author phuon
 */
public class Student {

    private String id;
    private String name;

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
