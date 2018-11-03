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
	String city, state;
	int zip;
	
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
	public String getCity() {return city;}
	public String getState() {return state;}
	public int getZip() {return zip; }
	
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
	public void setCity(String city) {this.city = city;};
	public void setState(String state) {this.state = state;};
	public void setZip(int zip ) {this.zip = zip;}
	
}