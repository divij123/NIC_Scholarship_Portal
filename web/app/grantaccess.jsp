<%--w 
    Document   : grantaccess
    Created on : 11 Jun, 2019, 2:29:17 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

<s:include value = "/app/header.jsp"/>

<script>
    
    function togglereport() {
    var report = document.getElementById("ireport");
    if(report.checked) {
        report.checked= false;
        
    } else {
        report.checked= true;

    }
   }
    
    
    function togglecreate() {
    var create = document.getElementById("icreate");
    if(create.checked) {
        create.checked= false;
        
    } else {
        create.checked= true;

    }
   }
   
   function toggleupdate() {
    var update = document.getElementById("iupdate");
    if(update.checked) {
        update.checked= false;
        
    } else {
        update.checked= true;

    }
   }
    
    function toggledelete() {
    var idelete = document.getElementById("idelete");
    if(idelete.checked) {
        idelete.checked= false;
        
    } else {
        idelete.checked= true;

    }
   }
    
    
    
    
    
</script>

<style>
    #openmodal {
        display: none;
    }
</style>


<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
        <h1 class="h2">Grant Access</h1>
    </div>


    <div class="table-responsive">
        <table class="table table-striped table-sm">
            <thead>
                <tr>
                    <th>Username</th>
                    <th>Usertype</th>
                    <th>Userid</th>
                    <th>Grant/Revoke</th>
                </tr>
            </thead>
            <tbody>

                <s:iterator  value="list" status="status">  
                <fieldset>
                    <tr>
                        <td class="username"><s:property value="username"/></td>  
                        <td class="usertype"><s:property value="usertype"/></td>  
                        <td class="userid"><s:property value="userid"/></td>
                            
                        <td class="report" hidden><s:property value="isreport" /></td>
                        <td class="create" hidden>  <s:property value="iscreate" /></td>
                        <td class="update" hidden> <s:property value="isupdate" /></td>
                        <td class="delete" hidden> <s:property value="isdelete" /></td>

                        <td><button onclick="openModal(document.getElementsByClassName('username')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('usertype')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('userid')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('report')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('create')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('update')[<s:property value="%{#status.index}" />].innerHTML,document.getElementsByClassName('delete')[<s:property value="%{#status.index}" />].innerHTML)" type="submit" class="btn btn-secondary">Grant/Revoke</button></td>
                    </tr>     
                </fieldset>  
                </s:iterator>    


                </tbody>
            </table>
        </div>

    </main>



    <div id="openmodal" class="modal" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLongTitle">Grant / Revoke</h5>

                    <span class="close1">&times;</span>

                </div>
                 
                <form method="post" id="myform">
                    <div class="modal-body">
                      
                        <input class="form-control" id="iuser" type="text" name="username" placeholder="Enter username" disabled><br>

                        <input class="form-control" id="itype" type="number" placeholder="Enter Usertype" disabled><br>

                        <input class="form-control" id="iid" type="text" name="userid" placeholder="Enter UserID" disabled><br>

                        <div class="custom-control custom-checkbox" onclick="togglereport()">
                            <input type="checkbox" class="custom-control-input" id="ireport" value="report" name="role" onclick="togglereport()">
                            <label class="custom-control-label" for="report">Reports</label>
                        </div>
                        
                        <div class="custom-control custom-checkbox" onclick="togglecreate()">
                            <input type="checkbox" class="custom-control-input" id="icreate" value="create" name="role" onclick="togglecreate()"> 
                            <label class="custom-control-label" for="create">Create</label>
                        </div>

                        <div class="custom-control custom-checkbox" onclick="toggleupdate()">
                            <input type="checkbox" class="custom-control-input" id="iupdate" value="update" name="role" onclick="toggleupdate()">
                            <label class="custom-control-label" for="update"> Update</label>
                        </div>

                        <div class="custom-control custom-checkbox" onclick="toggledelete()">
                            <input type="checkbox" class="custom-control-input" id="idelete" value="delete" name="role" onclick="toggledelete()">
                            <label class="custom-control-label" for="delete">Delete</label>
                        </div>


                    </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" onclick="submitform()">Grant / Revoke</button>
                </div>
        </div>
        </form>

    </div>
</div>

</div>
</div>

<s:include value = "/app/footer.jsp"/>


<script>

    function submitform() {

        console.log("click");

        var username = $("#iuser").val();
        var userid = $("#iid").val();
        var report = $("#ireport").prop('checked');
        var create = $("#icreate").prop('checked');
        var update = $("#iupdate").prop('checked');
        var isdelete = $("#idelete").prop('checked');

        $.post("grantuser", {username: username, userid: userid, report: report, create: create, update: update, isdelete: isdelete}, function () {
            alert("Permission successfully granted");
        });
    }
    
    $("#ireport").click(function(){
       if($(this).is(':checked')) {
           $("#ireport").prop("checked" , false);
       }
       else {
        $("#ireport").prop("checked" , true);

        }
    });
       
    
</script>
<script src="${pageContext.request.contextPath}/public/js/modal.js"></script>


