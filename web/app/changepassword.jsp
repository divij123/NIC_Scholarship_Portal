<%-- 
    Document   : changepassword
    Created on : 29 May, 2019, 6:50:17 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
                
                <s:include value = "/app/header.jsp"/>


                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Change Password</h1>

 
                </main>
                
                
                <div class="container-fluid">
<div class="row text-center">
    <div class="col-md-6 text-center col-lg-4 px-4" style="margin-left: 40%;">

        <form method="post" action="changepassword">
            <input class="form-control" type="text" id="username" name="username" placeholder="Enter username" onkeyup="togglePassword()">
            <input class="form-control" type="password" id="password" name="curpass" placeholder="Enter current password" onkeyup="togglePassword()">
            <input class="form-control" type="password" id="newpass" name="newpass" placeholder="Enter new password" onkeyup="togglePassword()">
            <span style="color:red;" id="error" name="error"></span>
            <input class="form-control" type="password" id="cpass" name="cpass" placeholder="Confirm password" onkeyup="togglePassword()">
            <input type="submit" id="btn1" class="form-control primary-btn" name="sub" value="Submit">
        </form>
    </div>
    
</div>
                    </div>                 

            </div>
                    
        </div>
        
        
                        <s:include value = "/app/footer.jsp"/>

        
            <script>
                function togglePassword() {
                    var user = document.getElementById("username");
                    var pass = document.getElementById("password");
                    var newpass = document.getElementById("newpass");
                    var cpass = document.getElementById("cpass");
                    var btn1 = document.getElementById("btn1");
                    if(user.value=='' || pass.value=='' || newpass.value=='' || cpass.value=='') {
                        btn1.disabled = true;
                        console.log("nooo");
                    }
                    else{
                        btn1.disabled = false;
                        console.log("yesss");
                    }
                    
                    
                    if(!isValidPassword(newpass.value)) {
                        var text = document.getElementById("error");
                        text.innerHTML="The password should be between 8 to 32 characters which contains at least one numeric digit, one uppercase and one lowercase letter";
                        btn1.disabled = true;
                        
                    }
                    
                    if(!isValidPassword()) {
                      
                    }
                    else{
                          var text = document.getElementById("error");
                        text.innerHTML="";
                        btn1.disabled = false;
                    }
                    
                }
                function isValidPassword(password) {
                    var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,32}$/;
                    return regex.test(password);
                }
                
            </script>
            
            
            <script>
                function submitform() {

        console.log("click");

        var newpass = $("#newpass").val();

        $.post("checkpass", {newpassword: newpass}, function () {
            alert("Password successfully changed");
        });
    }
            </script>
