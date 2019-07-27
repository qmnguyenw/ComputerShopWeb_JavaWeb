/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manage;

import DAO.AccountDAO;
import entity.Account;

/**
 *
 * @author Quang Nguyen
 */
public class AccountManagement {
    AccountDAO accountDAO;

    public AccountManagement(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }
    
    public int checkAccount(String username, String password) throws Exception {
        Account account = this.accountDAO.getAccountByUsername(username);
        if (account == null) {
            return 0;//account ko ton tai
        }else {
            if (!account.getPassword().trim().equals(password)) {
                System.out.println(account.getPassword());
                System.out.println(password);
                return 1;//password sai
            }else {
                System.out.println(account.getPassword());
                return 2;//password dung - username va password hop le
            }
        }
    }
    
    public String getRoleAccount(String username) throws Exception {
        Account account = this.accountDAO.getAccountByUsername(username);
        String role = account.getRole();
        return role;
    }
}
