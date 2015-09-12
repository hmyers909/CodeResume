package for_hash_set;

import java.io.Serializable;

//Heather Myers

/**
 * The name class constructs a name object by taking three or two parameters:
 * the first, middle and last name, or just first and last, it has two constructors.
 * @author Heather
 *
 */
public class Name implements Comparable<Name>, Serializable {
	/**
	 * the string for the first name
	 */
	private String myFirst;
	/**
	 * the string for the middle name
	 */
	private String myMiddle;
	/**
	 * the string for the last name
	 */
	private String myLast;


	/**
	 * the 3 parameter constructor for the Name class
	 * @param theFirst a string for the first name
	 * @param theMiddle a string for the middle name
	 * @param theLast a string for the last name
	 */
	public Name(String theFirst,String theMiddle, String theLast){
		myFirst = theFirst;
		myMiddle = theMiddle;
		myLast = theLast;
	}// 3 parameter constructor
	
	/**
	 * the 2 parameter constructor for the Name class
	 * @param theFirst a string for the first name
	 * @param theLast a string for the last name
	 */
	public Name (String theFirst, String theLast){
		myFirst = theFirst;
		myMiddle = "";
		myLast = theLast;
	}//2 parameter constructor

	/**
	 * a method to get the first name
	 * @return the string myFirst
	 */
	public String getFirst(){
		return myFirst;
	}//getFirst
	
	/**
	 * a method to get the middle name
	 * @return the string myMiddle
	 */
	public String getMiddle(){//11.1
		return myMiddle;
	}//getMiddle

	/**
	 * a method to get the last name
	 * @return the string myLast
	 */
	public String getLast(){//11.1
		return myLast;
	}//getLast

	/**
	 * a method to set the first name
	 * @param theFirst a string that you want to set the first name to
	 */
	public void setFirst(String theFirst){
		myFirst = theFirst;		
	}//setFirst

	/**
	 * a method to set the middle name
	 * @param theMiddle a string that you want to set the middle name to
	 */
	public void setMiddle(String theMiddle){//11.1
		myMiddle = theMiddle;
	}//setMiddle

	/**
	 * a method to set the last name
	 * @param theLast a string that you want to set the last name to
	 */
	public void setLast(String theLast){//11.1
		myLast = theLast;
	}//setLast


	/**
	 * a method to compare two name objects
	 * @return returns an int that denotes whether one object was greater or lesser than another
	 */
	public int compareTo (Name theName){
		int compareValue = myLast.compareTo(theName.myLast);
		if (compareValue!=0){
			return compareValue;
		}//last names are different
		compareValue = myFirst.compareTo(theName.myFirst);
		if (compareValue!=0){
			return compareValue;
		}//First names are different
		//compare the middle names and return whatever you get
		return myMiddle.compareTo(theName.myMiddle);
	}//compareTo

	/**
	 * a method to tell if one object is equal to the other
	 * @return returns true if all three names are equal to the other names
	 */
	public boolean equals(Object theOther){
		Name theName = (Name)theOther;
		return myFirst.equals(theName.myFirst)&&
				myMiddle.equals(theName.myMiddle)&&
				myLast.equals(theName.myLast);
	}//equals

	/**
	 * a method that returns a boolean if the name comes before a compared name
	 * @param theName the name to be compared
	 * @return true if the name is less than 0 when compare returns its int, false otherwise
	 */
	public boolean before (Name theName){//11.2
		return compareTo (theName)<0;
	}//before 

	/**
	 * a method that returns a boolean if the name comes after a compared name
	 * @param theName the name to be compared
	 * @return true if the name is greater than 0 when compare returns its int, false otherwise
	 */
	public boolean after (Name theName){//11.3
		return compareTo (theName)>0;
	}//after
	

	/**
	 * A method that constructs a string out of the names
	 * @return returns the name in string form
	 */
	public String toString(){ //11.4
		return myLast + ", " + myFirst + (myMiddle=="" ? "" : " " + myMiddle) ;
	}//toString

	

}//Name
