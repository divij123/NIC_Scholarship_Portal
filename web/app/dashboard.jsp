<%-- 
    Document   : dashboard
    Created on : 27 May, 2019, 4:15:27 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

            <s:include value = "/app/header.jsp"/>

                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                   
                    <h1 class="h2">Dashboard</h1>
                     <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3">
                     <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group mr-2">
                                <a href="showIP" class="btn btn-sm btn-outline-secondary" >Show IP</a>
                                
                            </div>
                     </div>
                     </div>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Password</th>
                                    <th>IP Address</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><s:property value="username"/></td>
                                    <td><s:property value="userpass"/></td>
                                    <td><s:property value="ipAddress"/></td>
                                </tr>
                                                            
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>
   
                <s:include value = "/app/header.jsp"/>