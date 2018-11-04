package classes;

/**
 * @author Jordan Williamson & Michelle Pham
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//
//Servlet implementation class AllClientServlet
//
@WebServlet("/AllClientServlet")
public class AllClientServlet extends HttpServlet 
{
	private static final long serialVersionUID = -7419930036249986454L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		DatabaseCon dbQuery = new DatabaseCon();
		AllClientViewer clients = dbQuery.getAllClients();
		request.getSession().setAttribute("clientList", clients.AllClient);
		response.sendRedirect("allclientinfo.jsp");
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		doGet(request, response);
	}
}