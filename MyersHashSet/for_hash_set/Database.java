package for_hash_set;

//Heather Myers
//5/13/15
//CS 64
//Barbara Li Santi
//Final Project - TreeSet

//This program is a "database" of names and addresses called records. You can add records, delete them,
//sort them alphabetically or by address. 

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.*;  
import javax.swing.text.JTextComponent;

/**
 * an application program that allows the user to maintain a simple file oriented database
 * of address information
 * @author Heather
 *
 * @param <E> allows the database to use generic objects
 */
public class Database <E> extends JFrame {

	/**
	 * A label to tell the user to input a first name in the text field
	 */
	private JLabel firstL; // label for first name TF
	/**
	 * A label to tell the user to input a middle name in the text field
	 */
	private JLabel middleL; // label for middle name TF
	/**
	 * A label to tell the user to input a last name in the text field
	 */
	private JLabel lastL; //label for last name TF
	/**
	 * A label to tell the user to input a street in the text field
	 */
	private JLabel streetL; //label for street TF
	/**
	 * A label to tell the user to input a optional street line in the text field
	 */
	private JLabel street2L; //label for optional street line
	/**
	 * A label to tell the user to input a city in the text field
	 */
	private JLabel cityL; //label for city TF
	/**
	 * A label to tell the user to select a state from the combo box
	 */
	private JLabel stateL; // label for state combo box
	/**
	 * A label to tell the user to input a zip code in the text field
	 */
	private JLabel zipL; //label for zip TF

	/**
	 * a button to add the inputs from the TFs to the database
	 */
	private JButton addB; //a button to add the inputs to the database
	/**
	 * a button to display the database's items alphabetically
	 */
	private JButton alphaB; // a button to show the alphabetized items
	/**
	 * a button to display the database's items by address
	 */
	private JButton sortB; //a button to sort the items by address
	/**
	 * a button to request a deletion of the item input in the TFs
	 */
	private JButton deleteB; // a button to delete items
	/**
	 * a button to confirm whether the user would like to delete an item
	 */
	private JButton confirmdB; // a button to confirm the deletion
	/**
	 * a button to cancel a deletion
	 */
	private JButton canceldB; //a button to cancel the deletion
	/**
	 * a button to search for an item input in the TFs
	 */
	private JButton searchB; //a button to search for a name input
	/**
	 * A button to save the database to a file
	 */
	private JButton saveB; //a button to save the database to a file
	/**
	 * a button to load a file to the database after a filename has been input in the saveTF
	 */
	private JButton loadB; //a button to load files to the database
	/**
	 * a cancel button for save in case they don't want to overwrite an existing file
	 */
	private JButton saveCancelB; //a button to cancel a save if the file already exists
	/**
	 * a confirm button if the user would like to overwrite a file that already exists
	 */
	private JButton saveConfirmB;  // a button to confirm the overwrite of a file already saved

	/**
	 * a text field for the user to input the first name of the addressInfo
	 */
	private JTextField firstTF; //a text field to input the first name
	/**
	 * a text field for the user to input the last name of the addressInfo
	 */
	private JTextField middleTF; // a text field to input the middle name
	/**
	 * a text field for the user to input the middle name of the addressInfo
	 */
	private JTextField lastTF; //a text field to input a last name
	/**
	 * a text field for the user to input the street of the addressInfo
	 */
	private JTextField streetTF; //a text field to input the street
	/**
	 * a text field for the user to input the optional street line of the addressInfo
	 */
	private JTextField street2TF; //a TF to input the optional street line
	/**
	 * a text field for the user to input the city of the addressInfo
	 */
	private JTextField cityTF; //a TF to input the city
	/**
	 * a text field for the user to input the zip code of the addressInfo
	 */
	private JTextField zipTF; //a TF to input the zipcode
	/**
	 * a text field for the user to recieve error messages
	 */
	private JTextField errorTF; //a TF to display errors to the user
	/**
	 * a text field for the user to input the name of a file to load or save
	 */
	private JTextField saveInputTF; // a TF to input filenames to save or load
	
