/**
 * @author Jordan Williamson & Michelle Pham
*/
package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.Locale;
import java.text.SimpleDateFormat; 
import java.text.ParseException;
import classes.Quote;

//This portion is currently hardcoded to return the
//values we set for quote.java,
//as we currently have no database of 
//names to pull from.
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
		//The assignment says nothing about a client ID, 
		//but it exists in the Quote object. Ignoring for now.
		
		//////////////////////////die in a fire//////////////////////////////////	
//		Date date = Date.parse(request.getParameter("DelDate"));
//		System.out.println(date);
		try {
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	    //Date date = dateFormat.parse(request.getParameter("DelDate")); //Date convert error
		
		//Converts java.util.Date to java.sql.Date format
		java.util.Date utilDate = dateFormat.parse(request.getParameter("DelDate"));
		java.sql.Date date = new java.sql.Date(utilDate.getTime());
		////////////////////////this is the devil////////////////////////////////	
		
		String name = request.getParameter("DelCPN");
		System.out.println(name);
		
		String loc = request.getParameter("DelLoc");
		System.out.println(loc);
				
		String email = request.getParameter("DelCPE");
		System.out.println(email);
		
		String phone = request.getParameter("DelCPP");
		System.out.println(phone);

		double gals = Double.parseDouble(request.getParameter("GalReq"));
		System.out.println(gals);
		
		double price = 2.50;
	//	double price = Double.parseDouble(request.getParameter("PPG"));
		System.out.println(price);
		
		double total = price*gals;		
		
		test.setdeliveryDate(date);
		test.setdeliveryLocation(loc);
		test.setgallonsRequested(gals);	
	//	test.setClientID(clientID);
		test.setdeliveryContactEmail(email);
		test.setdeliveryContactName(name);
		test.setdeliveryContactPhone(phone);
		test.setsuggestedPrice(price);
		test.setTotalAmountDue(total);
						
		//sets data for JSP file		
		request.getSession().setAttribute("DelDate", date);	
		request.getSession().setAttribute("DelLoc", loc);	
		request.getSession().setAttribute("GalReq", gals);	
		request.getSession().setAttribute("DelCPN", name);	
		request.getSession().setAttribute("DelCPE", email);	
		request.getSession().setAttribute("DelCPP", phone);	
		request.getSession().setAttribute("PPG", price);	
		request.getSession().setAttribute("TotalDue", total);	
				
		//Add the new quote object to the 
		//list arraylist of quotes.
		QuoteViewer qv = new QuoteViewer();
		qv.QuoteHistory.add(test);
		
		// return response
		response.sendRedirect("returnquote.jsp");
		}catch (ParseException e) {
	        e.printStackTrace();
	    } 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
	
}