/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author DIVIJ
 */
public class loginAll {
 public String validate(String username, String userpass) throws SQLException {
        
        Connection conn = null;
        Connect con = new Connect();
        PreparedStatement ps = null;
        try{
        
        conn = con.connectionLogin();
        
        ps = conn.prepareStatement("insert into login_all (username,password,success) values(?,?,0)");
        ps.setString(1, username);
        ps.setString(2, userpass);
        ps.executeUpdate();
        
        }catch(Exception ex){
        
        }finally{
            if (ps!=null) {
                ps.close();
            }
            if (conn!=null) {
                conn.close();
            }
            
        }
                
        return "success";
        
    }
    
}
