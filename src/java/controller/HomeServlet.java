/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-03      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.RequestReportDAO;
import entity.RequestReport;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class get information from Database through DAO Layer.<br>
 * This class extends BaseRequireLoginServlet<br>
 * This class supplies method to display Home page.<br>
 *
 * @author phuon
 */
public class HomeServlet extends BaseRequireLoginServlet {

    /**
     * Display home page with recent requests reports
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // check & add today date to session
            if (request.getSession().getAttribute("today") == null) {
                Date today = new Date(Calendar.getInstance().getTimeInMillis());
                request.getSession().setAttribute("today", today);
            }

            RequestReportDAO reportDAO = new RequestReportDAO();
            List<RequestReport> reportsToday = reportDAO.getRequestReportRecentDays(0);
            List<RequestReport> reportsLast2Days = reportDAO.getRequestReportRecentDays(2);
            request.setAttribute("reportsToday", reportsToday);
            request.setAttribute("reportsLast2Days", reportsLast2Days);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Home page not found.");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
