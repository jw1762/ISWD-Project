<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="classes.Quote, javax.servlet.jsp.jstl.core.*, classes.QuoteViewer"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styling.css">
<title>Quote Information</title>
</head>
<body>
<header>
  <h2>Quote History</h2>
</header>

<section>
  <nav>
    <ul>
 <!-- <li><a href="login.html">Login/Signup</a></li>  -->
      <li><a href="Index.html">Home</a></li>
      <li><a href="clientinfo.html">Client Information</a></li>
      <li><a href="getquote.html">Request a Quote</a></li>
      <li><a class="active" href="history.html">Quote History</a></li>
    </ul>
  </nav>
  <article>
    <h1>Quote History</h1>
    <table>
    <tr>
    <th>Client ID</th> 
    <th>Contact Name</th> 
    <th>Contact Email</th> 
    <th>Contact Phone</th> 
    <th>Gallons Requested</th>
    <th>Request Date</th>
    <th>Date of Delivery</th>
    <th>Delivery Address</th>
    <th>Delivery State</th>
    <th>Delivery ZIP</th>
    <th>Total Due</th></tr>
    
    <c:forEach items="${quoteList}" var="Quote">
      <tr>
        <td><c:out value="${Quote.clientID}" /></td>
        <td><c:out value="${Quote.deliveryContactName}" /></td>
        <td><c:out value="${Quote.deliveryContactEmail}" /></td>
        <td><c:out value="${Quote.deliveryContactPhone}" /></td>
        <td><c:out value="${Quote.gallonsRequested}" /></td>
        <td><c:out value="${Quote.requestDate}" /></td>
        <td><c:out value="${Quote.deliveryDate}" /></td>    
        <td><c:out value="${Quote.deliveryAdr}" /></td>
        <td><c:out value="${Quote.deliveryState}" /></td>
        <td><c:out value="${Quote.deliveryZip}" /></td>
        <td><c:out value="${Quote.totalAmountDue}" /></td>
      </tr>
    </c:forEach>   
    </table>
    <form name="HistoryRequest" method="get" action="GetHistoryServlet">
	<br><input type="submit" value="Get NEW Quotes">
</form>
  </article>
</section>	

<footer>
  <p>Copyright © 2018 Jordan Williamson & Michelle Pham. All rights reserved.</p>
</footer>
</body>
</html>