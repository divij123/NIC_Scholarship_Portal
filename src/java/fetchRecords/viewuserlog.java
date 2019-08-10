/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fetchRecords;

import connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DIVIJ
 */
public class viewuserlog {
    
    ArrayList<loginUser> list = new ArrayList<>();
    
    public ArrayList<loginUser>getList() {
        return list;
    }
    
    public void setList(ArrayList<loginUser> list) {
        this.list = list;
    }
    
    public String execute() throws SQLException {
       
            Connection conn = null;
            Connect con = new Connect();
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
       try {
           conn = con.connectionLogin();
           
           ps = conn.prepareStatement("select username,userid,timestamp,ipaddress,usertype from user_log");
           rs = ps.executeQuery();
           
           while (rs.next()) {
               
               loginUser user1 = new loginUser();
           
               user1.setUsername(rs.getString(1));
               user1.setUserid(rs.getString(2));
               user1.setTimestamp(rs.getString(3));
               user1.setIpaddress(rs.getString(4));
               user1.setUsertype(rs.getInt(5));
               list.add(user1);
            
           }
           
          }catch(SQLException ex){
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
}
