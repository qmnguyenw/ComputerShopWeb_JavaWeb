/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import DAO.ProductDAO;
import entity.Category;
import entity.Product;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Quang Nguyen
 */
public class ProductManagement {
    
    ProductDAO productDAO;

    public ProductManagement(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    
    public boolean checkDuplicateProductID(int productID) throws Exception{
        //product have exist => duplicate
        if(productDAO.getProductByID(productID)==null) return false;
        //pass
        return true;
    }
    
    public boolean checkCategory(int ID) throws Exception {
        if (productDAO.getCategoryByID(ID) == null) {
            return false;
        }
        return true;
    }
    
    public List<Product> getAllProducts() throws Exception {
        return productDAO.getAllProducts();
    }
    
    public void deleteProduct(int ID) throws Exception {
        productDAO.removeProduct(ID);
    }
    
    public Product getProductByID(int ID) throws Exception {
        return productDAO.getProductByID(ID);
    }
    
    public Category getCategoriesByProductID(int ID) throws Exception {
        return productDAO.getCategoryByProductID(ID);
    }
    
    public void addProduct(int ID, String Name, int CategoryID, double Price, 
            int Quantity, String Describe, String addDate) throws Exception {
        productDAO.addProduct(ID, Name, CategoryID, Price, Quantity,Describe, addDate);
    }
    
    public void updateProduct(int ID, String Name, int CategoryID, double Price, 
            int Quantity, String Describe, String addDate) throws Exception {
        productDAO.updateProduct(ID, Name, CategoryID, Price, Quantity,Describe, addDate);
    }
    
    public List<Category> getAllCategories() throws Exception {
        return productDAO.getAllCategories();
    }
}
