/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-01      1.0              PhuongNVHE140784      Initial commit
 */
package dao;

import entity.Account;

/**
 * This interface contain methods about Account<br>
 * <code>java.lang.Exception</code> throws when error occurs
 *
 * @author phuon
 */
public interface IAccountDAO {

    /**
     * This method return an account from Database<br>
     * which is matched with username & password.
     *
     * @param username
     * @param password
     * @return account from Database.
     * @throws Exception provide information about database access error.
     */
    public Account getAccount(String username, String password) throws Exception;
}