	/**
	 * a text area for the user to see what's in the database 
	 */
	private JTextArea displayTA; // declare a reference to a text area object 
	// where things will be displayed for the user
	
	/**
	 * a scroll pane for the TextArea
	 */
	private JScrollPane displaySP; // declare a reference to a scroll pane object 
	// that controls the text area

	/**
	 * a comboBox dropdown menu with the states in it as options
	 */
	private  JComboBox stateCB;//a combo box to hold the states in
	
	/**
	 * holds a reference to the content pane for the GUI
	 */
	private Container myCP; // hold a reference to the content pane so that 
	// getContentPane() is only done once

	/**
	 * a boolean to keep track of the deletion process
	 */
	public boolean deleteYN=false; // a boolean to control whether delete should be performed
	
	/**
	 * a boolean to keep track of the save process
	 */
	public boolean saveFileYN =false;// a boolean to control the save button

/**
 * an object of class AddressInfoCollection which is called myAICollection, it is
 * a class that creates the underlying data structure of the application
 */
	private AddressInfoCollection myAICollection = new AddressInfoCollection();
	//the AddressInfoCollection that organizes the data structure
	
	/**
	 * an AddressInfo object to help with the deletion process
	 */
	private AddressInfo found;
	//an AddressInfo object to help delete items from the database


	/**
	 * a method to construct all of the labels and text fields for the GUI
	 * it invokes the makeTextField and makeLabel methods on the UtilityMethods class
	 * and the arguments are as follows:
	 * for makeLabel: int theX, int theY, int theWidth, int theHeight, String theText, boolean theOpaque, Color theColor, 
			Container theCP
		for makeTextField: int theX, int theY, int theWidth, int theHeight, boolean theOpaque, boolean theEnabler, 
			boolean theEdit, String theText, Container theCP
	 */
	public void makeLabelsAndTFs(){
		firstL = UtilityMethods.makeLabel(10,20,80,30, "First Name:", true, Color.gray, myCP);
		firstTF = UtilityMethods.makeTextField(100,20,100,30, true, true, true, "",myCP);
		middleL = UtilityMethods.makeLabel(220,20,80,30, "Middle Name:", true, Color.gray, myCP);
		middleTF = UtilityMethods.makeTextField(320,20,100,30, true, true,true,"", myCP);
		lastL = UtilityMethods.makeLabel(440,20,80,30, "Last Name:", true, Color.gray, myCP);
		lastTF = UtilityMethods.makeTextField(540,20,100,30, true, true,true,"", myCP);
		streetL = UtilityMethods.makeLabel(10,70,80,30, "Street:", true, Color.gray, myCP);
		streetTF = UtilityMethods.makeTextField(100,70,200,30, true, true,true, "",myCP);
		street2L = UtilityMethods.makeLabel(320,70,100,30, "Street (optional):", true, Color.gray, myCP);		
		street2TF = UtilityMethods.makeTextField(440,70,200,30, true, true,true,"", myCP);
		cityL = UtilityMethods.makeLabel(10,120,80,30, "City:", true, Color.gray, myCP);
		cityTF = UtilityMethods.makeTextField(100,120,100,30, true, true, true,"", myCP);	
		stateL = UtilityMethods.makeLabel(220,120,80,30, "State:", true, Color.gray, myCP);
		stateCB = UtilityMethods.makeComboBox(Address.STATES, 320,120,100,30, myCP);
		zipL = UtilityMethods.makeLabel(440,120,80,30, "Zip:", true, Color.gray, myCP);
		zipTF = UtilityMethods.makeTextField(540,120,100,30, true, true, true,"", myCP);	
		errorTF = UtilityMethods.makeTextField(20,220,620,30, true, true, false,"", myCP);	
	}//make labels and TFs

