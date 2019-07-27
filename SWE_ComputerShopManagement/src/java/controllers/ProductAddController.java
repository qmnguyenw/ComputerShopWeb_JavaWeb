/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exception.MyException;
import DAO.ProductDAO;
import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import manage.ProductManagement;

/**
 *
 * @author Quang Nguyen
 */
@WebServlet(name = "ProductAddController", urlPatterns = {"/productadd"})
public class ProductAddController extends HttpServlet {

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
        List<Category> listCategories = null;
        try {
            ProductManagement productManagement = new ProductManagement(new ProductDAO());
            listCategories = productManagement.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        request.setAttribute("listCategories", listCategories);
        RequestDispatcher dis = getServletContext()
                .getRequestDispatcher("/WEB-INF/productadd.jsp");
        dis.forward(request, response);
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
        try {
            ProductManagement productManagement = new ProductManagement(new ProductDAO());
            String idStr = request.getParameter("id").trim();         
            String name = request.getParameter("name").trim();
            String categoryIDStr = request.getParameter("categoryID").trim();
            String priceStr = request.getParameter("price").trim();
            String quantityStr = request.getParameter("quantity").trim();
            String describe = request.getParameter("describe").trim();
            String addDate = request.getParameter("addDate").trim();
            int id = 0, categoryID = 0, quantity = 0;
            double price = 0;
            String idLabel = null, nameLabel = null, categoryIDLabel = null,
                    priceLabel = null, quantityLabel = null, describeLabel = null, addDateLabel = null;            
            //server error
            if (idStr == null || name == null || categoryIDStr == null 
                    || priceStr == null || quantityStr == null || describe == null || addDate == null) {
                doGet(request, response);
                return;
            }
            //check id
            if (idStr.isEmpty()) {
                idLabel = "ID field cannot be empty";
            } else {
                try {
                    id = Integer.parseInt(idStr);
                    if (productManagement.checkDuplicateProductID(id)) {
                        idLabel = "This ID has existed";
                    }
                }catch (NumberFormatException ex) {
                    idLabel = "ID field is incorrect format";
                }
            }
            //check name
            if (name.isEmpty()) {
                nameLabel = "Name cannot be empty";
            }
            //check categoryID
            if (categoryIDStr.isEmpty()) {
                categoryIDLabel = "CategoryID field cannot be empty";
            }else {
                try {
                    categoryID = Integer.parseInt(categoryIDStr);
                    if (!productManagement.checkCategory(categoryID)) {
                        categoryIDLabel = "CategoryID is not existed";
                    }
                }catch (NumberFormatException ex) {
                    categoryIDLabel = "CategoryID field is incorrect format";
                }
            }
            //check price
            if (priceStr.isEmpty()) {
                priceLabel = "Price field cannot be empty";
            } else {
                try {
                    price = Double.parseDouble(priceStr);
                    if (price <= 0) {
                        priceLabel = "Price field is must greater than 0";
                    }
                }catch (NumberFormatException ex) {
                    priceLabel = "Price field is incorrect format";
                }
            }
            //check quantity
            if (quantityStr.isEmpty()) {
                quantityLabel = "Quantity field cannot be empty";
            } else {
                try {
                    quantity = Integer.parseInt(quantityStr);
                }catch (NumberFormatException ex) {
                    quantityLabel = "Quantity field is incorrect format";
                }
            }
            //check describe
            if (describe.isEmpty()) {
                describeLabel = "Describe field is empty";
            }
            //check addDate
            if (addDate.isEmpty()) {
                addDateLabel = "Add Date field cannot be empty";
            }
            //if there is error
            if (idLabel != null || nameLabel != null || categoryIDLabel != null
                    || priceLabel != null || quantityLabel != null) {
                request.setAttribute("idLabel", idLabel);
                request.setAttribute("nameLabel", nameLabel);
                request.setAttribute("categoryIDLabel", categoryIDLabel);
                request.setAttribute("priceLabel", priceLabel);
                request.setAttribute("quantityLabel", quantityLabel);
                request.setAttribute("describeLabel", describeLabel);
                request.setAttribute("addDateLabel", addDateLabel);
                request.setAttribute("id", idStr);
                request.setAttribute("name", name);
                request.setAttribute("categoryID", categoryIDStr);
                request.setAttribute("price", priceStr);
                request.setAttribute("quantity", quantityStr);
                request.setAttribute("describe", describe);
                request.setAttribute("addDate", addDate);
                doGet(request, response);
                return;
            //not error
            } else {
                productManagement.addProduct(id, name, categoryID, price, quantity, describe, addDate);
                response.sendRedirect("productlist");
            }

        } catch (Exception e) {
            e.printStackTrace();
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
