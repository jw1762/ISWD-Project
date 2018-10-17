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
import classes.ClientInformation;

//This portion is currently hardcoded to return the
//values stored in ClientInformation.java,
//as we currently have no database of 
//names to pull from.
/**
 * Servlet implementation class clientServlet
 */
@WebServlet("/clientServlet")
public class clientServlet extends HttpServlet {
       
	private static final long serialVersionUID = -7419930036249986454L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientInformation test = new ClientInformation();
				
		//sets input from form fields
		test.setName("John Placeholder"); //replace hard codes with request.getParameter("name") to get the input from form
		test.setAddress("555");
		test.setEmail("5@555.com");
		test.setPhone("555-555-5555");
		test.setClientID(5);
				
		// read form fields
		String namestr = test.getName();
		String addrstr = test.getAddress();
		String emailstr = test.getEmail();
		String phonestr = test.getPhone();
		int clientid = test.getClientID();
		
        // do some processing here...
		//sets data for JSP file
		request.getSession().setAttribute("name", namestr);	
		request.getSession().setAttribute("addr", addrstr);	
		request.getSession().setAttribute("email", emailstr);	
		request.getSession().setAttribute("phone", phonestr);	
		request.getSession().setAttribute("clientid", clientid);	
				
		// return response
		response.sendRedirect("clientinfo.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				// read form fields
						        
		        // do some processing here...
		         
		        // get response writer
		         
		       // build HTML code
		       		         
		        // return response
		
		doGet(request, response);
	}
	
}