<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

    &copy; nikhil sharma
   <security:authorize access="isAuthenticated()">
    <form action='<spring:url value="/logout" ></spring:url>' method="POST">
 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <input type="submit" value="logout" />
    </form>
    </security:authorize>