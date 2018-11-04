<!DOCTYPE html>
<html lang="en">

<head>
<title>Quote History</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styling.css">
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
<header>
   <h2>Quote History</h2> 
</header>

<section>
  <nav>
    <ul>
 	<!--   <li><a href="login.html">Login/Signup</a></li>  -->
      <li><a href="http://localhost:8080/ISWD-Project/Index.html">Home</a></li>
      <li><a href="http://localhost:8080/ISWD-Project/clientinfo.html">Client Information</a></li>
      <li><a href="http://localhost:8080/ISWD-Project/getquote.html">Request a Quote</a></li>
      <li><a class="active" href="http://localhost/ISWD-Project/history.php">Quote History</a></li> 
    </ul>
  </nav>
  
  <article>
    <h1>Quote History</h1>
		<table id="quotehistory">
			<th>Item #</th>
			<th>Name</th>
			<th>Location</th>
			<th>Delivery Date</th>
			<th>Gallons</th>
			<th>Rate</th>
			<th>Total Price</th>  
			
			<?php
				$conn = mysqli_connect("localhost", "root", "your_password", "cs3320");
				
				if ($conn->connect_error) {
					die("Connection failed: " . $conn->connect_error);
				} 
				$sql = "SELECT quoteId, deliveryContactName, deliveryAddress, deliveryDate, 
						gallonsRequested, suggestedPrice, totalAmountDue FROM fuelQuote";
				$result = $conn->query($sql);
				if ($result->num_rows > 0) {
					// output data of each row
					while($row = $result->fetch_assoc()) {
						echo "<tr><td>" . $row["quoteId"]. "</td><td>" . $row["deliveryContactName"] . "</td><td>"
						. $row["deliveryAddress"]. "</td><td>" . $row["deliveryDate"]. "</td><td>" 
						. $row["gallonsRequested"] . "</td><td>" . $row["suggestedPrice"]. "</td><td>" 
						. $row["totalAmountDue"]. "</td></tr>";
					}
				echo "</table>";
				} else { echo "0 results"; }
				$conn->close();
			?>
		</table>
	    
  </article>
</section>

<footer>
  <p>Copyright © 2018 Jordan Williamson & Michelle Pham. All rights reserved.</p>
</footer>

</body>
</html>