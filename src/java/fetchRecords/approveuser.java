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
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author DIVIJ
 */
public class approveuser implements SessionAware{
    
    ArrayList<userapprove> list = new ArrayList<>();
    private Map<String, Object> sessionMap;
    private int usertype;
    
    public ArrayList<userapprove>getList() {
        return list;
    }
    
    public void setList(ArrayList<userapprove> list) {
        this.list = list;
    }
    
     @Override
    public void setSession(Map<String, Object> sessionMap) {
        this.sessionMap = sessionMap;
    }
    
    public String execute() throws SQLException {
       
            Connection conn = null;
            Connect con = new Connect();
            
            PreparedStatement ps = null;
            ResultSet rs = null;
   
            if (sessionMap.get("usertype") != null) {
                usertype = (int)sessionMap.get("usertype");
            }
            
       try {
           conn = con.connectionLogin();
         
           
           if (usertype==2 || usertype==4 || usertype==1) {
               
               ps = conn.prepareStatement("select username,dob,usertype,userid,statename from state_user where isapproved=false");
               rs = ps.executeQuery();

               while (rs.next()) {
                   userapprove user1 = new userapprove();
                   user1.setUsername(rs.getString(1));
                   user1.setDob(rs.getString(2));
                   user1.setUsertype(rs.getString(3));
                   user1.setUserid(rs.getString(4));
                   user1.setStatename(rs.getString(5));
                   
                   list.add(user1);

               }
           }
           
           else if( usertype==5 || usertype==7 || usertype==1 || usertype==2) {
               ps = conn.prepareStatement("select username,dob,usertype,userid from district_user where isapproved=false");
               rs = ps.executeQuery();

               while (rs.next()) {
                   userapprove user1 = new userapprove();
                   user1.setUsername(rs.getString(1));
                   user1.setDob(rs.getString(2));
                   user1.setUsertype(rs.getString(3));
                   user1.setUserid(rs.getString(4));
                   
                   list.add(user1);
               }
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

    

