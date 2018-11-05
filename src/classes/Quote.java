package classes;
/**
 * @author Jordan Williamson & Michelle Pham
 *
 */

import java.sql.Date;
import org.joda.time.DateTime;

public class Quote {
	
	int clientID;
	int quoteID;
	double gallonsRequested;
	DateTime deliveryDate;
	DateTime requestDate;
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
	public DateTime getdeliveryDate() {return deliveryDate;}
	//@return the requestDate
	public DateTime getrequestDate() {return requestDate;}
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
	
	public int getQuoteID() {return quoteID;}
	
	
	//				//
	//	setters		//
	//				//
	public void setQuoteID(int quoteID) {this.quoteID = quoteID;}
	
	public void setClientID(int clientID) {this.clientID = clientID;}
	
	public void setgallonsRequested(double gallonsRequested) {this.gallonsRequested = gallonsRequested;}
	
	public void setdeliveryDate(DateTime deliveryDate) {this.deliveryDate = deliveryDate;}
	
	public void setrequestDate(DateTime requestDate) {this.requestDate = requestDate;}
	
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