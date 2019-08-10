<%--
    Document   : createuser
    Created on : 2 Jun, 2019, 10:47:53 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<%

switch ((int)session.getAttribute("usertype")) 
{
    case 1:
        break;
    case 2:
        response.sendRedirect("./app/state/createuser_state.jsp");
        break;
    case 3:
        response.sendRedirect("./public/accesserror.jsp");
        break;
    case 4:
        response.sendRedirect("./app/state/createuser_state.jsp");
        break;
    case 5:
        response.sendRedirect("./app/district/createuser_district.jsp");    
        break;
    case 6:
        response.sendRedirect("./public/accesserror.jsp");
        break;
    case 7:
        response.sendRedirect("./app/district/createuser_district.jsp");    
        break;
    
}

%>

<s:include value = "/app/header.jsp"/>
<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <br><br>
    <h1 class="h2">Create User</h1>
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <div class="btn-toolbar mb-2 mb-md-0">
            <div class="btn-group mr-2">

            </div>
        </div>
    </div>
    <div class="table-responsive">

        <form method="post">

            <input type="text" class="form-control" placeholder="Username" name="username" id="username" onkeyup="loginClick()">
            <br>
            <input type="number" class="form-control" placeholder="Enter Usertype" name="usertype" id="usertype" onkeyup="loginClick()">
            <br>
            <span style="color:blueviolet;">Usertypes : <br> 
                2 - Admin (State)<br>
                3 - Reporting (State)<br>
                4 - Mixed (State)<br>
                5 - Admin (District)<br>
                6 - Reporting (District)<br>
                7 - Mixed (Distritct)
            </span>
            <br><br>

            <span id="errUserType"></span>

            <span class="highlight"> Grant Roles</span><br><br>

            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="report" id="report" name="report">
                <label class="form-check-label" for="report">
                    Reports
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="create" id="create" name="create">
                <label class="form-check-label" for="create">
                    Create
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="update" id="update" name="update">
                <label class="form-check-label" for="update">
                    Update
                </label>
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="delete" id="delete" name="delete">
                <label class="form-check-label" for="delete">
                    Delete
                </label>
            </div>

            <br>
            <input type="date" class="form-control" placeholder="Date of birth" name="dob" id="dob" onkeyup="loginClick()">
            <br>

            <input type="password" name="userpass" placeholder="Enter Password" class="form-control" id="userpass" onkeyup="loginClick()">
            <br>
            <span id="errPass"></span>
            <br>
            <input type="password" name="cpass" placeholder="Confirm Password" class="form-control" id="cpass" onkeyup="loginClick()">
            <br>
            <input type="submit" value="Submit" name="sub" class="btn-primary space" onclick="submitform()"/>
            <br><br><br>
        </form>
    </div>
</main>
</div>
</div>

<s:include value = "/app/footer.jsp"/>


<script>     
    function loginClick() {
      var username = document.getElementById('username').value;
      var usertype = document.getElementById('usertype').value;
      var cpass = document.getElementById('cpass').value;
      var dob = document.getElementById('dob').value;
       var password = document.getElementById('userpass').value;
       var text = document.getElementById('errPass');
       var text1 = document.getElementById('errUserType');

               
var btn1 = document.getElementById('btn1');
    
if(username==='' || password==='' || usertype==='' || cpass=== '' || dob === ''){
btn1.disabled = true;
alert("Fields are empty!!!!");
} else{
btn1.disabled = false;
}
      
if(!isValidPassword(password)) {
  btn1.disabled = true;
  text.innerHTML = "The password should be between 8 to 32 characters which contains at least one numeric digit, one uppercase and one lowercase letter"; 
}
else {
  btn1.disabled = false;
}
      
if(!isValidUserType(usertype)) {
  btn1.disabled = true;
  text1.innerHTML = "The usertype should be between 2-7"
}
else {
  btn1.disabled = false;
}
}
    
function isValidPassword(password) {
            var regex = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,32}$/;
        return regex.test(password);
    }

    function isValidUserType(usertype) {
        if (usertype < 2 && usertype > 7) {
            return false;
        } else {
            return true;
        }

    }


</script>


<script>
    function submitform() {

        console.log("click");

        var username = $("#username").val();
        var usertype = $("#usertype").val();
        var dob = $("#dob").val();
        var pass = $("#userpass").val();
        var cpass = $("#cpass").val();
        
        var report = $("#report").prop('checked');
        var create = $("#create").prop('checked');
        var update = $("#update").prop('checked');
        var isdelete = $("#delete").prop('checked');
        
      
        $.post("register", {username: username, usertype: usertype, dob:dob , userpass:pass ,cpass:cpass, report: report, create: create, update: update, isdelete: isdelete}, function () {
            alert("user created successfully");
        });
    }
</script>