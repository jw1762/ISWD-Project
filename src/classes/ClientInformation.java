package classes;

/**
 * @author Jordan Williamson & Michelle Pham
Display values in UI using the model class.
*/

//Model Structure
public class ClientInformation {
	int clientID;
	String name;
	String address;
	String phone;
	String email;
	
	
	
	//				//
	//	getters		//
	//				//
	
	/** * @return the name */
	public String getName() {return name;}
	/**	 * @return the clientID	 */
	public int getClientID() {return clientID;}
	/**	 * @return the email	 */
	public String getEmail() {return email;}
	/**	 * @return the address	 */
	public String getAddress() {return address;}
	/**	 * @return the phone	 */
	public String getPhone() {return phone;}
	
	//				//
	//	setters		//
	//				//
	
	/**	 * @param clientID the clientID to set	 */
	public void setClientID(int clientID) {this.clientID = clientID;}
	/**	 * @param name the name to set	 */
	public void setName(String name) {this.name = name;}	
	/**	 * @param phone the phone to set	 */
	public void setPhone(String phone) {this.phone = phone;}
	/**	 * @param address the address to set	 */	
	public void setAddress(String address) {this.address = address;}
	/**	 * @param email the email to set * 	 */		
	public void setEmail(String email) {this.email = email;}
	
}