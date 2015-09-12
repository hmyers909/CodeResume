package for_hash_set;

//Heather Myers


import java.util.*;
import java.io.*;

/**
 * The class AddressInfo creates an AddressInfo object by taking a Name object and address
 * object and constructing them into an AddressInfo object
 * @author Heather Myers
 * @author Barbara Li Santi
 *
 */
public class AddressInfo implements Comparable<AddressInfo>, Serializable {


	/**
	 * a reference to a name object
	 */
	private Name myName;//reference to the name of this contact
	/**
	 * a reference to an address object
	 */
	private Address myAddress;//reference to the address of this contact

	/**
	 * the public static final Comparator object for sorting things by address
	 * @return returns the result of the comparison
	 */
	public static final Comparator<AddressInfo> ADDRESS_COMPARATOR = 
			((aI1,aI2) -> {
				return resultForComparator(aI1, aI2);
			});
	
	/**
	 * a method to calculate the result of the comparator
	 * @param aI1 the first AddressInfo object to be compared
	 * @param aI2 the second AddressInfo object to be compared
	 * @return an int which represents whether one was greater than the other
	 */
	private static int resultForComparator(AddressInfo aI1, AddressInfo aI2){
		int result = aI1.myAddress.compareTo(aI2.myAddress);
		if(result != 0){
			return result;
		}//if addresses are not the same
		return aI1.myName.compareTo(aI2.myName);		
	}//resultForComparator

	/**
	 * an 8 parameter constructor for an AddressInfo object
	 * @param theFirst a string of the first name
	 * @param theMiddle a string of the middle name
	 * @param theFamily a string of the last name
	 * @param theStreet a string of the street
	 * @param theOptional a string of the optional second street line
	 * @param theCity a string of the city
	 * @param theState a string of the state
	 * @param theZip a string of the zipcode
	 */
	public AddressInfo(String theFirst, String theMiddle, String theFamily, String theStreet,
			String theOptional, String theCity, String theState, String theZip) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address(theStreet, theOptional, theCity, theState,theZip);
	}// 8 parameter constructor

	/**
	 * a 7 parameter constructor for an AddressInfo object
	 * @param theFirst a string of the first name
	 * @param theMiddle a string of the middle name
	 * @param theFamily a string of the last name
	 * @param theStreet a string of the street
	 * @param theCity a string of the city
	 * @param theState a string of the state
	 * @param theZip a string of the zipcode
	 */
	public AddressInfo(String theFirst, String theMiddle, String theFamily, String theStreet,
			String theCity, String theState, String theZip) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address(theStreet, theCity, theState,theZip);
	}// 7 parameter constructor

	/**
	 * a 3 parameter constructor for an AddressInfo object
	 * @param theFirst a string of the first name
	 * @param theMiddle a string of the middle name
	 * @param theFamily a string of the last name
	 */
	public AddressInfo(String theFirst, String theMiddle, String theFamily) {
		myName = new Name(theFirst, theMiddle, theFamily);
		myAddress = new Address();
	}// 2 parameter constructor

	/**
	 * a method to get theName from the AddressInfo object
	 * @return returns the name
	 */
	public Name getName(){
		return myName;
	}//getName

	/**
	 * a method to get the address from the AddressInfo object
	 * @return returns the address
	 */
	public Address getAddress(){
		return myAddress;
	}//getAddress

	/**
	 * a modifier method that sets the Name
	 * @param theName the Name that you want to set the name to
	 */
	public void setName(Name theName){
		myName = theName;
	}//setName

	/**
	 * a modifier method that sets the Name
	 * @param theName the Name that you want to set the name to
	 */
	public void setAddress(Address theAddress) {
		myAddress = theAddress;
	}//setAddress

	/**
	 * a toString method that returns the name and address in string form
	 */
	public String toString() {
		String addressString = myAddress.toString();
		return "\n"+ myName + (addressString.equals("") ? "" : "\n" + addressString);
	}// toString

	/**
	 * a method that checks to see if one object equals another object
	 * @return returns true if the name does equal the other, otherwise it returns false
	 */
	public boolean equals(Object theOther) {
		AddressInfo theAI = (AddressInfo) theOther;
		return myName.equals(theAI.myName);
	}// equals

	/**
	 * a method that compares two names
	 * @param theAI the AddressInfo object to be compared
	 * @return returns an int that represents whether the name was greater lesser or equal
	 */
	public int compareTo(AddressInfo theAI) {
		return myName.compareTo(theAI.myName);
	}// compareTo

	/**
	 * a method which checks to see if one name comes before the other in the alphabet
	 * @param theAI the AddressInfo to be compared
	 * @return returns true if theAI comes before myName, otherwise it returns false
	 */
	public boolean beforeAlpha(AddressInfo theAI) {
		return myName.before(theAI.myName) ;
	}// beforeAlpha

	/**
	 * a method which checks to see if one address comes before the other depending on state
	 * @param theAI the AddressInfo to be compared
	 * @return returns true if theAI comes before myAddress, otherwise it returns false
	 */
	public boolean beforeAddress(AddressInfo theAI) {
		return myAddress.before(theAI.myAddress)
				||(myAddress.equals(theAI.myAddress) 
						&& myName.before(theAI.myName));
	}// beforeAddress
	
	/**
	 * a method which helps to organize the HashSet
	 * @return returns an int that is the length of all of the names
	 */
	public int hashCode(){
		return myName.getFirst().length()+myName.getMiddle().length()+myName.getLast().length();
	}//hashCode

}//
