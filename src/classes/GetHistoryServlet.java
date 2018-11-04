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

//
//Servlet implementation class GetHistoryServlet
//
@WebServlet("/GetHistoryServlet")
public class GetHistoryServlet extends HttpServlet 
{
	private static final long serialVersionUID = 5298036022257976608L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		DatabaseCon dbQuery = new DatabaseCon();
		QuoteViewer quotes = dbQuery.getQuoteHistory();
		request.getSession().setAttribute("quoteList", quotes.QuoteHistory);
		response.sendRedirect("quotehistory.jsp");
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
}