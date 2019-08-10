/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DIVIJ
 */
public class generateip {
//    public static String getClientIP(HttpServletRequest request) {
//    String ipAddress = request.getHeader("X-Forwarded-For");
//    if (ipAddress == null) {
//        return request.getRemoteAddr();
//    } else {
//        return new StringTokenizer(ipAddress, ",").nextToken().trim();
//    }
//  }
    
    public String getClientIP(){
       
        HttpServletRequest request = null; 
        
        String ipaddress = request.getRemoteAddr();
        
        return ipaddress;
    }
    
}