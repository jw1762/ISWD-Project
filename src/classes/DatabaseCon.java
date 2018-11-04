package classes;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		System.out.println(statement);
		long SQLResult = SQLState.executeLargeUpdate(statement);
		System.out.println(SQLResult);
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
		String insert = "INSERT INTO fuelquote (clientId, gallonsRequested, requestDate, deliveryDate, deliveryAddress, deliveryCity, deliveryState,"
		+ " deliveryZipCode, deliveryContactName, deliveryContactPhone, deliveryContactEmail, suggestedPrice, totalAmountDue) "		
		+ "VALUES (" + cid + ", " + gals + ", " + reqDate + ", " + delDate + ", '" + adr + "', '" + city + "', '" + state
		+ "', '" + zip + "', '" + name + "', '" + phone + "', '" + email + "', " + price + ", " + total + ");";
		System.out.print(insert);
		
		long SQLResult = SQLState.executeLargeUpdate(insert);
		System.out.print(SQLResult);
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
				
		//		Date delDate = Date.parse(delD);
		//		Date reqDate = Date.parse(reqD);
		//		quote.setdeliveryDate(delDate);
		//		quote.setrequestDate(reqDate);
				
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
		//
		//

}
