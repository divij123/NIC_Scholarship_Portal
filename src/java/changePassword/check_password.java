/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changePassword;

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
public class check_password implements SessionAware{
    
    private Map<String, Object> sessionMap;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }
    
    public String check(String newpassword) throws SQLException{
        Connection conn = null;
        Connect con = new Connect();
      
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        
        PreparedStatement ps2 = null;
        ResultSet rs2 = null;
        
        PreparedStatement ps3 = null;
        ResultSet rs3 = null;
        
        
        try {
            conn = con.connectionLogin();
            
            int max_count = 0;
            
            ps3 = conn.prepareStatement("select max(serial_no) from changepassword_log");
            rs3 = ps3.executeQuery();
            
            while (rs3.next()) {
                max_count = rs3.getInt(1);
            }
            
            if (max_count >= 3) {

                ps = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = (select max(serial_no) from changepassword_log)");
                ps.setString(1, newpassword);
                rs = ps.executeQuery();
                String lastpassword = null;
                while (rs.next()) {
                    lastpassword = rs.getString("lastpassword");
                }

                if (!lastpassword.equals(newpassword)) {
                    
                    return "error";
                    
                }

                ps1 = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = (select max(serial_no)-1 from changepassword_log)");
                ps1.setString(1, newpassword);
                rs1 = ps.executeQuery();
                String lastpassword1 = null;
                while (rs.next()) {
                    lastpassword1 = rs.getString("lastpassword");
                }

                if (!lastpassword1.equals(newpassword)) {
                    return "error";
                    
                }

                ps2 = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = (select max(serial_no)-2 from changepassword_log)");
                ps2.setString(1, newpassword);
                rs2 = ps.executeQuery();
                String lastpassword2 = null;
                while (rs.next()) {
                    lastpassword2 = rs.getString("lastpassword");
                }

                if (!lastpassword2.equals(newpassword)) {
                    return "error";
                    
                }

            } else if(max_count == 2) {
                
                 ps = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = 2");
                ps.setString(1, newpassword);
                rs = ps.executeQuery();
                String lastpassword = null;
                while (rs.next()) {
                    lastpassword = rs.getString("lastpassword");
                }

                if (lastpassword.equals(newpassword)) {
                    return "error";
                    
                }

                ps1 = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = 1");
                ps1.setString(1, newpassword);
                rs1 = ps.executeQuery();
                String lastpassword1 = null;
                while (rs.next()) {
                    lastpassword1 = rs.getString("lastpassword");
                }

                if (lastpassword1.equals(newpassword)) {
                    return "error";
                    
                }
                
            } else {
                 ps = conn.prepareStatement("select lastpassword from changepassword_log where newpassword = ? and serial_no = 1");
                ps.setString(1, newpassword);
                rs = ps.executeQuery();
                String lastpassword = null;
                while (rs.next()) {
                    lastpassword = rs.getString("lastpassword");
                }

                if (lastpassword.equals(newpassword)) {
                    return "error";
                    
                }

            }

                        
            
            
        } catch (SQLException ex) {
            System.out.print("Error : " + ex);
        }
         
                
        return "success";
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

    
}
