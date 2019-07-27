/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;

/**
 *
 * @author MSI
 */
public class MyException extends Exception{
    int code;
    String message;
    
    public MyException(Exception e) {
        if(e instanceof SQLException) code = 0;
        else if (e instanceof ServletException) code = 1;
        else if (e instanceof NumberFormatException) code = 2;
        else if (e instanceof IOException) code = 3;
        else if (e instanceof NullPointerException) code = 4;
        else if (e instanceof MyException) code = ((MyException) e).getCode();
        else code = 5;
        if(code != 4) message = e.getMessage();
        else message = "NullPointerException";
    }

    public MyException(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
    
}
