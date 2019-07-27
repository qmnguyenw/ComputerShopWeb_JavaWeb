/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import exception.MyException;
import DAO.ProductDAO;
import entity.Category;
import entity.Product;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "ProductEditController", urlPatterns = {"/productedit"})
public class ProductEditController extends HttpServlet {

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
        doGetNoIdParameter(request, response, null);
        
    }
    
    protected void doGetNoIdParameter(HttpServletRequest request, HttpServletResponse response,
            Integer haveId)
            throws ServletException, IOException {
        Product product = null;
        List<Category> listCategories = null;
        try {
            int id;
            if(haveId==null) {
                id = Integer.parseInt(request.getParameter("id"));
            }else {
                id = haveId;
            }
            
            ProductManagement productManagement = new ProductManagement(new ProductDAO());
            product = productManagement.getProductByID(id);
//            if (product == null) {
//                throw new MyException("Product is not existed", 404);
//            }
            listCategories = productManagement.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
//            MyException ex = new MyException(e);
//            request.setAttribute("myEx", ex);
//            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/exception.jsp");
//            dispatcher.forward(request, response);
            return;
        }
        request.setAttribute("product", product);
        request.setAttribute("listCategories", listCategories);
        RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/WEB-INF/productedit.jsp");
        dispatch.forward(request, response);
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
        List<Category> listCategories = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try{
            String name = request.getParameter("name").trim();
            String categoryIDStr = request.getParameter("categoryID").trim();
            String priceStr = request.getParameter("price").trim();
            String quantityStr = request.getParameter("quantity").trim();
            String describe = request.getParameter("describe").trim();
            String addDate = request.getParameter("addDate").trim();
            Integer categoryID = null;
            Double price = null;
            Integer quantity = null;
            String idLabel = null, nameLabel = null, categoryIDLabel = null,
                    priceLabel = null, quantityLabel = null, describeLabel = null, addDateLabel = null;
            if (name == null || categoryIDStr == null 
                    || priceStr == null || quantityStr == null || describe == null || addDate == null) {
                doGet(request, response);
                return;
            }
            ProductManagement productManagement = new ProductManagement(new ProductDAO());
            //verify name
            if (name.isEmpty()) {
                nameLabel = "Name cannot be empty";
            }
            //verify categoryID
            if (categoryIDStr.isEmpty()) {
                categoryIDLabel = "CategoryID field cannot be empty";
            } else {
                try {
                    categoryID = Integer.parseInt(categoryIDStr);
                    if (!productManagement.checkCategory(categoryID)) {
                        categoryIDLabel = "CategoryID is not existed";
                    }
                }catch (NumberFormatException ex) {
                    categoryIDLabel = "CategoryID field is incorrect format";
                }
            }       
            //verify price
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
            //verify quantity
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
            if (nameLabel != null || categoryIDLabel != null
                    || priceLabel != null || quantityLabel != null) {
                request.setAttribute("nameLabel", nameLabel);
                request.setAttribute("categoryIDLabel", categoryIDLabel);
                request.setAttribute("priceLabel", priceLabel);
                request.setAttribute("quantityLabel", quantityLabel);
                request.setAttribute("describeLabel", describeLabel);
                request.setAttribute("addDateLabel", addDateLabel);
                productManagement = new ProductManagement(new ProductDAO());
                listCategories = productManagement.getAllCategories();
                request.setAttribute("listCategories", listCategories);                
                RequestDispatcher dispatch = getServletContext().getRequestDispatcher("/WEB-INF/productedit.jsp");
                dispatch.forward(request, response);
                return;
            //not error
            } else {
                productManagement.updateProduct(id, name, categoryID, price, quantity, describe, addDate);
                response.sendRedirect("productlist");
            }
        }catch(Exception e){
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
