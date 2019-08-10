/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DIVIJ
 */
public class firstlogin {
    
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    
    public String execute() throws SQLException {
        Connection conn = null ;
        Connect con =  new Connect();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            conn = con.connectionLogin();
           
                ps = conn.prepareStatement("select * from login_all where username = ?");
                ps.setString(1, username);
                
                rs = ps.executeQuery();
                
                if(!rs.next()) {
                    return "error";
                }
                
            
        } catch(SQLException ex) {
            System.out.println("Error = " + ex.toString());
        }
        finally{
             if (ps!=null) {
                ps.close();
            }
            if(rs!=null) {
                rs.close();
            }
            
            if (conn!=null) {
                conn.close();
            }
        }
        
        return "success";             
        
    }
    
}
