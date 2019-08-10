/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

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
public class changestatus implements SessionAware{
    
    private Map<String, Object> sessionMap;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
      
    public String change(String username , int usertype) throws SQLException{

        Connection conn = null;
        Connect con = new Connect();
        PreparedStatement ps = null;
        ResultSet rs = null ;
        
        try{
        conn = con.connectionLogin();
       
        if(usertype==2 || usertype==3 || usertype==4) {
            
                ps = conn.prepareStatement("update state_user set isapproved=true where  username=?");
                ps.setString(1, username);
                ps.executeUpdate();
                conn.commit();
            }
            
        else {
                ps = conn.prepareStatement("update district_user set isapproved=true where  username=?");
                ps.setString(1, username);
                ps.executeUpdate();
                conn.commit();
            }
                       
        }
        
    catch(SQLException ex){
            System.out.println("ex = " + ex.toString());
        }
        
        finally{
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

