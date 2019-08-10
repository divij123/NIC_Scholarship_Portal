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
public class fetch {
    
    public String execute() {
        return "success";
    }
    
//    ArrayList<user> list = new ArrayList<user>();
//    
//    public ArrayList<user>getList() {
//        return list;
//    }
//    
//    public void setList(ArrayList<user> list) {
//        this.list = list;
//    }
//    
//    public String execute() throws SQLException {
//       
//            Connection conn = null;
//            Connect con = new Connect();
//            
//            PreparedStatement ps = null;
//            ResultSet rs = null;
//            
//       try {
//           conn = con.connectionLogin();
//           
//           ps = conn.prepareStatement("select name,username,email,password,dob from register");
//           rs = ps.executeQuery();
//           
//           while (rs.next()) {
//               user user1 = new user();
//               user1.setName(rs.getString(1));
//               user1.setUsername(rs.getString(2));
//               user1.setEmail(rs.getString(3));
//               user1.setPassword(rs.getString(4));
//               user1.setDob(rs.getString(5));
//               list.add(user1);
//            
//           }
//          }catch(SQLException ex){
//            System.out.println("ex = " + ex.toString());
//        }
//        
//        finally{
//            if (ps!=null) {
//                ps.close();
//          
//            }
//            if (rs!=null) {
//                rs.close();
//            }
//            if (conn!=null) {
//                conn.close();
//            }
//            
//            }
//                 
//        return "success";
//        
//    }
}
