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
import java.util.Calendar;
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
		try {
		//int cid = request.getParameter("clientID")
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy"); //The format DelDate gets parse to
			//SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //Format of MYSQL DateTime
		    //Date date = dateFormat.parse(request.getParameter("DelDate")); //Date convert error
			
			//Converts java.util.Date to java.sql.Date format
			java.util.Date utilDate = dateFormat.parse(request.getParameter("DelDate"));
			java.sql.Date delDate = new java.sql.Date(utilDate.getTime()); //Formats the date to correct format needed &
																		//truncates the time, setting it to 00:00:00
			System.out.println(delDate);
			
			//Gets the current date for reqDate
			utilDate = Calendar.getInstance().getTime();
			Calendar calendar = Calendar.getInstance();
			java.sql.Date reqDate = new java.sql.Date(calendar.getTime().getTime());
			System.out.println(reqDate);
			
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
			double price = Double.parseDouble(request.getParameter("PPG"));
			System.out.println(price);
			double total = price*gals;		
			
			int intCID = Integer.parseInt(cid);
			test.setClientID(intCID);
			test.setdeliveryDate(delDate);
			test.setrequestDate(reqDate);
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
			request.getSession().setAttribute("DelDate", delDate);	
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
		}catch(ParseException e) {
			  e.printStackTrace();
		}
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
	
}