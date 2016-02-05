<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/taglib.jsp" %>

<h2>${user.id}</h2>
<h1>${user.name}</h1>
<h2>${user.email}</h2>

<c:forEach items="${user.blogs}" var="blog">
<h2>${blog.name}</h2>
<p>${blog.url}</p>

<table class="table table-bordered table-hover table-stripped">
<thead><tr><th>Name</th><th>Link</th><th>Description</th></tr></thead>
<tbody>
<c:forEach  items="${blog.items}" var="item">
<tr>
<td>${item.title }</td>
<td>${item.link }</td>
<td>${item.description }</td>
</tr>


</c:forEach>


</tbody>
</table>

</c:forEach>

