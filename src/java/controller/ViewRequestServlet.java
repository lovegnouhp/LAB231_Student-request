/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-04      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.DepartmentDAO;
import dao.impl.RequestDAO;
import entity.Department;
import entity.Request;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class supplies all timetables use for display View request page<br>
 * This class get information from Database through DAO Layer.<br>
 * This class extends BaseRequireLoginServlet<br>
 *
 * @author phuon
 */
public class ViewRequestServlet extends BaseRequireLoginServlet {

    /**
     * get default data to load view-request page
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void getDefaultData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            DepartmentDAO departmentDAO = new DepartmentDAO();
            List<Department> departments = departmentDAO.getDepartments();
            request.setAttribute("selectedDepID", -1);
            request.setAttribute("searchedTitle", "");
            request.setAttribute("departments", departments);
        } catch (Exception e) {
            request.setAttribute("error", "Page Not Found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Display view request page
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
            getDefaultData(request, response);

            RequestDAO requestDAO = new RequestDAO();
            List<Request> requests = null;
            String date = request.getParameter("date");

            if (date != null) { // access from home page links
                String depID = request.getParameter("department-id");
                Department department = new Department();
                department.setId(Integer.parseInt(depID));
                // date = today: get last 0 day; date = last2day get last 2 days
                int numberOfDays = date.equals("today") ? 0 : 2;
                requests = requestDAO.getRequestsRecentDays(department, numberOfDays);
            }
            request.setAttribute("requests", requests);
            request.getRequestDispatcher("view-request.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Page Not Found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Display request table by user's search.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            getDefaultData(request, response);
            String formName = request.getParameter("form-name");

            RequestDAO requestDAO = new RequestDAO();
            List<Request> requests;
            // change department selection
            if (formName.equals("search_department")) {
                int departmentID = Integer.parseInt(request.getParameter("department-id"));
                Department d = new Department();
                d.setId(departmentID);
                requests = requestDAO.getRequests(d);
                request.setAttribute("selectedDepID", departmentID);
            } else { // search by title
                String title = request.getParameter("txt-title").trim();
                requests = requestDAO.getRequests(title);
                request.setAttribute("searchedTitle", title);
            }
            request.setAttribute("requests", requests);
            request.getRequestDispatcher("view-request.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Page Not Found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
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
