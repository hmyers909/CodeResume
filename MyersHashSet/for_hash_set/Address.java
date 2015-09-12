package for_hash_set;

import java.io.Serializable;

//Heather Myers

/**
 * 
/**
 * The address class constructs an address object by taking 5, 4, or 0 parameters:
 * @author Heather
 *
 */
public class Address implements Comparable<Address>, Serializable  {

	/**
	 * a string reference for the street
	 */
	private String myStreet1;//a string representing the street
	/**
	 * a string reference for the optional street line
	 */
	private String myStreet2;//a string representing the optional street line
	/**
	 * a string reference for the city
	 */
	private String myCity;//a string representing the city
	/**
	 * a string reference for the state
	 */
	private String myState;//a string representing the state
	/**
	 * a string reference for the zipcode
	 */
	private String myZip;//a string representing the zip
	
	/**
	 * an array of states for the state combo box
	 */
	public static final String[] STATES = {"--","AK", "AL", "AR", "AZ", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "IA", "ID", "IL", "IN", "KS", 
		"KY", "LA", "MA", "MD", "ME", "MI", "MN", "MO", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK",
		"OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"};
	
	/**
	 * the 5 parameter constructor for the Address object
	 * @param theStreet1 - the string for the street
	 * @param theStreet2 - the string for the optional second street line
	 * @param theCity - the string for the city
	 * @param theState - the string for the state
	 * @param theZip - the string for the zip
	 */
	public Address(String theStreet1, String theStreet2, String theCity, String theState, String theZip){
		myStreet1 = theStreet1;
		myStreet2 = theStreet2;
		myCity = theCity;
		myState = theState;
		myZip = theZip;
	}// 5 parameter constructor

	/**
	 * the 4 parameter constructor for the Address object
	 * @param theStreet1 - the string for the street
	 * @param theCity - the string for the city
	 * @param theState - the string for the state
	 * @param theZip - the string for the zip
	 */
	public Address(String theStreet1, String theCity, String theState, String theZip){
		myStreet1 = theStreet1;
		myStreet2 = "";
		myCity = theCity;
		myState = theState;
		myZip = theZip;
	}// 4 parameter constructor

	/**
	 * The 0 parameter instructor for the address object
	 */
	public Address (){
		myStreet1 = "";
		myStreet2 = "";
		myCity = "";
		myState = "";
		myZip = "";
	}// 0 parameter constructor

	/**
	 * an access method for the street
	 * @return returns the string for myStreet1
	 */
	public String getStreet1(){
		return myStreet1;
	}//getStreet1

	/**
	 * an access method for the optional street line
	 * @return returns the string for myStreet2
	 */
	public String getStreet2(){
		return myStreet2;
	}//getStreet2

	/**
	 * an access method for the city
	 * @return returns the string for myCity
	 */
	public String getCity(){
		return myCity;
	}//getCity

	/**
	 * an access method for the state
	 * @return returns the string for myState
	 */
	public String getState(){
		return myState;
	}//getState

	/**
	 * an access method for the zipcode
	 * @return returns the string for myZip
	 */
	public String getZip(){
		return myZip;
	}//getZip

	/**
	 * a modifier method for the street
	 * @param theStreet1 - what you want to change the street to
	 */
	public void setStreet1(String theStreet1){
		myStreet1 = theStreet1;		
	}//setStreet1

	/**
	 * a modifier method for the optional street
	 * @param theStreet2 - what you want to change the optional street to
	 */
	public void setStreet2(String theStreet2){
		myStreet2 = theStreet2;		
	}//setStreet2

	/**
	 * a modifier method for the city
	 * @param theCity - what you want to change the city to
	 */
	public void setCity(String theCity){
		myCity = theCity;		
	}//setCity

	/**
	 * a modifier method for the state
	 * @param theState - what you want to change the state to
	 */
	public void setState(String theState){
		myState = theState;		
	}//setState

	/**
	 * a modifier method for the zipcode
	 * @param theZip - what you want to change the zip
	 */
	public void setZip(String theZip){
		myZip = theZip;		
	}//setZip

	/**
	 * a method that tells if one address is equal to the other by invoking
	 * the equals method on each of it's parameters
	 * @return returns true if it is equal, false if not
	 */
	public boolean equals(Object theOtherAd){
		Address theAddress = (Address)theOtherAd;
		return myStreet1.equals(theAddress.myStreet1)&&
				myStreet2.equals(theAddress.myStreet2)&&
				myCity.equals(theAddress.myCity)&&
				myState.equals(theAddress.myState)&&
				myZip.equals(theAddress.myZip);
	}//equals

	/**
	 * a method that compares all of the pieces of the address
	 * @return returns an int which represents whether the piece was greater than or less than
	 */
	public int compareTo (Address theAddress){
		int compareValue = myState.compareTo(theAddress.myState);
		if (compareValue!=0){
			return compareValue;
		}//States are different
		compareValue = myCity.compareTo(theAddress.myCity);
		if (compareValue!=0){
			return compareValue;
		}//Cities are different
		compareValue = myZip.compareTo(theAddress.myZip);
		if (compareValue!=0){
			return compareValue;
		}//Zips are different
		compareValue = myStreet1.compareTo(theAddress.myStreet1);
		if (compareValue!=0){
			return compareValue;
		}//Street1 is different
		return myStreet2.compareTo(theAddress.myStreet2);
	}//compareTo

	/**
	 * a method which checks to see if an address comes before another
	 * @param theAddress - the address to be checked
	 * @return true if the address does come before, false otherwise
	 */
	public boolean before (Address theAddress){
		return compareTo (theAddress)<0;
	}//before 

	/**
	 * a method which checks to see if an address comes after another
	 * @param theAddress - the address to be checked
	 * @return true if the address does come after, false otherwise
	 */
	public boolean after (Address theAddress){
		return compareTo (theAddress)>0;
	}//after

	/**
	 * a toString that returns the string as long as it's not empty
	 * @return returns the string representation of the address
	 */
	public String toString(){ //11.4
		String addressString = "";
		if(!myStreet1.equals("")) {
			addressString +=myStreet1;
		}//first if
		if(!myStreet2.equals("")){
			addressString += "\n"+ myStreet2;
		}//second if
		if(!myCity .equals ("")) {
			addressString += "\n" + myCity;
			if(!myState.equals ("") || !myZip .equals ("")) {
				addressString += ", ";
				if(!myState .equals ("")) {
					addressString += myState + " ";
				}//last if in third if
				if(!myZip .equals ("")) {
					addressString += myZip;
				}//last if
			}//second if in third if
		}//third if
		return addressString +"\n";
	}//toString

	/**
	 * the main method
	 * @param args the args for the main method
	 */
	public static void main(String[] args) {

	}//main

}//Address
