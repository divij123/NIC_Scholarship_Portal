/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function openModal(username,usertype,userid,isreport,iscreate,isupdate,isdelete) {
    
    isreport = isreport.trim();
    iscreate = iscreate.trim();
    isupdate = isupdate.trim();
    isdelete = isdelete.trim();
 
    var modal1 = document.getElementById('openmodal');
    
    var span1 = document.getElementsByClassName("close1")[0];
    
    var iuser = document.getElementById('iuser');
    var itype = document.getElementById('itype');
    var iid = document.getElementById('iid');
    var report = document.getElementById('ireport');
    var create = document.getElementById('icreate');
    var update = document.getElementById('iupdate');
    var idelete = document.getElementById('idelete');
    
    var rep = false;
    var cre = false;
    var del = false;
    var upd = false;
    
    iuser.value = "";
    itype.value = "";
    iid.value = "";
    
    iuser.value = username;
    itype.value = usertype;
    iid.value = userid;
    
    if (isreport === "true") {
        rep = true;
    }
    if (iscreate === "true") {
        cre = true;
    }
    if (isupdate === "true") {
        upd = true;
    }
    if (isdelete === "true") {
        del = true;
    }
    
    report.checked = rep;
    create.checked = cre;
    update.checked = upd;
    idelete.checked = del;
    
  
    modal1.style.display="block";
        

    span1.onclick = function () {
        modal1.style.display = "none";
    }

    window.onclick = function (event) {
        if (!event.target == modal1) {
            modal1.style.display = "none";
        }
    }
    
}