	/**
	 * a method to create the buttons, it invokes the makeButton method on the UtilityMethods
	 * class, the arguements are as follows: int theX, int theY, int theWidth, int theHeight, String theText, Color theColor, ActionListener theHandler,
			Container theCP, boolean theEnabler
	 */
	public void makeButtons() {
		addB = UtilityMethods.makeButton(140, 170, 150, 30, "Add Record", Color.BLACK,
				(e)->stepsForAdd(), myCP, true);
		searchB = UtilityMethods.makeButton(400, 170, 150, 30, "Search for a Record", Color.BLACK,
				(e)->stepsForSearch(), myCP, true);
		alphaB = UtilityMethods.makeButton(140, 320, 150, 30, "Display by Alpha", Color.BLACK,
				(e)->stepsForAlpha(), myCP, true);
		sortB = UtilityMethods.makeButton(400, 320, 150, 30, "Display by Address", Color.BLACK,
				(e)->stepsForASort(), myCP, true);
		deleteB = UtilityMethods.makeButton(20, 270, 150, 30, "Delete", Color.BLACK,
				(e)->stepsForDelete(), myCP, true);
		confirmdB = UtilityMethods.makeButton(270, 270, 150, 30, "Delete Confirm", Color.BLACK,
				(e)->stepsForConfirm(), myCP, false);
		canceldB = UtilityMethods.makeButton(490, 270, 150, 30, "Delete Cancel", Color.BLACK,
				(e)->stepsForCancel(), myCP, false);
		saveB = UtilityMethods.makeButton(20, 370, 150, 30, "Save", Color.BLACK,
				(e)->stepsForSave(), myCP, true);
		loadB = UtilityMethods.makeButton(490, 420, 150, 30, "Load", Color.BLACK,
				(e)->stepsForLoad(), myCP, true);
		saveCancelB = UtilityMethods.makeButton(270, 370, 150, 30, "Save Confirm", Color.BLACK,
				(e)->stepsForSaveConfirm(), myCP, false);
		saveConfirmB = UtilityMethods.makeButton(490, 370, 150, 30, "Save Cancel", Color.BLACK,
				(e)->stepsForSaveCancel(), myCP, false);
		saveInputTF = UtilityMethods.makeTextField(20,420,400,30, true, true, true,
				"To save or load insert filename here.", myCP);	
		displayTA = UtilityMethods.makeTextArea(false, 20, 500, 620, 230, myCP);
	}//make buttons


