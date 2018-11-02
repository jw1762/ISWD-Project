package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCon {
	
	public void getQuoteHistory() 
	{
	//JDBC Implementation
	//Connects to database, returns info.
		String testDB = "jdbc:mysql://localhost:3306/cs3320";
		String psw = "your_password";
		String clientID = "root";//Note that at some point cID will be generated/used from elsewhere, likely for Assignment 5?
		String driver = "com.mysql.cj.jdbc.Driver";
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
			{
				//reading data from each row while rows exist.
				String results = "";
				results += testResult.getString("quoteId") + " ";
				results += testResult.getString("clientId") + " ";
				results += testResult.getString("gallonsRequested") + " ";
				results += testResult.getString("requestDate") + " ";
				results += testResult.getString("deliveryDate") + " ";
				results += testResult.getString("deliveryAddress") + " ";
				results += testResult.getString("deliveryState") +" ";
				results += testResult.getString("deliveryZipCode")+" ";
				results += testResult.getString("deliveryContactName")+" ";
				results += testResult.getString("deliveryContactPhone")+" ";
				results += testResult.getString("deliveryContactEmail")+" ";
				results += testResult.getString("suggestedPrice")+" ";
				results += testResult.getString("totalAmountDue")+" ";
				System.out.print(results + " ");
			}
			} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	
	public void getClientInfo() 
	{	
		//JDBC Implementation
		//Connects to database, returns info.
			String testDB = "jdbc:mysql://localhost:3306/cs3320";
			String psw = "your_password";
			String clientID = "root";//Note that at some point cID will be generated/used from elsewhere, likely for Assignment 5?
			String driver = "com.mysql.cj.jdbc.Driver";
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
				ResultSet testResult = testState.executeQuery("select * from clientinformation");
				
				while (testResult.next())
				{
					//reading data from each row while rows exist.
					String results = "";
					results += testResult.getString("clientid") + " ";
					results += testResult.getString("fullName") + " ";
					results += testResult.getString("address") + " ";
					results += testResult.getString("city") + " ";
					results += testResult.getString("state") + " ";
					results += testResult.getString("zipCode") + " ";
					results += testResult.getString("phone") +" ";
					results += testResult.getString("email")+" ";
					System.out.print(results + " ");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	}
		//
		//

}
