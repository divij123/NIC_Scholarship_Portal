/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

/**
 *
 * @author DIVIJ
 */
public class grantuser {
    
    private String username,userid;
    private int usertype;
    private boolean isreport,iscreate,isupdate,isdelete;

    public boolean isIsreport() {
        return isreport;
    }

    public void setIsreport(boolean isreport) {
        this.isreport = isreport;
    }

    public boolean isIscreate() {
        return iscreate;
    }

    public void setIscreate(boolean iscreate) {
        this.iscreate = iscreate;
    }

    public boolean isIsupdate() {
        return isupdate;
    }

    public void setIsupdate(boolean isupdate) {
        this.isupdate = isupdate;
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

    public int getUsertype() {
        return usertype;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }
  
}
