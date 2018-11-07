<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styling.css">
<title>Quote Information</title>
</head>
<body>
<header>
  <h2>Requested Quote</h2>
</header>
<section>
  <nav>
    <ul>
 <!-- <li><a href="login.html">Login/Signup</a></li>  -->
      <li><a href="Index.html">Home</a></li>
      <li><a href="clientinfo.html">Client Information</a></li>
      <li><a class="active" href="getquote.html">Request a Quote</a></li>
      <li><a href="history.html">Quote History</a></li>
    </ul>
  </nav>
  
  <article>
    <h1>Quote Offer</h1>
    <p><b>Delivery Date: </b> <%= session.getAttribute("DelDate") %> <br><br>
	<b>Delivery Location: </b> <%= session.getAttribute("DelAdr") %> 
	<%= session.getAttribute("DelCity") %> <%= session.getAttribute("DelState") %>
	<%= session.getAttribute("DelZip") %><br><br>
	<b>Number of Gallons: </b> <%= session.getAttribute("GalReq") %> <br><br>
	<b>Contact Name: </b> <%= session.getAttribute("DelCPN") %> <br><br>
	<b>Contact Email: </b> <%= session.getAttribute("DelCPE") %> <br><br>
	<b>Contact Phone: </b> <%= session.getAttribute("DelCPP") %> <br><br>
	<b>Suggested Price: </b> <%= session.getAttribute("PPG") %> <br><br>
	<b>Total Due: </b> <%= session.getAttribute("TotalDue") %> </p>
  </article>
</section>	

<footer>
  <p>Copyright © 2018 Jordan Williamson & Michelle Pham. All rights reserved.</p>
</footer>
</body>
</html>