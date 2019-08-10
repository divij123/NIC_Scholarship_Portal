/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package register;

import example.registerCheck;
import java.sql.SQLException;
import random.userid;

/**
 *
 * @author DIVIJ
 */
public class registerUser {
    private String username , dob , userpass , cpass;
    private boolean report,create,update,isdelete;
    private int usertype;

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }

    public boolean isReport() {
        return report;
    }

    public void setReport(boolean report) {
        this.report = report;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

    public boolean isUpdate() {
        return update;
    }

    public void setUpdate(boolean update) {
        this.update = update;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    
    public String execute() throws SQLException {
        registerCheck register = new registerCheck();
        userid id = new userid();
        String userid = id.generateRandom();
       
        if("success".equals(register.validate(username, usertype , userpass , cpass, userid , dob , report, create, update, isdelete))) {
            return "success";
        }
        else {
            return "error";
        }
    }
    
}
