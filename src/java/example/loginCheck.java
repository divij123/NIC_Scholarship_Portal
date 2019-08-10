/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import com.opensymphony.xwork2.ActionSupport;
import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author DIVIJ
 */

public class loginCheck extends ActionSupport implements SessionAware{
    
    private Map<String, Object> sessionMap;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
    
    public String validate(String username, String userpass) throws SQLException, Exception {
        
        Connection conn = null;
        Connect con = new Connect();
            
        PreparedStatement ps = null;
        ResultSet rs = null ;
        
        String userid = null;
        int usertype = 0;
        boolean isapproved = false;
        
        
        try{
        
        conn = con.connectionLogin();
        
        ps = conn.prepareStatement("select password from state_user where username = ?");
        ps.setString(1, username);
        rs = ps.executeQuery();
        String hashed = null;
        
        while(rs.next()) {
            hashed = rs.getString("password");
        }
        
        securepassword p1 = new securepassword();
        
        boolean check = p1.checkpassword(userpass,hashed);
        
        if(!check) {
            return "incorrect";
        }

        }catch(SQLException ex){
        
        }finally{
            if (ps!=null) {
                ps.close(); 
            }
            if (rs!=null) {
                rs.close();
            }
            if (conn!=null) {
                conn.close();
            }           
        }                
        return "success";           
    }

    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
}