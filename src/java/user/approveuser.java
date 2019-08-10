/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.sql.SQLException;

/**
 *
 * @author DIVIJ
 */
public class approveuser{
    
    private String username;
    private int usertype;

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String execute() throws SQLException, Exception {
        
        changestatus status = new changestatus();
        
        if("success".equals(status.change(username,usertype))) {
            return "success";
        }
        else {
            return "error";
        }
        
        
        
    }
             
}
