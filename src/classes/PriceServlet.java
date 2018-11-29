package classes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
//Servlet implementation class PriceServlet
//
@WebServlet("/PriceServlet")
public class PriceServlet extends HttpServlet 
{
	private static final long serialVersionUID = 5298036022257976608L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		Quote test = new Quote();
		DatabaseCon sql = new DatabaseCon();
		
		String cid = request.getParameter("cid");
		String state = request.getParameter("DelState");
		
		double gals = Double.parseDouble(request.getParameter("GalReq"));
//		System.out.println(gals);
		double price = 2.19;
//		System.out.println(price);
			
		boolean history = sql.getClientHistory(Integer.parseInt(cid));
		double locFactor, rateFactor, galFactor, profitFactor = .05, rateFluctuation=.04;

		if(state.equals("TX") || state.equals("Tx") || state.equals("tx"))
			locFactor = .02;
		else
			locFactor = .04;
		
		if(history)
			rateFactor = .02;
		else
			rateFactor = .03;
		
		if(gals > 1000)
			galFactor = .02;
		else
			galFactor = .03;
		
		double suggPrice = price + locFactor + rateFactor + galFactor + profitFactor + rateFluctuation;
		double total = gals * suggPrice;
//		System.out.println(history + " " + locFactor + " " + rateFactor + " " + galFactor 
//							+ " " + profitFactor + " " + rateFluctuation + " " + suggPrice + " " + total);	
		
		test.setsuggestedPrice(suggPrice);
		test.setTotalAmountDue(total);

	//sets data for JSP file	
		request.getSession().setAttribute("PPG", suggPrice);	
		request.getSession().setAttribute("TotalDue", total);	

		// return response
		response.sendRedirect("getprice.jsp");
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
	
}
