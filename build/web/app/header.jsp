<%-- 
    Document   : header
    Created on : 2 Jun, 2019, 10:14:32 PM
    Author     : DIVIJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>


<%
response.setHeader("Cache-Control","no-cache"); 
response.setHeader("Pragma","no-cache"); 
response.setDateHeader ("Expires", -1); 
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
        <meta HTTP-EQUIV="Expires" CONTENT="-1">
        <title>JSP Page</title>
        
        <noscript>
            <% 
                response.sendRedirect("./public/accesserror.jsp");
            %>
        </noscript>
        
        <link href="${pageContext.request.contextPath}/public/css/bootstrap-4.3.1-dist/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/app/css/main.css" rel="stylesheet" type="text/css" /> 
       
    </head>
    <body>
        <nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
            <a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Welcome <s:property value="#session['username']" /></a>
            <input class="form-control form-control-dark w-100" type="text" placeholder="Search" aria-label="Search">
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="signout">Sign out</a>
                </li>
            </ul>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <nav class="col-md-2 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link active" href="dashboardRedirect">
                                    <span data-feather="home"></span>
                                    Dashboard <span class="sr-only">(current)</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="createuser">
                                    <span data-feather="users"></span>
                                    Create User
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="grantAccess">
                                    <span data-feather="users"></span>
                                    Grant Access
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="viewrecords">
                                    <span data-feather="file"></span>
                                    View Records
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="passwordRedirect">
                                    <span data-feather="users"></span>
                                    Change Password
                                </a>
                            </li>                        
                            <li class="nav-item">
                                <a class="nav-link" href="approveUser">
                                    <span data-feather="users"></span>
                                    Approve User
                                </a>
                            </li>
                            
                        </ul>

                    </div>
                </nav>
