<%@page import="models.employe"%>
<%@page import="java.util.List"%>
<%@page import="services.employeservice"%>
<%@page import="dbconnections.employedb"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>welcome</title>
</head>
<%@include file="Bootstrap.jsp" %>
<body>
<table class="table">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">name</th>
      <th scope="col">email</th>
      <th scope="col">phoneno</th>
      <th scope="col">action</th>
    </tr>
  </thead>
  <tbody>
  <%
  employeservice service = new employeservice(employedb.getconnection());
  List<employe> em = service.fetchall();
 for(employe emp : em){
	 
 
  %>
    <tr>
      <th scope="row"><%=emp.getId() %></th>
      <td><%=emp.getName() %></td>
      <td><%=emp.getEmail() %></td>
      <td><%=emp.getPhoneno() %></td>
      <td>
      <button class="btn btn-outline-warning">update</button>
      <a href="delete?id=<%=emp.getId() %>">
      <button class="btn btn-outline-danger">delete</button>
      </a>
      
      </td>
    </tr>
    <%} %>
   
  </tbody>
</table>

<h1></h1>
</body>
</html>