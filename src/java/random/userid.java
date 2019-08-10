/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package random;

import java.util.UUID;


/**
 *
 * @author DIVIJ
 */
public class userid {
    
    public String generateRandom() {
        String random = UUID.randomUUID().toString();
        String rand_final = "NIC" + random ;
        return rand_final;
    }
}
