/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.SQLException;

/**
 *
 * @author DIVIJ
 */
public class changepermission {
    
    private String username,userid;
    private boolean report,create,update,isdelete;

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

    public boolean isIsdelete() {
        return isdelete;
    }

    public void setIsdelete(boolean isdelete) {
        this.isdelete = isdelete;
    }
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    
    public String execute() throws SQLException, Exception {

        change change = new change();
        
        if ("success".equals(change.validate(username,userid,report,create,update,isdelete)))
        {
            return "success";
        }
        
        else {
            return "error";
        }
        
    }
    
}