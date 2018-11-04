package classes;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import classes.ClientInformation;

@WebServlet("/UpdateClientServlet")
public class UpdateClientServlet extends HttpServlet {
    
	private static final long serialVersionUID = -7419930036249986454L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientInformation newCI = new ClientInformation();
		DatabaseCon sqlUpdate = new DatabaseCon();
		
		// read form fields
	//	String cid = request.getParameter("cid");
		String name = request.getParameter("name");
		String adr = request.getParameter("adr");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		newCI.setAddress(adr);
	//	int id = Integer.parseInt(cid);
	//	newCI.setClientID(id);
		newCI.setName(name);
		newCI.setEmail(email);
		newCI.setPhone(phone);
		
		newCI.setCity(city);
		newCI.setState(state);
		int intzip = Integer.parseInt(zip);
		newCI.setZip(intzip);
		
     // do some processing here...
		//sets data for JSP file
		request.getSession().setAttribute("name", name);	
		request.getSession().setAttribute("adr", adr);	
		request.getSession().setAttribute("city", city);	
		request.getSession().setAttribute("state", state);
		request.getSession().setAttribute("zip", zip);	
		request.getSession().setAttribute("email", email);	
		request.getSession().setAttribute("phone", phone);	
				
		//JDBC Response
		//Send ClientInfo obj to DatabaseCon obj function to insert into DB
		
		try {
			sqlUpdate.sendClientSQL(newCI);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cid = sqlUpdate.getClientID(name);
		request.getSession().setAttribute("cid", cid);
		// return response
		response.sendRedirect("updateclientinfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		doGet(request, response);
	}
	
}