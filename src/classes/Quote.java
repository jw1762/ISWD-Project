package classes;

/**
 * @author Jordan Williamson & Michelle Pham
 *
 */

import java.sql.Date;

/*
?	This class will be used to receive quote request data from UI and persist to database.

o	Create a Class that will have QuoteHistory parameter as a list of Quote.
?	E.g. List <Quote> QuoteHistory = new ArrayList<Quote>();

*/


public class Quote {
	int clientID;
	double gallonsRequested;
	Date deliveryDate;
	Date requestDate;
	String deliveryZip;
	String deliveryAdr, deliveryState, deliveryCity;
	String deliveryContactName;
	String deliveryContactPhone;
	String deliveryContactEmail;
	double suggestedPrice;
	double totalAmountDue;
	
	//				//
	//	getters		//
	//				//
	//@return the clientID
	public int getClientID() {return clientID;}
	//@return the gallonsRequested;
	public double getgallonsRequested() {return gallonsRequested;}
	//@return the deliveryDate
	public Date getdeliveryDate() {return deliveryDate;}
	//@return the requestDate
	public Date getrequestDate() {return requestDate;}
	//@return the del contactName
	public String getdeliveryContactName() {return deliveryContactName;}
	//@return the deliveryLocation
	public String getdeliveryZip() {return deliveryZip;}
	
	public String getdeliveryAdr() {return deliveryAdr;}
	
	public String getdeliveryState() {return deliveryState;}
	
	public String getdeliveryCity() {return deliveryCity;}
	//@return the delContactPhone
	public String getdeliveryContactPhone() {return deliveryContactPhone;}
	//@return the delContactEmail
	public String getdeliveryContactEmail() {return deliveryContactEmail;}
	//@return getSugPrice.
	public double getsuggestedPrice() {return suggestedPrice;}
	//@return totalAmountDue.
	public double getTotalAmountDue() {return totalAmountDue;}
	
	
	//				//
	//	setters		//
	//				//
	
	public void setClientID(int clientID) {this.clientID = clientID;}
	
	public void setgallonsRequested(double gallonsRequested) {this.gallonsRequested = gallonsRequested;}
	
	public void setdeliveryDate(Date deliveryDate) {this.deliveryDate = deliveryDate;}
	
	public void setrequestDate(Date requestDate) {this.requestDate = requestDate;}
	
	public void setdeliveryZip(String deliveryZip) {this.deliveryZip = deliveryZip;}
	
	public void setdeliveryAdr(String deliveryAdr) {this.deliveryAdr = deliveryAdr;}
	
	public void setdeliveryState(String deliveryState) {this.deliveryState = deliveryState;}
	
	public void setdeliveryCity(String deliveryCity) {this.deliveryCity = deliveryCity;}

	public void setdeliveryContactName(String delContactName) {this.deliveryContactName = delContactName;}
	
	public void setdeliveryContactPhone(String delContactPhone) {this.deliveryContactPhone = delContactPhone;}
	
	public void setdeliveryContactEmail(String delContactEmail) {this.deliveryContactEmail = delContactEmail;}
	
	public void setsuggestedPrice(double suggestedPrice) {this.suggestedPrice = suggestedPrice;}
	
	public void setTotalAmountDue(double totalAmountDue) {this.totalAmountDue = totalAmountDue;}
	
	
	
	
	
}