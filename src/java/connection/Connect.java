/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DIVIJ
 */
public class Connect {
    
    public Connection connectionLogin() {
        Connection conn = null; 
        
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/nsp_db", "postgres", "123456");
          
        }
        catch(Exception e) {
            
        }
       
        
        return conn;
    }
    
  }
