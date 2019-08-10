<%-- 
    Document   : approveUser
    Created on : 3 Jun, 2019, 12:15:41 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>


            <s:include value = "/app/header.jsp"/>
    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
        <br><br>
                    <h1 class="h2">Approve User</h1>
                     <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                     <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group mr-2">
                                
                            </div>
                     </div>
                     </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>DOB</th>
                                    <th>User Type</th>
                                    <th>User ID</th>
                                    <th>Approve</th>
                                </tr>
                            </thead>
                            
                            <tbody>
                               
                                <s:iterator  value="list">  
                                <fieldset>
                                    <tr>  
                                        <td><s:property value="username"/></td>  
                                        <td><s:property value="dob"/></td>
                                        <td><s:property value="usertype"/></td>  
                                        <td><s:property value="userid"/></td>
                                        <td>
                                            <form method="post">
                                                <input type="hidden" name="username" id="username" value="<s:property value='username'/>">
                                                <input type="hidden" name="usertype" id="usertype" value="<s:property value='usertype'/>">
                                                <button class="btn-secondary" id="isapproved" name="isapproved" onclick="submitform()">Approve</button></td>                                       
                                            </form>
                                    </tr>
                                </fieldset>  
                            </s:iterator>  
    
                            </tbody>
                            
                    </div>
                </main>
            </div>
        </div>
        
                <s:include value = "/app/footer.jsp"/>
                
                
<script>
    function submitform() {

        console.log("click");

        var username = $("#username").val();
        var usertype = $("#usertype").val();
        
      
        $.post("approveuser", {username: username, usertype: usertype}, function () {
            alert("User approved successfully");
        });
    }
</script>