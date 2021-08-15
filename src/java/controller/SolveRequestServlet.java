/*
    * Copyright(C) 2021,  FPT University
    * J3.L.P0010 Student Request System - admin site
    * Record of change:
    * DATE            Version          AUTHOR                DESCRIPTION
    * 2021-07-12      1.0              PhuongNVHE140784      Initial commit
 */
package controller;

import dao.impl.RequestDAO;
import entity.Account;
import entity.Request;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The class supplies all timetables use for display Solve request page<br>
 * This class get information from Database through DAO Layer.<br>
 * This class extends BaseRequireLoginServlet<br>
 *
 * @author phuon
 */
public class SolveRequestServlet extends BaseRequireLoginServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Display solve request page
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
            String requestIDStr = request.getParameter("id");
            if (requestIDStr == null) { // access direct by nav-pane ~> view-request
                response.sendRedirect("view-request");
            } else { // access from view-request page
                int rid = Integer.parseInt(requestIDStr);
                RequestDAO requestDAO = new RequestDAO();
                Request rq = requestDAO.getRequest(rid);
                request.setAttribute("rq", rq);
                request.getRequestDispatcher("solve-request.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("error", "Page Not Found");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    /**
     * Save request to database & reload page.
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
            int id = Integer.parseInt(request.getParameter("request-id"));
            int state = Integer.parseInt(request.getParameter("state"));
            Date closeDate = new Date(Calendar.getInstance().getTimeInMillis());
            Account solvedBy = (Account) request.getSession().getAttribute("account");
            String solution = request.getParameter("solution").trim();

            Request rq = new Request();
            rq.setId(id);
            rq.setState(state);
            rq.setCloseDate(closeDate);
            rq.setSolvedBy(solvedBy);
            rq.setSolution(solution);

            RequestDAO requestDAO = new RequestDAO();
            requestDAO.updateRequest(rq);
            response.sendRedirect(request.getContextPath() + "/solve-request?id=" + id);
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
