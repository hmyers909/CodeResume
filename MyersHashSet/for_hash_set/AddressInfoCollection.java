package for_hash_set;

//Heather Myers
//5/12/15
//cs 64
//Barbara Li Santi
//Final Project - HashSet

//This is a program that creates an AddressInfoCollection using a HashSet.
//It is used in conjunction with the Database.

import java.io.*;
import java.util.*;


/**
 * Employs one instance of HashSet constructed with no parameters.
 * @author Heather
 */
public class AddressInfoCollection {

	/**
	 * An instance of the HashSet class that serves as the data structure
	 * for this AddressInfoCollection
	 */
	private HashSet<AddressInfo> myHashSet; //the HashSet used to structure our data

	/**
	 * The constructor for the HashSet, it has no parameters
	 */
	public AddressInfoCollection() {
		myHashSet= new HashSet<> ();
	}//constructor

	/**
	 * Invokes the contain method on the HashSet with the argument findMe in order to 
	 * check to see if the AddressInfo object findMe is in the database.
	 * @param findMe an AddressInfo object to be searched for
	 * @return null if the object is in the HashSet, returns the current AddressInfo
	 * object if it equals findMe, or null for any other situation
	 */
	public AddressInfo search(AddressInfo findMe){
		if(!myHashSet.contains(findMe)){
			return null;
		}// no matching addressInfo object
		for (AddressInfo current : myHashSet){
			if(current.equals(findMe)){
				return current;
			}//if a match is found
		}//for
		return null;
	}//search

	/**
	 * Invokes the contains method on myHashSet to check for a duplicate
	 * record, if a duplicate is found, add returns false. If no duplicate is found then
	 * the add method is invoked on the HashSet with an argument equal to 
	 * the addMe parameter
	 * @param addMe the AddressInfo object to be searched for and added if 
	 * it is not already in the database
	 * @return false if the HashSet already contains addme, true if the object
	 * doesn't already exist
	 */
	public boolean add(AddressInfo addMe){
		if(myHashSet.contains(addMe)){
			return false;
		}//duplicate name in Collection
		return myHashSet.add(addMe);
	}//add

	/**
	 * delete method Invokes the contains method on the HashSet
	 * if the item is not in the database, it returns false, if it does exist, 
	 * then delete invokes the remove method on the hashSet using deleteMe
	 * as a parameter
	 * @param deleteMe the AddressInfo item to be searched for and deleted if
	 * it exists in the database
	 * @return false if the object doesn't exist, true if the object is removed successfully
	 */
	public boolean delete(AddressInfo deleteMe){
		if(!myHashSet.contains(deleteMe)){
			return false;
		}//cannot delete because it is not in the collection
		return myHashSet.remove(deleteMe);
	}//delete

	/**
	 * Constructs a local TreeSet named myAlpha with no argument.
	 * Invokes the addAll method on the myAlpha using the HashSet as an
	 * argument
	 * @return the string that was returned by invoking toString on the TreeSet
	 */
	public String toStringAlphabetical(){
		TreeSet <AddressInfo> myAlpha = new TreeSet<> ();
		myAlpha.addAll(myHashSet);
		return myAlpha.toString();
	}//toStringAlphabetical

	/**
	 * Constructs a local TreeSet named myAddress with the public static
	 * final Comparator object as an argument. Invokes addAll method on myAddress
	 * using the HashSet as an argument
	 * @return the string that was returned by invoking toString on the TreeSet
	 */
	public String toStringByAddress(){
		TreeSet <AddressInfo> myAddress = new TreeSet<> 
		(AddressInfo.ADDRESS_COMPARATOR);
		myAddress.addAll(myHashSet);
		return myAddress.toString();
	}//toStringByAddress

	/**
	 * saves the current HashSet to a file by invoking the iterator method on
	 * the HashSet to get an iterator object, uses a while loop with the iterator to 
	 * traverse the HashSet and writes each traversed object to the ObjectOutputStream
	 * @param fileName a string to name the file
	 * @return an empty string if all goes well, otherwise an error message is returned
	 */
	public String saveToFile(String fileName){
		String messageFromSave = "";
		try{
			ObjectOutputStream oOS = new ObjectOutputStream(new FileOutputStream(fileName));
			Iterator <AddressInfo> it = myHashSet.iterator();
			while (it.hasNext()){
				AddressInfo current = it.next();
				oOS.writeObject(current);
			}//for
			oOS.flush();
			oOS.close();
		}//try
		catch (Exception e){
			messageFromSave = e.toString();
		}//catch
		return messageFromSave;
	}//saveToFile
	

	/**
	 * Each object comes from the file and is inserted into the HashSet using the add
	 * method
	 * @param fileName the name of the file to be loaded
	 * @return empty string if all goes well, or an error if not
	 */
	public String loadFromFile(String fileName){
		String toReturn = "";
		ObjectInputStream oIS; 
		try{
			oIS = new ObjectInputStream(
					new FileInputStream(fileName));
			while(true){
				AddressInfo fromFile = (AddressInfo) oIS.readObject();
				AddressInfo found = search(fromFile);
				if(found == null) {
					myHashSet.add(fromFile);
					if(!add(fromFile)){
						toReturn += fromFile + "not added to DB.\n" ;
					}//if add failed
				} else {
					toReturn += fromFile + "not added because a duplicate name already in DB.\n";
				}//else
			}//while
		}//try
		catch (EOFException eOF){
		}//catch for all went well
		catch (Exception e){
			toReturn += e.toString() + "\n";
		}//catch anything else
		return toReturn;
	}//loadFromFile



}//AddressInfoCollection