	/**
	 * constructs the GUI for database
	 */
	public Database() {
		super("Database");
		setSize(680,800);
		myCP = getContentPane();
		myCP.setLayout(null);
		myCP.setBackground(Color.gray);

		makeLabelsAndTFs(); //constructs all of the labels and TFs
		makeButtons();//constructs all of the buttons

		setVisible(true);		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}//windowClosing
		}); //end of definition of WindowAdapter and semicolon to end the line 
	} //constructor


	/**
	 * the button handler for the add button, it gets the text from the user's input,
	 * does a comparison to make sure all of the required information has been provided
	 * and sets the background to red if it hasn't been provided, when the information is provided,
	 * the TF is turned white again, once all of the relevant information has been provided, 
	 * the search method is invoked on the AICollection using the
	 * newly constructed AddressInfo object as a parameter, if the search returns false, an attempt
	 * is made to add the object to the database by invoking add on the AICollection using the 
	 * AddressInfo object as a parameter then displays the collection
	 */
	private void stepsForAdd(){
		errorTF.setText("");
		String f=firstTF.getText(); 
		String m =middleTF.getText();
		String l =lastTF.getText();
		String s =streetTF.getText();
		String s2 = street2TF.getText();
		String c =cityTF.getText();
		Object st = stateCB.getSelectedItem();
		String z =zipTF.getText();
		if (f.equals("")||m.equals("")||l.equals("")||s.equals("")||c.equals("")
				||st.equals("")||st.equals("--")||z.equals("")){
			errorTF.setText("Please include a first, middle and last name, as well as a street,"
					+ " state, city and zipcode.");
			if (f.equals("")){
				firstTF.setBackground(Color.RED);
			}//if for first name
			if (m.equals("")){
				middleTF.setBackground(Color.RED);
			}// if for middle name
			if (l.equals("")){
				lastTF.setBackground(Color.RED);
			}//if for last name
			if (s.equals("")){
				streetTF.setBackground(Color.RED);
			}//if for street
			if (c.equals("")){
				cityTF.setBackground(Color.RED);
			}//if for city
			if (st.equals("")^st.equals("--")){
				stateCB.setBackground(Color.RED);
			}//if for state
			if (z.equals("")){
				zipTF.setBackground(Color.RED);
			}//if for zip
			if (!f.equals("")){
				firstTF.setBackground(Color.WHITE);
			}//if for first name
			if (!m.equals("")){
				middleTF.setBackground(Color.WHITE);
			}// if for middle name
			if (!l.equals("")){
				lastTF.setBackground(Color.WHITE);
			}//if for last name
			if (!s.equals("")){
				streetTF.setBackground(Color.WHITE);
			}//if for street
			if (!c.equals("")){
				cityTF.setBackground(Color.WHITE);
			}//if for city
			if (!st.equals("")^st.equals("--")){
				stateCB.setBackground(Color.WHITE);
			}//if for state
			if (!z.equals("")){
				zipTF.setBackground(Color.WHITE);
			}//if for zip
			return;
		}//very first if
		AddressInfo toBeAdded = new AddressInfo(f,m,l,s,s2,c,st+"",z);
		if (myAICollection.search(toBeAdded)==null){
			if(myAICollection.add(toBeAdded)){
				makeTFsWhite();
				setAllTheTFs();
				errorTF.setText("Add successful.");
				displayTA.setText("");
				displayTA.append("\n"+ myAICollection.toStringAlphabetical()+"\n"+"\n");
			}//if add succeeded
		}else{
			errorTF.setText("This record already exists. Add failed.");
			setAllTheTFs();
		}//else if
	}//stepsForAdd


	/**
	 * a button handler for the search button, it resets the 
	 * error message TF, then it constructs and Address info object with three 
	 * parameters, it searches for the object and if it is found it is displayed, otherwise
	 * it displays an error message in the errorTF
	 */
	private void stepsForSearch(){
		errorTF.setText("");
		String f=firstTF.getText(); 
		String m =middleTF.getText();
		String l =lastTF.getText();
		AddressInfo toBeFound = new AddressInfo (f,m,l);
		if (myAICollection.search(toBeFound)!=null){
			displayTA.setText("");
			displayTA.append("\n"+ myAICollection.search(toBeFound).toString()+"\n");
			setAllTheTFs();
		}else{
			setAllTheTFs();
			displayTA.setText("");
			errorTF.setText("That record was not found.");
		}//else
	}//stepsForSearch

	/**
	 * a button handler for the alphabetize button, it resets the errorTF and the displayTA,
	 * then it displays the AICollection by invoking the toStringAlphabetical method on 
	 * the AICollection
	 */
	private void stepsForAlpha(){
		errorTF.setText("");
		displayTA.setText("");
		displayTA.append("\n" + myAICollection.toStringAlphabetical()+"\n");
	}//stepsForAlpha

	/**
	 * a button handler for the alphabetize button, it resets the errorTF and the displayTA,
	 * then it displays the AICollection by invoking the toStringByAddress method on 
	 * the AICollection
	 */
	private void stepsForASort(){
		errorTF.setText("");
		displayTA.setText("");
		displayTA.append("\n" + myAICollection.toStringByAddress() +"\n");
	}//stepsForASort

	/**
	 * A button handler for the delete button, it resets the errorTF and displayTA,
	 * then it constructs an AddressInfo object with three parameters, then it invokes the 
	 * search method on the AICollection using the object as a parameter. 
	 * if it is found, then the GUI is disabled and the user is asked if they would like to
	 * confirm or cancel, otherwise an error is given. 
	 */
	private void stepsForDelete(){
		errorTF.setText("");
		displayTA.setText("");
		String f=firstTF.getText(); 
		String m =middleTF.getText();
		String l =lastTF.getText();
		AddressInfo deleteMe = new AddressInfo (f,m,l);
		found = myAICollection.search(deleteMe);
		if (found!=null){
			displayTA.append("\n"+ found+"\n");
			errorTF.setText("Are you sure you want to delete? Please confirm or cancel.");
			disableGUI();
			deleteYN = true;
		}else{
			errorTF.setText("That record was not found.");
		}//else
	}//stepsForDelete

	/**
	 * a button handler for the delete confirm button, it first resets the GUI
	 * if the user input something that could be deleted,
	 * then this button will be enabled, if pressed, this button will invoke the 
	 * delete method on the AICollection using the found AddressInfo object
	 * the user will be informed of their success  and the GUI will be reset, 
	 * otherwise and error will be given and the GUI will be reset
	 */
	private void stepsForConfirm(){
		errorTF.setText("");
		resetGUI();
		if (deleteYN=true){
			if (myAICollection.delete(found)){
				errorTF.setText("Delete successful.");
				displayTA.setText("");
				deleteYN=false;
				setAllTheTFs();
			}else {
				errorTF.setText("There was an error or the record wasn't found.");
				deleteYN=false;
				setAllTheTFs();
				resetGUI();
			}//else if
		}else{
			return;
		}//else
	}//stepsForConfirm
	
	/**
	 * A button handler for the delete cancel button, it will reset the errorTF and the GUI
	 * An error will display informing that the delete was cancelled.
	 */
	private void stepsForCancel(){
		errorTF.setText("");
		resetGUI();
		setAllTheTFs();
		errorTF.setText("Delete Cancelled.");
		displayTA.setText("");
		deleteYN=false;
	}//stepsForCancel
	
	/**
	 * A button handler for the save button, if a filename hasn't been provided, in the saveInputTf
	 * then an error will be given, otherwise, it checks to make sure the datafile doesn't already
	 * exist, and it checks to make sure it isn't a directory and it can be written, if this is all true then
	 * it will try to perform the save, if it already exists, then it will ask if it's okay to overwrite the file
	 */
	private void stepsForSave(){
		saveInputTF.setBackground(Color.white);
		errorTF.setText("");
		String msg;
		String msgAd;
		if (saveInputTF.getText().equals("")||saveInputTF.getText().equals("To save or load insert filename here.")){
			errorTF.setText("Please insert a filename in the text field below");
			saveInputTF.setBackground(Color.red);
			return;
		}//if there is an empty string or no input
		String userInput = saveInputTF.getText();
		File dataFile = new File (userInput);
		if(!dataFile.exists()) {
			msg = myAICollection.saveToFile(userInput);
			errorTF.setText("Data saved to file "+ userInput +".\n"+ msg+"\n");
			saveInputTF.setText("");
		} else if (dataFile.isDirectory()){
			errorTF.setText("Error: " + userInput + " is a directory.\n");
		} else if (!dataFile.canWrite()){
			errorTF.setText("Cannot write to " + userInput+ ".\n");
		}else {
			saveConfirmB.setEnabled(true);
			saveCancelB.setEnabled(true);
			saveFileYN =true;
			errorTF.setText( dataFile.getName() + " exists, confirm save to overwrite the file or cancel.\n" );
		}//else
	}//stepsForSave

	/**
	 * If the user puts in a filename that already exists, this button will be enabled, if pressed,
	 * this button will go through with the save
	 */
	private void stepsForSaveConfirm(){
		if (saveFileYN==true){
			String userInput = saveInputTF.getText();
			File dataFile = new File (userInput);
			String msg;
			msg = myAICollection.saveToFile(userInput);
			errorTF.setText("Data saved to file "+ userInput +".\n"+ msg+"\n");
			saveConfirmB.setEnabled(false);
			saveCancelB.setEnabled(false);
			saveFileYN =false;
			saveInputTF.setText("");
		}//if
	}//stepsForSaveConfirm
	
	/**
	 * a button handler for the ForSaveCancel button, it will be enabled if the user
	 * put in a file name that already exists. The user will have a chance to cancel if 
	 * they do not want the file overwritten. 
	 */
	private void stepsForSaveCancel(){
		errorTF.setText("");
		saveInputTF.setText("");
		saveConfirmB.setEnabled(false);
		saveCancelB.setEnabled(false);
		saveFileYN =false;
	}//stepsForSaveCancel

	/**
	 * a button handler for the load button, if the user hasn't put in a file name
	 * then it gives an error, otherwise it checks to make sure that the file exists
	 * and can be read, if that's true then it invokes the loadFromFile method on 
	 * theAICollection using the filename as a parameter otherwise it gives an error
	 */
	private void stepsForLoad(){
		errorTF.setText("");
		saveInputTF.setBackground(Color.white);
		String fileName = saveInputTF.getText();
		if (fileName.equals("To save or load insert filename here.")){
			errorTF.setText("Please insert filename in the text field below to load file.");
			saveInputTF.setBackground(Color.red);
			return;
		}//if
		if(fileName.compareTo("")>0){
			File theFile = new File (fileName);
			if (!theFile.exists()){
				errorTF.setText(fileName + " does not exist, and can't be loaded.\n");
			}else if (!theFile.canRead()){
				errorTF.setText("Can't read from " +fileName+".\n");
			}else{
				String fromLoad = myAICollection.loadFromFile(fileName);
				errorTF.setText("Data loaded from file "+ fileName+"\n"+fromLoad+"\n");
			}//else
			saveInputTF.setText("");
		}else{
			errorTF.setText("Please enter a file name to load in the text field below.");
			saveInputTF.setBackground(Color.red);
		}//else
	}//stepsForLoad

	/**
	 * a method to disable the GUI when delete is being processed
	 */
	public void disableGUI(){
		confirmdB.setEnabled(true);
		canceldB.setEnabled(true);
		addB.setEnabled(false);
		alphaB.setEnabled(false);
		sortB.setEnabled(false);
		deleteB.setEnabled(false);
		saveB.setEnabled(false);
		loadB.setEnabled(false);
		searchB.setEnabled(false);
		firstTF.setEnabled(false);
		middleTF.setEnabled(false);
		lastTF.setEnabled(false);
		streetTF.setEnabled(false);
		street2TF.setEnabled(false);
		cityTF.setEnabled(false);
		zipTF.setEnabled(false);
		stateCB.setEnabled(false);
	}//disableGUI

	/**
	 * a method to reset the GUI after the delete has been processed.
	 */
	public void resetGUI(){
		confirmdB.setEnabled(false);
		canceldB.setEnabled(false);
		addB.setEnabled(true);
		alphaB.setEnabled(true);
		sortB.setEnabled(true);
		deleteB.setEnabled(true);
		saveB.setEnabled(true);
		loadB.setEnabled(true);
		searchB.setEnabled(true);
		firstTF.setEnabled(true);
		middleTF.setEnabled(true);
		lastTF.setEnabled(true);
		streetTF.setEnabled(true);
		street2TF.setEnabled(true);
		cityTF.setEnabled(true);
		zipTF.setEnabled(true);
		stateCB.setEnabled(true);
	}//resetGUI
	
	/**
	 * a method to set all of the textfields to empty strings
	 */ 
	public void setAllTheTFs(){
		firstTF.setText("");
		middleTF.setText("");
		lastTF.setText("");
		streetTF.setText("");
		street2TF.setText("");
		cityTF.setText("");
		zipTF.setText("");
		stateCB.setSelectedItem("--");
	}//setAllTheTFs

	/**
	 * a method to set all of the text fields white after the user caused an error
	 */
	public void makeTFsWhite(){
		firstTF.setBackground(Color.WHITE);
		middleTF.setBackground(Color.WHITE);
		lastTF.setBackground(Color.WHITE);
		streetTF.setBackground(Color.WHITE);
		stateCB.setBackground(Color.WHITE);
		cityTF.setBackground(Color.WHITE);
		zipTF.setBackground(Color.WHITE);
	}//makeTFsWhite
	
	/**
	 * The main method
	 * @param args the args for the main method
	 */
	public static void main (String args[]){
		Database myAppF = new Database();

	}//main

}//Database
