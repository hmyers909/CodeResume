package for_hash_set;

import java.awt.*;
import java.awt.event.*;
import java.util.Comparator;

import javax.swing.*; 

//Heather Myers
//5/13/15
//CS 64
//Barbara Li Santi
//Final Project

/**
 * A class to assist in constructing a GUI, including buttons, text fiels, labels, text areas and more
 * @author Heather Myers
 *
 */
public class UtilityMethods {

	/**
	 * a method to construct a button
	 * @param theX an int to say where the button should go on the x axis
	 * @param theY an int to say where the button should go on the y axis
	 * @param theWidth an int to denote the width of the button
	 * @param theHeight an int to denote the height of the button
	 * @param theText a string to denote what the button should say
	 * @param theColor the color of the button
	 * @param theHandler the ActionListener of the button
	 * @param theCP the container
	 * @param theEnabler a boolean for whether the button should be enabled or not
	 * @return returns the button 
	 */
	public static JButton makeButton(int theX, int theY, int theWidth, int theHeight, String theText, Color theColor, ActionListener theHandler,
			Container theCP, boolean theEnabler){
		JButton toReturn = new JButton(theText);
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setForeground(theColor);
		toReturn.setEnabled(theEnabler);
		theCP.add(toReturn);
		toReturn.addActionListener(theHandler);
		return toReturn;
	}// 9 parameter makeButton
	
	/**
	 * a method to contruct a text field
	 * @param theX an int to say where the TF should go on the x axis
	 * @param theY an int to say where the TF should go on the y axis
	 * @param theWidth an int to denote the width of the TF
	 * @param theHeight an int to denote the height of the TF
	 * @param theOpaque a boolean to control the opacity of the TF
	 * @param theEnabler a boolean to control whether the TF is enabled
	 * @param theEdit a boolean to control the editable state of the TF
	 * @param theText a string to control what the TF says
	 * @param theCP the container
	 * @return returns the textfield
	 */
	public static JTextField makeTextField (int theX, int theY, int theWidth, int theHeight, boolean theOpaque, boolean theEnabler, 
			boolean theEdit, String theText, Container theCP){
		JTextField toReturn = new JTextField();
		toReturn.setSize(theWidth, theHeight);
		toReturn.setLocation(theX, theY);
		toReturn.setOpaque(theOpaque);
		toReturn.setEnabled(theEnabler);
		toReturn.setEditable(theEdit);
		toReturn.setText(theText);
		theCP.add(toReturn);
		return toReturn;
	}// 8 parameter makeTextField
	
	/**
	 * a method to construct a label
	 * @param theX an int to say where the label should go on the x axis
	 * @param theY an int to say where the label should go on the y axis
	 * @param theWidth an int to denote the width of the label
	 * @param theHeight an int to denote the height of the label
	 * @param theOpaque a boolean to control the opacity of the label
	 * @param theText a string to control what the label says
	 * @param theColor the color of the label
	 * @param theCP the container
	 * @return returns the label
	 */
	public static JLabel makeLabel (int theX, int theY, int theWidth, int theHeight, String theText, boolean theOpaque, Color theColor, 
			Container theCP){
		JLabel toReturn = new JLabel();
		toReturn.setSize(theWidth, theHeight);
		toReturn.setText(theText);
		toReturn.setLocation(theX, theY);
		toReturn.setBackground(theColor);
		toReturn.setOpaque(theOpaque);
		theCP.add(toReturn);
		return toReturn;
	}// 7 parameter makeLabel

	/**
	 * a method to construct a text area
	 * @param theEdit a boolean to control whether the text area is editable
	 * @param theX an int to say where the TA should go on the x axis
	 * @param theY an int to say where the TA should go on the y axis
	 * @param theWidth an int to denote the width of the TA
	 * @param theHeight an int to denote the height of the TA
	 * @param theCP the container
	 * @return  returns the text area
	 */
	public static JTextArea makeTextArea (boolean theEdit, int theX, int theY, int theWidth, int theHeight, Container theCP){
		JTextArea toReturn = new JTextArea(); 
		toReturn.setEditable(theEdit);
		JScrollPane toReturnSP = new JScrollPane(toReturn,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		toReturnSP.setLocation(theX, theY);
		toReturnSP.setSize(new Dimension(theWidth, theHeight));
		theCP.add(toReturnSP); 
		return toReturn;
	}// 6 parameter makeTextArea

	
	/**
	 * a method to construct a Combo Box
	 * @param theArray an array of string objects which will be options in the combo box
	  * @param theX an int to say where the TA should go on the x axis
	 * @param theY an int to say where the TA should go on the y axis
	 * @param theWidth an int to denote the width of the TA
	 * @param theHeight an int to denote the height of the TA
	 * @param theCP the container
	 * @return retuns the combo box
	 */
	public static JComboBox makeComboBox (String[] theArray, int theX, int theY, int theWidth, int theHeight, Container theCP){
		JComboBox toReturn = new JComboBox(theArray);
		toReturn.setLocation(theX, theY);
		toReturn.setSize(theWidth, theHeight);
		theCP.add(toReturn);
		return toReturn;
	}//6 parameter JComboBox
	
//These never got used because I'm silly
//
//	public static void flagTF (String theText, JTextField theField ){
//		if (theText.equals("")){
//			theField.setBackground(Color.RED);
//		}//if
//	}//flagTF
//	
//	public static void unflagTF (String theText, JTextField theField ){
//		if (!theText.equals("")){
//			theField.setBackground(Color.white);
//		}//if
//	}//unflagTF
//	
//	public static void fullReset(JTextField theField){
//		theField.setBackground(Color.white);
//		theField.setText("");
//	}//full Reset
//	
//	public static void resetCombo(JComboBox theCombo){
//		theCombo.setSelectedItem("");
//		theCombo.setBackground(Color.white);
//	}//resetCombo
//	
//	public static String getUserData ( JTextField theField){
//		String theText = theField.getText();
//		return theText;
//	}//getUserData
//
//	public static void resetButtons(JButton theButton){
//		if (theButton.isEnabled()==false){
//			theButton.setEnabled(true);
//		}else{
//			theButton.setEnabled(false);
//		}//else
//	}//resetButtons

	
	/**
	 * the main method
	 * @param args the args for the main method
	 */
	public static void main(String[] args) {

	}//main

}//Utility Methods
