/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import com.opensymphony.xwork2.ActionSupport;
import connection.Connect;
import example.loginCheck;
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
public class login  extends ActionSupport implements SessionAware{
    private String username , userpass ;
    private Map<String, Object> sessionMap;
        
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }
    
    public void check() {
        if (getUsername().length() == 0) {
            addFieldError("username", "User Name is required");
        } else if (!getUsername().equals("Eswar")) {
            addFieldError("username", "Invalid User");
        }
        if (getUserpass().length() == 0) {
            addFieldError("password", getText("password.required"));
        }    
    }
    
    public String execute() throws SQLException, Exception {

        loginCheck login = new loginCheck();
        
        if ("success".equals(login.validate(username,userpass)))
        {
            Connection conn = null;
            Connect con = new Connect();
            PreparedStatement ps = null;
            PreparedStatement ps1 = null;
            ResultSet rs1 = null;
            String userid = null;
            int usertype = 1;
            boolean isapproved = false;
            String ipaddress = "192.168.1.1";
            try {
                conn = con.connectionLogin();
                
                ps1 = conn.prepareStatement("select usertype,userid,isapproved from state_user where username = ?");
                ps1.setString(1,username);
                rs1 = ps1.executeQuery();
                
                while (rs1.next()) {
                    usertype = rs1.getInt("usertype");
                    userid = rs1.getString("userid");
                    isapproved = rs1.getBoolean("isapproved");
                }

                sessionMap.put("username", username);
                sessionMap.put("usertype", usertype);
                sessionMap.put("userid", userid);
                sessionMap.put("isapproved", isapproved);
                
                ps = conn.prepareStatement("insert into user_log (username,userid,ipaddress,usertype,timestamp) values (?,?,?,?,current_timestamp)");
                ps.setString(1, username);
                ps.setString(2, userid);
                ps.setString(3, ipaddress);
                ps.setInt(4, usertype);
                ps.executeUpdate();
                
            } catch(SQLException ex){
                System.out.print("Error : " + ex);
            }
            
            return "success";
            
        }
        else {
            return "error";
        }
    }
    
     public String logout() {
        if (sessionMap.containsKey("username")) {
            sessionMap.remove("username");
            sessionMap.remove("userid");
            sessionMap.remove("usertype");
            sessionMap.remove("isapproved");
            sessionMap.clear();
        }
        
        return "success";
    }
 
    @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
  }