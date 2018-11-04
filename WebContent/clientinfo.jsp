<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="styling.css">
<title>Client Information</title>
</head>
<body>
<header>
  <h2>Client Information</h2>
</header>
<section>
  <nav>
    <ul>
 <!-- <li><a href="login.html">Login/Signup</a></li>  -->
      <li><a href="Index.html">Home</a></li>
      <li><a class="active" href="clientinfo.html">Client Information</a></li>
      <li><a href="getquote.html">Request a Quote</a></li>
      <li><a href="http://localhost/ISWD-Project/history.php">Quote History</a></li>
    </ul>
  </nav>
  
  <article>
    <h1>ClientID: <%= session.getAttribute("cid") %></h1>
    <p><b>Name:</b> <%= session.getAttribute("name") %> <br><br>
	<b>Address:</b> <%= session.getAttribute("adr") %> <br><br>
	<b>Email:</b> <%= session.getAttribute("email") %> <br><br>
	<b>Phone:</b> <%= session.getAttribute("phone") %> </p>
  </article>
</section>

<footer>
  <p>Copyright © 2018 Jordan Williamson & Michelle Pham. All rights reserved.</p>
</footer>
</body>
</html>