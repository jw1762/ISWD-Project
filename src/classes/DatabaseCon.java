package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseCon {
	
	String testDB = "jdbc:mysql://localhost:3306/cs3320";
	String psw = "your_password";
	String clientID = "root";//Note that at some point cID will be generated/used from elsewhere, likely for Assignment 5?
	String driver = "com.mysql.cj.jdbc.Driver";
	
	public void sendClientSQL(ClientInformation newCI) throws SQLException 
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection SQLCon = DriverManager.getConnection(testDB, clientID, psw);
		Statement SQLState = SQLCon.createStatement();
		
		String name = newCI.getName();
		String email = newCI.getEmail();
		String phone = newCI.getPhone();
		int cid = newCI.getClientID();
		
		String adr = newCI.getAddress();
		String city = newCI.getCity();
		String state = newCI.getState();
		int zip = newCI.getZip();
		
		String statement = "INSERT INTO clientInformation (fullName, address, city, state, zipCode, phone, email) "
				+ "VALUES ('" + name + "', '" + adr + "', '" + city + "', '" + state + "', " + zip +", '"+ phone +"', '"+ email + "');";
		long SQLResult = SQLState.executeLargeUpdate(statement);
	}
	
	public void sendQuoteToSQL(Quote quote) throws SQLException
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection SQLCon = DriverManager.getConnection(testDB, clientID, psw);
		Statement SQLState = SQLCon.createStatement();
		
		int cid = quote.getClientID();
		String name = quote.getdeliveryContactName();
		String email = quote.getdeliveryContactEmail();
		String phone = quote.getdeliveryContactPhone();
		Date reqDate = quote.getrequestDate();
		Date delDate = quote.getdeliveryDate();
		String adr = quote.getdeliveryAdr();
		String state = quote.getdeliveryState();
		String city = quote.getdeliveryCity();
		String zip = quote.getdeliveryZip();
		double gals = quote.getgallonsRequested();
		double price = quote.getsuggestedPrice();
		double total = quote.getTotalAmountDue();
				
		///Currently hardcoded clientID 1, because in order to put in a new quote,
		///the ID must already exist in clientinformation table.
		///
		/*String insert = "INSERT INTO fuelquote (clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState,"
		+ " deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue) "		
		+ "VALUES (" + cid + ", " + gals + ", " + reqDate + ", " + delDate + ", '" + adr + "', '" + city + "', '" + state
		+ "', '" + zip + "', '" + name + "', '" + phone + "', '" + email + "', " + price + ", " + total + ");";
			
		long SQLResult = SQLState.executeLargeUpdate(insert);*/
		
		//Create the mysql insert using preparedstatement, the only? way to get date
		String insert = "INSERT INTO fuelquote (clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState,"
				+ " deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue) "
		        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement preparedStmt = SQLCon.prepareStatement(insert);
		preparedStmt.setInt    (1, cid);
		preparedStmt.setDouble (2, gals);
		preparedStmt.setDate   (3, reqDate);
		preparedStmt.setDate   (4, delDate);
		preparedStmt.setString (5, adr);
		preparedStmt.setString (6, city);
		preparedStmt.setString (7, state);
		preparedStmt.setString (8, zip);
		preparedStmt.setString (9, name);
		preparedStmt.setString (10, phone);
		preparedStmt.setString (11, email);
		preparedStmt.setDouble (12, price);
		preparedStmt.setDouble (13, total);
	
		// execute the preparedstatement
		preparedStmt.execute();
	  
		SQLCon.close();
	}
	
	public void updateClientSQL(ClientInformation newCI) throws SQLException 
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection SQLCon = DriverManager.getConnection(testDB, clientID, psw);
		
		String name = newCI.getName();
		String email = newCI.getEmail();
		String phone = newCI.getPhone();
		int cid = newCI.getClientID();
		
		String adr = newCI.getAddress();
		String city = newCI.getCity();
		String state = newCI.getState();
		int zip = newCI.getZip();
	 
		String update = "UPDATE clientInformation SET address = '" + adr + "', city = '"
				+ city + "', state = '" + state + "', zipCode = "	+ zip + ", phone = '" + phone + "', email = '"
				+ email + "'" + " WHERE fullName='" + name + "'";
		
		Statement ps = SQLCon.createStatement();		
	
		// execute the java preparedstatement
		ps.executeUpdate(update);
	}
	
	public QuoteViewer getQuoteHistory() 
	{
		QuoteViewer qv = new QuoteViewer();
		String galReq, reqD, delD, delAdr, delZIP, 
		delST, delName, delPhone, delEmail, sugPrice, TAD = "";
		
	//JDBC Implementation
	//Connects to database, returns info.
		try {
			try {
				Class.forName(driver);
				}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			
		//	DriverManager.registerDriver(new Driver());//Don't think this is needed.
			Connection testCon = DriverManager.getConnection(testDB, clientID, psw);
			Statement testState = testCon.createStatement();
			ResultSet testResult = testState.executeQuery("select * from fuelquote");
						
			while (testResult.next())
			{	//Create a new quote object EVERY time
				Quote quote = new Quote();
				
				//reading data from each row while rows exist.
	
				galReq = testResult.getString("gallonsRequested");
				reqD = testResult.getString("requestDate");
				delD = testResult.getString("deliveryDate");
				delAdr = testResult.getString("deliveryAddress");
				delST = testResult.getString("deliveryState");
				delZIP = testResult.getString("deliveryZipCode");
				delName = testResult.getString("deliveryContactName");
				delPhone = testResult.getString("deliveryContactPhone");
				delEmail = testResult.getString("deliveryContactEmail");
				sugPrice = testResult.getString("suggestedPrice");
				TAD = testResult.getString("totalAmountDue");	
				//set all quote obj data to above strings.
				
				int intQID = Integer.parseInt(testResult.getString("quoteId"));
				int intcid = Integer.parseInt(testResult.getString("clientId"));
				double dblGals = Double.parseDouble(galReq); 
				double dblSugP = Double.parseDouble(sugPrice);
				double dblTAD = Double.parseDouble(TAD);
				
				quote.setgallonsRequested(dblGals);
				quote.setsuggestedPrice(dblSugP);
				quote.setTotalAmountDue(dblTAD);
				
				quote.setdeliveryAdr(delAdr);
				quote.setdeliveryState(delST);
				quote.setdeliveryZip(delZIP);
				
				quote.setQuoteID(intQID); 
				quote.setClientID(intcid);
				quote.setdeliveryContactEmail(delEmail);
				quote.setdeliveryContactName(delName);
				quote.setdeliveryContactPhone(delPhone);
				
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					java.util.Date utilDelDate = dateFormat.parse(delD);
					java.sql.Date delDate = new java.sql.Date(utilDelDate.getTime());
					
					java.util.Date utilReqDate = dateFormat.parse(reqD);
					java.sql.Date reqDate = new java.sql.Date(utilReqDate.getTime());
					
					//Date delDate = dateFormat.parse(delD);
					//Date reqDate = dateFormat.parse(reqD);
					quote.setdeliveryDate(delDate);
					quote.setrequestDate(reqDate);
				}catch(ParseException e) {
					  e.printStackTrace();
				}
		//add new quote obj to list of quotes
		//this should be a new quote for every row
				qv.QuoteHistory.add(quote);
		//repeat
			}
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	//return the list of quotes!
		return qv;
	}
	
	public AllClientViewer getAllClients() 
	{
		AllClientViewer acv = new AllClientViewer();
		String name, addr, city, state, zip, 
		phone, email = "";
		
	//JDBC Implementation
	//Connects to database, returns info.
		try {
			try {
				Class.forName(driver);
				}
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}			
		//	DriverManager.registerDriver(new Driver());//Don't think this is needed.
			Connection testCon = DriverManager.getConnection(testDB, clientID, psw);
			Statement testState = testCon.createStatement();
			ResultSet testResult = testState.executeQuery("select * from clientinformation");
						
			while (testResult.next())
			{	//Create a new clientinfo object EVERY time
				ClientInformation client = new ClientInformation();
				
				//reading data from each row while rows exist.
	
				name = testResult.getString("fullName");
				addr = testResult.getString("address");
				city = testResult.getString("city");
				state = testResult.getString("state");
				zip = testResult.getString("zipCode");
				phone = testResult.getString("phone");
				email = testResult.getString("email");
				//set all quote obj data to above strings.
				
				int intcid = Integer.parseInt(testResult.getString("clientId"));
				int iZip = Integer.parseInt(zip); 
				
				client.setClientID(intcid);
				client.setName(name);
				client.setPhone(phone);
				client.setEmail(email);
				client.setAddress(addr);
				client.setCity(city);
				client.setState(state);
				client.setZip(iZip);
				
		//add new quote obj to list of quotes
		//this should be a new quote for every row
				acv.AllClient.add(client);
		//repeat
			}
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	//return the list of quotes!
		return acv;
	}
	
	public int getClientID(String name) 
	{	
		int intCid = 0;
		//JDBC Implementation
		//Connects to database, returns info.
			try {
				try {
					Class.forName(driver);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			//	DriverManager.registerDriver(new Driver());//Don't think this is needed.
				Connection testCon = DriverManager.getConnection(testDB, clientID, psw);
				Statement testState = testCon.createStatement();
				ResultSet testResult = testState.executeQuery("select * from clientinformation WHERE fullName='" + name + "';");
				while (testResult.next())
				{
					//reading data from each row while rows exist.
					String cid = testResult.getString("clientId");
					intCid = Integer.parseInt(cid);
					//return intCid;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			return intCid;
	}
	public boolean getClientHistory(int id) 
	{	
		//JDBC Implementation
		//Connects to database, checks if client requested fuel before.
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		//	DriverManager.registerDriver(new Driver());//Don't think this is needed.
			Connection testCon = DriverManager.getConnection(testDB, clientID, psw);
			Statement testState = testCon.createStatement();
			ResultSet testResult = testState.executeQuery("select * from fuelquote WHERE clientId='" + id + "';");
			while (testResult.next()){
				return true; //returns true if client history found
		    }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return false; //returns false by default
	}
}
