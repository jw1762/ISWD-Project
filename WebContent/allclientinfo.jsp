<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="classes.ClientInformation, javax.servlet.jsp.jstl.core.*, classes.AllClientViewer"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styling.css">
<title>Client Information</title>
</head>
<body>
<header>
  <h2>All Clients</h2>
</header>
<section>
  <nav>
    <ul>
 <!-- <li><a href="login.html">Login/Signup</a></li>  -->
      <li><a href="Index.html">Home</a></li>
      <li><a class="active" href="clientinfo.html">Client Information</a></li>
      <li><a href="getquote.html">Request a Quote</a></li>
      <li><a href="history.html">Quote History</a></li>
    </ul>
  </nav>
  
<article>
    <h1>Client Information</h1>
    <table>
    <tr>
    <th>Client ID</th> 
    <th>Name</th> 
    <th>Phone</th> 
    <th>Email</th> 
    <th>Address</th>
    <th>City</th>
    <th>State</th>
    <th>Zip</th></tr>
    
    <c:forEach items="${clientList}" var="client">
      <tr>
        <td><c:out value="${client.clientID}" /></td>
        <td><c:out value="${client.name}" /></td>
        <td><c:out value="${client.phone}" /></td>
        <td><c:out value="${client.email}" /></td>
        <td><c:out value="${client.address}" /></td>
        <td><c:out value="${client.city}" /></td>
        <td><c:out value="${client.state}" /></td>
        <td><c:out value="${client.zip}" /></td>
        </tr>
    </c:forEach>   
  </table>
	<form name="AllClients" method="get" action="AllClientServlet">
		<br><input type="submit" value="View ALL Client Information">
	</form>
  </article>
</section>	

<footer>
  <p>Copyright © 2018 Jordan Williamson & Michelle Pham. All rights reserved.</p>
</footer>
</body>
</html>