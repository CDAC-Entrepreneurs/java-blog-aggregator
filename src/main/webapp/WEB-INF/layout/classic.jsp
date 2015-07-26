<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> <tiles:getAsString name="titlePage"></tiles:getAsString>   </title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">

<script src="https://code.jquery.com/jquery-2.1.4.min.js" ></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

<style type="text/css">

.container-start{
margin-top:60px;}

.ag-center{
text-align:center;
margin-left:auto;
margin-right:auto;
}


</style>
</head>
<body>

<tilesx:useAttribute name="current"/>


 <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href='<spring:url value="/index" />'><tiles:getAsString name="title" /></a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class=${current=="index"? "active":""}><a href='<spring:url value="/index" />'>Home</a></li>
            
           <security:authorize access="hasRole('ROLE_ADMIN')">
            <li class=${current=="users"? "active":""}><a href='<spring:url value="/users"></spring:url>'>Users</a></li>
    	    </security:authorize>
    	    
    	  <li class=${current=="register"? "active":""}><a href='<spring:url value="/register"></spring:url>'>Register</a></li>
			
			 <security:authorize access="! isAuthenticated()">
			<li class=${current=="login"? "active":""}><a href='<spring:url value="/login"></spring:url>'>Login</a></li>
          </security:authorize>
          
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>

<div class="container-start">
<tiles:insertAttribute name="body" />
</div>
<br /><br />

 <div class="ag-center"><tiles:insertAttribute name="footer" /></div>
</body>
</html>