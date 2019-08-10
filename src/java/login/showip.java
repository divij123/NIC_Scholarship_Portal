/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author DIVIJ
 */
public class showip extends generateip{
    
    generateip gn = new generateip();

    public generateip getGn() {
        return gn;
    }

    public void setGn(generateip gn) {
        this.gn = gn;
    }
    
    public String execute(){
     
        return "success";

    }
    
}
