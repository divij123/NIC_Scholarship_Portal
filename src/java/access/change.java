/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DIVIJ
 */
public class change {
    
    public String validate(String username,String userid,boolean report,boolean create,boolean update,boolean isdelete) {
        
        
            Connection conn = null;
            Connect con = new Connect();
            PreparedStatement ps = null;
            PreparedStatement ps1 = null;
            PreparedStatement ps2 = null;
            ResultSet rs2 = null;
            
            
            try {
                
                conn = con.connectionLogin();

                ps2 = conn.prepareStatement("select * from grant_access where username=?");
                ps2.setString(1, username);
                rs2 = ps2.executeQuery();
               
                if (!rs2.next()) {
                    ps1 = conn.prepareStatement("insert into grant_access (username,userid,isreport,iscreate,isupdate,isdelete) values (?,?,?,?,?,?)");
                    ps1.setString(1, username);
                    ps1.setString(2, userid);
                    ps1.setBoolean(3, report);
                    ps1.setBoolean(4, create);
                    ps1.setBoolean(5, update);
                    ps1.setBoolean(6, isdelete);
                    ps1.executeUpdate();

                } else {
                    ps = conn.prepareStatement("update grant_access set isreport=?,iscreate=?,isupdate=?,isdelete=? where username=?");
                    ps.setBoolean(1, report);
                    ps.setBoolean(2, create);
                    ps.setBoolean(3, update);
                    ps.setBoolean(4, isdelete);
                    ps.setString(5, username);
                    ps.executeUpdate();
                }
                
            } catch(SQLException ex){
                System.out.print("Error : " + ex);
            }
            
            return "success";
            
        }
        
    }
    