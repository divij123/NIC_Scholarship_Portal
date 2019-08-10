<%-- 
    Document   : viewrecords
    Created on : 29 May, 2019, 5:44:02 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>

            <s:include value = "/app/header.jsp"/>
            
                <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">Dashboard</h1>
<!--                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="btn-group mr-2">
                                <button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
                                <button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
                            </div>
                            <button type="button" class="btn btn-sm btn-outline-secondary dropdown-toggle">
                                <span data-feather="calendar"></span>
                                This week
                            </button>
                        </div>-->
                    </div>
                    
                    
                    <h2>Section title</h2>
                    <div class="table-responsive">
                        <table class="table table-striped table-sm">
                            <thead>
                                <tr>
                                    <th>Username</th>
                                    <th>Usertype</th>
                                    <th>Userid</th>
                                    <th>Timestamp</th>
                                    <th>Ip Address</th>
                                </tr>
                            </thead>
                            <tbody>

                                <s:iterator  value="list">  
                                <fieldset>
                                    <tr>
                                        <td><s:property value="username"/></td>  
                                        <td><s:property value="usertype"/></td>  
                                        <td><s:property value="userid"/></td>
                                        <td><s:property value="timestamp"/></td>  
                                        <td><s:property value="ipaddress"/></td>
                                    </tr>
                                </fieldset>  
                            </s:iterator>  

                            
                            </tbody>
                        </table>
                    </div>
                </main>
            </div>
        </div>
                <s:include value = "/app/header.jsp"/>