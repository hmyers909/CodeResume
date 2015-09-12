package for_arrays_and_while_loops_lab;

//Heather Myers
//2/23/15
//CS 64
//Barbara Li Santi
//While Loop Lab - First Edition

public class ArraysAndWhileLoops {
	// reference to an array to hold some random ints
	private static int myInts[];
	//constant maximum number of elements in the array
	private static final int MAXNUMS = 100;

	private static void displayMyInts(String msg) {
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i++) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 10 == 9) {//10 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyNumbers


	private static void sumExceeds(int someNum){ //10
		int Sum = 0;
		for (int i = 0; i < myInts.length; i++) {
			while (Sum<someNum){
				System.out.print(myInts[i] + "\t");//tabs between values
				Sum +=myInts[i]; 
				i++;
			}//while
		}//for
	}//sumExceeds


	private static int firstOccur (int find){//11
		int i = 0;
		while (myInts.length>i){
			if (find !=myInts[i]){
				i++;
			}else{
				return (i);
			}//else
		}//while
		return -1;
	}//firstOccur


	private static int greaterOccur (int find){//12
		int i = 0;
		while (myInts.length>i){
			if (find >= myInts[i]){
				i++;
			}else{
				return (i);
			}//else
		}//while
		return -1;
	}//greaterOccur

	private static int lastOccur (int find){//13
		int i = myInts.length-1;
		while (myInts.length>i&&i>=0){
			if (find !=myInts[i]){
				i--;
			}else{
				return (i);
			}//else
		}//while
		return -1;
	}//lastOccur

	private static int lastGreatOccur (int find){//14
		int i = myInts.length-1;
		while (myInts.length>i&&i>=0){
			if (find >= myInts[i]){
				i--;
			}else{
				return (i);
			}//else
		}//while
		return -1;
	}//lastGreatOccur

	private static int ascend(){//15
		int i = 0;
		while (myInts.length>i){
			if (myInts[i]<myInts[i+1]){
				i++;
			}else{
				return i+1;
			}//else
		}//while
		return -1;
	}//ascend





	public static void main(String[] args) {
		System.out.println("Heather Myers\n2/24/15\nCS64\nBarbara Li Santi\n");//9

		//allocate array to hold the ints
		myInts = new int [MAXNUMS];
		System.out.println("Array will contain " + myInts.length + 
				" random integers in the range 0-49"); // generate random ints
		for (int i=0; i<  myInts.length; i++) {//random ints will be in range 0-49
			myInts[i]=(int) (Math.random() * 50);
		}//for

		// display values in the array with message
		displayMyInts("\nThe ints in the array are: \n");

		//testing
		sumExceeds(100);//test 10
		System.out.println("\nThis is the first occurance of 0: "+ firstOccur(0)+"\n");//test 11
		System.out.println("\nThis is the first occurance of 100: "+ firstOccur(100)+"\n");//test 11
		System.out.println("\n A greater value than 35 can be found: "+ greaterOccur(35)+"\n");//test 12
		System.out.println("\n A greater value than 100 can be found: "+ greaterOccur(100)+"\n");// test 12
		System.out.println("\nThis is the last occurance of 0: "+ lastOccur(0)+"\n");//test 13
		System.out.println("\nThis is the last occurance of 100: "+ lastOccur(100)+"\n");//test 13
		System.out.println("\n A greater value than 35 can be found: "+ lastGreatOccur(35)+"\n");//test 14
		System.out.println("\n A greater value than 100 can be found: "+ lastGreatOccur(100)+"\n");//test 14
		System.out.println("\n Is not in ascending order: "+ ascend()+"\n");//test 15

	}//main

}//ArraysAndWhileLoops

