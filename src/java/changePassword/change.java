/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package changePassword;

import connection.Connect;
import example.securepassword;
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
public class change implements SessionAware {

    private Map<String, Object> sessionMap;

    public Map<String, Object> getSessionMap() {
        return sessionMap;
    }

    private String username, curpass, newpass, cpass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCurpass() {
        return curpass;
    }

    public void setCurpass(String curpass) {
        this.curpass = curpass;
    }

    public String getNewpass() {
        return newpass;
    }

    public void setNewpass(String newpass) {
        this.newpass = newpass;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public String execute() throws SQLException {
        Connection conn = null;
        Connect con = new Connect();
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;

        try {
            conn = con.connectionLogin();
            
            check_password check_pass = new check_password();
            
            if (cpass.equals(newpass)) {
                
                securepassword sp = new securepassword();
                String newpassword = sp.hashpassword(newpass);
                String curpassword = sp.hashpassword(curpass);
                
                
                int usertype = (int) sessionMap.get("usertype");
                String userid = (String) sessionMap.get("userid");

                if (usertype <= 4) {
                    ps = conn.prepareStatement("update state_user set password = ? where username = ?");
                    ps.setString(1, newpassword);
                    ps.setString(2, username);
                    ps.executeUpdate();

                    ps1 = conn.prepareStatement("select serial_no from changepassword_log where username = ?");
                    ps1.setString(1, username);
                    rs1 = ps1.executeQuery();
                    int count = 0;

                    PreparedStatement ps2 = null;
                    
                    while (rs1.next()) {
                        count = rs1.getInt("serial_no");
                    }


                    if (!rs1.next() && count==0) {
                        count = 1;
                        ps2 = conn.prepareStatement("insert into changepassword_log (username , userid , lastpassword ,newpassword ,serial_no , timestamp) values (?,?,?,?,1,current_timestamp)");
                        ps2.setString(1, username);
                        ps2.setString(2, userid);
                        ps2.setString(3, curpassword);
                        ps2.setString(4, newpassword);
                        ps2.executeUpdate();
                    } else {
                        int serial = count + 1;
                        ps2 = conn.prepareStatement("insert into changepassword_log (username , userid , lastpassword ,newpassword ,serial_no , timestamp) values (?,?,?,?,?,current_timestamp)");
                        ps2.setString(1, username);
                        ps2.setString(2, userid);
                        ps2.setString(3, curpassword);
                        ps2.setString(4, newpassword);
                        ps2.setInt(5, serial);
                        ps2.executeUpdate();

                    }

                } else {
                    ps = conn.prepareStatement("update district_user set password = ? where username = ?");
                    ps.setString(1, newpassword);
                    ps.setString(2, username);
                    ps.executeUpdate();

                    ps1 = conn.prepareStatement("select serial_no from changepassword_log where username = ?");
                    ps1.setString(1, username);
                    rs1 = ps1.executeQuery();
                    int count = 0;
                    
                    
                    while (rs1.next()) {
                        count = rs1.getInt("serial_no");
                    }

                    
                    PreparedStatement ps2 = null;

                    if (!rs1.next() && count == 0) {
                        count = 1;
                        ps2 = conn.prepareStatement("insert into changepassword_log (username , userid , lastpassword ,newpassword ,serial_no , timestamp) values (?,?,?,?,1,current_timestamp)");
                        ps2.setString(1, username);
                        ps2.setString(2, userid);
                        ps2.setString(3, curpassword);
                        ps2.setString(4, newpassword);
                        ps2.executeUpdate();
                    } else {

                        int serial = count + 1;
                        ps2 = conn.prepareStatement("insert into changepassword_log (username , userid , lastpassword ,newpassword ,serial_no , timestamp) values (?,?,?,?,?,current_timestamp)");
                        ps2.setString(1, username);
                        ps2.setString(2, userid);
                        ps2.setString(3, curpassword);
                        ps2.setString(4, newpassword);
                        ps2.setInt(5, serial);
                        ps2.executeUpdate();

                    }

                }

            } else {
                return "error";
            }

        } catch (SQLException ex) {
            System.out.println("Error = " + ex.toString());
        } finally {
            if (ps != null || ps1!= null) {
                ps.close();
                ps1.close();

            }
            if (conn != null) {
                conn.close();
            }
        }

        return "success";

    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.sessionMap = map;
    }

}
