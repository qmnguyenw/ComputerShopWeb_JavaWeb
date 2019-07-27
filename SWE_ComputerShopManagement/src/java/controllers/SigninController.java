/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import DAO.AccountDAO;
import manage.AccountManagement;
import context.DBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
public class SigninController extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //TODO: kiem tra da authenticated hay chua
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(username != null)
        {
            response.sendRedirect("home");
            return;
        }
        
        String path = "/WEB-INF/signin.jsp";        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //TODO: kiem tra da authenticated hay chua
        HttpSession session = request.getSession();
        String username2 = (String)session.getAttribute("username");
        if(username2 != null)
        {
            response.sendRedirect("home");
            return;
        }
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = null;
        String errorMessage = null;
        if(username == null || username.trim().equals("") 
                || password == null || password.trim().equals(""))
        {
            errorMessage = "username and password must not be empty";
        }
        else
        {
//            String defaultPassword = getServletConfig().getInitParameter("Password");
//
//            if(!password.equals(defaultPassword))
//            {
//                errorMessage = "Password is wrong";
//            }
            
            DBContext dbContext = new DBContext();
            AccountDAO accountDAO;
            
            try {
                accountDAO = new AccountDAO(dbContext);
                
                AccountManagement accountManagement = new AccountManagement(accountDAO);
                
                int result = accountManagement.checkAccount(username, password);
                if (result == 0) {
                    errorMessage = "Username invalid";
                }else if (result == 1) {
                    errorMessage = "Password is wrong";
                }
                role = accountManagement.getRoleAccount(username);
            } catch (Exception ex) {
                errorMessage = ex.getMessage();
            }
        }
        
        if(errorMessage != null)
        {
            request.setAttribute("errorMessage", errorMessage);
            //request.setAttribute("username", username);
            
            String path = "/WEB-INF/signin.jsp";
            RequestDispatcher dispatcher = 
                    getServletContext()
                    .getRequestDispatcher(path);
            dispatcher.forward(request, response);
            return;
        }
        
        //HttpSession session = request.getSession();
        session.setAttribute("role", role.trim());
        session.setAttribute("username", username);
        response.sendRedirect("home");
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
