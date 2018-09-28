/**
 * @author Jordan Williamson & Michelle Pham
*/
package classes;

import java.io.IOException;
import java.io.PrintWriter;

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
       
 /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientInformation test = new ClientInformation();
		
		// read form fields
		String namestr = test.getName();
		String addrstr = test.getAddress();
		String emailstr = test.getEmail();
		String phonestr = test.getPhone();
		int clientid = test.getClientID();
		
        // do some processing here...
     		
		
		//get writer
			
		// build HTML code
		String htmlR = "<html>";
		htmlR += "Name: " + namestr + "<br>";
		htmlR += "Phone #: " + phonestr + "<br>";
		htmlR += "Address: " + addrstr + "<br>";
		htmlR += "Email: " + emailstr + "<br>";
		htmlR += "clientID: " + clientid + "<br>";		
		htmlR += "</html>";
		
		// return response
		response.getWriter().append(htmlR).append("Served at: ").append(request.getContextPath());
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