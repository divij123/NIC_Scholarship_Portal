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
public class registerCheck{
    
    public String validate(String username, int usertype  , String userpass , String cpass , String userid , String dob , boolean report, boolean create, boolean update, boolean isdelete) throws SQLException {
        
        Connection conn = null;
        Connect con = new Connect();
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        
        securepassword p1 = new securepassword();
        String userpassword = p1.hashpassword(userpass);
        
        ResultSet rs = null ;
        
        try{
        conn = con.connectionLogin();
        if(cpass.equals(userpass)) {
            
          
            
            
            if (usertype<=4) {
                ps = conn.prepareStatement("insert into state_user (username, usertype ,userid , password , dob,isapproved) values (? , ? , ? ,? ,?, false)");
                ps.setString(1, username);
                ps.setInt(2, usertype);
                ps.setString(3, userid);
                ps.setString(4, userpassword);
                ps.setString(5,dob);
                ps.executeUpdate();                
                
                ps1 = conn.prepareStatement("insert into grant_access (username, userid, isreport , iscreate, isupdate , isdelete) values (?,?,?,?,?,?)");
                ps1.setString(1,username);
                ps1.setString(2 , userid);
                ps1.setBoolean(3, report);
                ps1.setBoolean(4,create);
                ps1.setBoolean(5, update);
                ps1.setBoolean(6, isdelete);
                ps1.executeUpdate();
                
                conn.commit();
                
            }
            
            else {
                
                ps = conn.prepareStatement("insert into district_user ( username, usertype ,userid , password , dob,isapproved) values (? , ? , ? ,? ,?,false)");
                ps.setString(1, username);
                ps.setInt(2, usertype);
                ps.setString(3, userid);
                ps.setString(4, userpassword);
                ps.setString(5, dob);
                ps.executeUpdate();

                ps1 = conn.prepareStatement("insert into grant_access (username, userid, isreport , iscreate, isupdate , isdelete) values (?,?,?,?,?,?)");
                ps1.setString(1,username);
                ps1.setString(2 , userid);
                ps1.setBoolean(3, report);
                ps1.setBoolean(4,create);
                ps1.setBoolean(5, update);
                ps1.setBoolean(6, isdelete);
                ps1.executeUpdate();
                
                conn.commit();
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
