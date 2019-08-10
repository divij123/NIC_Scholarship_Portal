/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example;

import java.security.MessageDigest; 
import java.math.BigInteger; 
import java.security.NoSuchAlgorithmException;


/**
 *
 * @author DIVIJ
 */
public class securepassword {
    
    public String hashpassword(String password) {
        String hashtext = null;  
        try {
            
            MessageDigest md = MessageDigest.getInstance("SHA-512"); 
  
            byte[] messageDigest = md.digest(password.getBytes()); 
  
            BigInteger no = new BigInteger(1, messageDigest); 
  
            hashtext = no.toString(16); 
  
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
           
          }
           catch(NoSuchAlgorithmException ex) {
              
          }
            return hashtext; 
        
    }
    
    public boolean checkpassword (String userpass , String hash) {
        
        boolean password_verified = false;
        
        String hash_userpass = hashpassword(userpass);
 
        if(hash_userpass.equals(hash)) {
            password_verified = true;
        }
        
        return (password_verified);
    
    }
}
    