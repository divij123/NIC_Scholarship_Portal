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
import java.util.ArrayList;

/**
 *
 * @author DIVIJ
 */
public class grant {
    
    ArrayList<grantuser> list = new ArrayList<>();
    
    ArrayList<grantboolean> list1 = new ArrayList<>();

    public ArrayList<grantboolean> getList1() {
        return list1;
    }

    public void setList1(ArrayList<grantboolean> list1) {
        this.list1 = list1;
    }

    
    public ArrayList<grantuser>getList() {
        return list;
    }
    
    public void setList(ArrayList<grantuser> list) {
        this.list = list;
    }
    
    public String execute() throws SQLException {
       
            Connection conn = null;
            Connect con = new Connect();
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            
            PreparedStatement ps1 = null;
            ResultSet rs1 = null;
       try {
           conn = con.connectionLogin();
           
           ps = conn.prepareStatement("select s.username,s.userid,s.usertype,g.isreport,g.iscreate,g.isupdate,g.isdelete from state_user s, grant_access g where s.username = g.username");
           rs = ps.executeQuery();
           String user = null;
           while (rs.next()) {
               
               grantuser user1 = new grantuser();
               user = rs.getString(1);
               user1.setUsername(rs.getString(1));
               user1.setUserid(rs.getString(2));
               user1.setUsertype(rs.getInt(3));
               user1.setIsreport(rs.getBoolean(4));
               user1.setIscreate(rs.getBoolean(5));
               user1.setIsupdate(rs.getBoolean(6));
               user1.setIsdelete(rs.getBoolean(7));
               list.add(user1);
            
           }
           
//           ps1 = conn.prepareStatement("select userid,isreport,iscreate,isupdate,isdelete from grant_access where username=?");
//           ps1.setString(1,user);
//           rs1 = ps1.executeQuery();
//           
//           while (rs1.next()) {
//               
//               grantboolean user2 = new grantboolean();               
//               user2.setUserid(rs1.getString(1));
//               user2.setIsreport(rs1.getBoolean(2));
//               user2.setIscreate(rs1.getBoolean(3));
//               user2.setIsupdate(rs1.getBoolean(4));
//               user2.setIsdelete(rs1.getBoolean(5));
//               list1.add(user2);
//           }
           
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
