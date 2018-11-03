/**
 * @author Jordan Williamson & Michelle Pham
*/
package classes;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

//
//Servlet implementation class QuoteServlet
//

@WebServlet("/QuoteServlet")
public class QuoteServlet extends HttpServlet 
{
	private static final long serialVersionUID = 5298036022257976608L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		Quote test = new Quote();

		//int cid = request.getParameter("clientID")
	//		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		    //Date date = dateFormat.parse(request.getParameter("DelDate")); //Date convert error
			//Converts java.util.Date to java.sql.Date format
	//		java.util.Date utilDate = dateFormat.parse(request.getParameter("DelDate"));
	//		java.sql.Date date = new java.sql.Date(utilDate.getTime());
	//		System.out.println(date);
		
		String cid = request.getParameter("cid");
		String name = request.getParameter("DelCPN");
		String email = request.getParameter("DelCPE");
		String phone = request.getParameter("DelCPP");
		String adr = request.getParameter("DelAdr");
		String state = request.getParameter("DelState");
		String city = request.getParameter("DelCity");
		String zip = request.getParameter("DelZip");

		double gals = Double.parseDouble(request.getParameter("GalReq"));
		System.out.println(gals);
		double price = 2.50;
		System.out.println(price);
		double total = price*gals;		
		
		int intCID = Integer.parseInt(cid);
		test.setClientID(intCID);
	//	test.setdeliveryDate(date);
		test.setdeliveryAdr(adr);
		test.setdeliveryCity(city);
		test.setdeliveryState(state);
		test.setdeliveryZip(zip);		
		test.setgallonsRequested(gals);	
		test.setdeliveryContactEmail(email);
		test.setdeliveryContactName(name);
		test.setdeliveryContactPhone(phone);
		test.setsuggestedPrice(price);
		test.setTotalAmountDue(total);

	//sets data for JSP file		
	//	request.getSession().setAttribute("DelDate", date);	
		request.getSession().setAttribute("cid", cid);
		request.getSession().setAttribute("DelAdr", adr);	
		request.getSession().setAttribute("DelState", state);	
		request.getSession().setAttribute("DelCity", city);	
		request.getSession().setAttribute("DelZip", zip);	
		request.getSession().setAttribute("GalReq", gals);	
		request.getSession().setAttribute("DelCPN", name);	
		request.getSession().setAttribute("DelCPE", email);	
		request.getSession().setAttribute("DelCPP", phone);	
		request.getSession().setAttribute("PPG", price);	
		request.getSession().setAttribute("TotalDue", total);	
				
	//Calls new DatabaseCon class, containing functions for various DB actions.
		DatabaseCon querydb = new DatabaseCon();
	//Send new Quote Object to the SQL database as an SQL entry.
		try {
			querydb.sendQuoteToSQL(test);//Sends quote object to DatabaseCon function 
										//which translates into SQL execution.
		} catch (SQLException e) {e.printStackTrace();}
	///////////////////////////////////////////////////////////
		
			
		// return response
		response.sendRedirect("returnquote.jsp");
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
	
}