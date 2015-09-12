package for_arrays_and_for_loops_lab;

//Heather Myers
//2/3/14
//CS 64
//Barbara Li Santi

public class ArraysAndForLoops {
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
	}//displayMyInts
	
	private static int getMax(){ //10
		int currentMax = myInts[0];
		for (int i = 1; i < myInts.length; i++) {
			if(myInts[i] > currentMax){
				currentMax = myInts[i];
			}//if
		}//for
		return currentMax;
	}//getMax
	
	private static int getMin(){ //11
		int currentMin = myInts[0];
		for (int i = 1; i < myInts.length; i++) {
			if(myInts[i] < currentMin){
				currentMin = myInts[i];
			}//if
		}//for
		return currentMin;
	}//getMin
	
	private static void displayMyIntsGreaterThan(int greater){ //12
		for (int i = 0; i < myInts.length; i++) {
			if( myInts[i]>greater) {
				System.out.println(myInts[i]);
			}//if
		}//for
	}//displayMyIntsGreaterThan
	
	
	private static int getAverage(){ //From Class
		int sum = 0;
		for (int i = 0; i < myInts.length; i++) {
			sum = myInts[i] + sum;
		}//for
		return sum/myInts.length;
	}//getAverage
	
	private static void even(){ //13
		for (int i = 0; i < myInts.length; i++) {
			if( myInts[i]%2==0) {
				System.out.println(myInts[i]);
			}//if
		}//for
	}//even
	
	private static int howManyEven(){ //14
		int evenCount = 0;
		for (int i = 0; i < myInts.length; i++) {
			if( myInts[i]%2==0) {
				evenCount++;
			}//if
		}//for
		return evenCount;
	}//howManyEven
	
	private static void displayMyIntsBackward(String msg) { //15
		System.out.println(msg);
		for (int i = myInts.length -1; i > -1; i--) {
			System.out.print(myInts[i] + "\t");//tabs between values
			if( i % 5 == 0) {//5 values will be displayed per line
				System.out.println();
			}//if
		}//for
		System.out.println();//makes a blank line at the end
	}//displayMyIntsBackward
	
	private static void everyOther(String msg) { //16
		System.out.println(msg);
		for (int i = 0; i < myInts.length; i+=2) {
				System.out.println( myInts[i]);
		}//for
	}//everyOther
	
	private static int sumThem(){ //17
		int sum = 0;
		for (int i = 0; i < myInts.length; i++) {
			sum += i; {
			}//if
		}//for
		return sum;
	}//sumThem
	
	private static int sumOfIntsGreaterThan(int someNum){ //18
		int greatSum = 0;
		for (int i = 0; i < myInts.length; i++) {
			if( myInts[i]>someNum) {
				greatSum +=i;
			}//if
		}//for
		return greatSum;
	}//sumOfIntsGreaterThan
	
	private static void replace(int someNum){//19
		for (int i = 0; i < myInts.length; i++) {
			if( myInts[i]==someNum) {
				myInts[i]=-1;
			}//if
			System.out.println( myInts[i]);
		}//for
	}//replace
	
	private static void swap(int i1, int i2){//20
		int temp = myInts[i1];
		myInts[i1] = myInts [i2];
		myInts [i2] = temp;
	}//swap
	
	
	
	private static void reverse(){
		for (int i = 0; i<myInts.length/2; i++){//20
			swap (i, myInts.length-1-i);
			System.out.println(myInts[i]);
		}//for
	}//reverse
	
	private static void rotateBy1(){ //21
		int tempArray[] = new int [myInts.length];
		tempArray[0] = myInts[myInts.length-1];
		for (int i = 0; i < myInts.length -1; i++){
			tempArray[i+1] = myInts [i];
			System.out.println(myInts[i]);
		}//for
		myInts = tempArray;
}//rotateBy1
	
	private static void rotateBy2(){ //22
		int tempArray[] = new int [myInts.length];
		tempArray[0] = myInts[myInts.length-2];
		for (int i = 0; i < myInts.length -2; i++){
			tempArray[i+2] = myInts [i];
			System.out.println(myInts[i]);
		}//for
		myInts = tempArray;
}//rotateBy2

private static void rotateBy(int theNum){ //23
	int tempArray[] = new int [myInts.length];
	theNum = theNum % myInts.length;
	if (theNum<0){
		theNum = theNum+myInts.length;
	}//if
	for (int i=0; i<myInts.length-theNum; i++){
		tempArray[i+theNum] = myInts[i];
		System.out.println(myInts[i]);
	}//for
	for (int i =0; i<theNum; i++){
		tempArray[i] = myInts[myInts.length-theNum+i];
		System.out.println(myInts[i]);
	}//second for
		myInts=tempArray;
	}//rotateBy

private static void every5(String msg) { //24
	System.out.println(msg);
	for (int i = 0; i < myInts.length; i+=5) {
			System.out.println( myInts[i]);
	}//for
}//every5

private static void every4(String msg) {//25
	System.out.println(msg);
	for (int i = 0; i < myInts.length; i+=4) {
			System.out.println( myInts[i]);
	}//for
}//every4

private static void everyX(int X) { //26
	for (int i = 0; i < myInts.length; i+=X) {
			System.out.println( myInts[i]);
	}//for
}//everyX

	public static void main (String args[]) { //Testing
		//allocate array to hold the ints
		myInts = new int [MAXNUMS];
		System.out.println("Heather Myers \n2/3/15 \nCS 64 \nBarbara Li Santi\n"); //9
		
		System.out.println("Array will contain " + myInts.length + 
				" random integers in the range 0-49");
		
		// generate random ints
		for (int i=0; i<  myInts.length; i++) {
			//random ints will be in range 0-49
			myInts[i]=(int) (Math.random() * 50);
		}//for
		
		// display values in the array with message
		displayMyInts("\nThe ints in the array are: \n");
		
		System.out.println("\nThe maximum value in the array is "+ getMax()); //Test10
		
		System.out.println("\nThe minimum value in the array is "+ getMin()); //Test11
		
		System.out.println("\nThe average of the values in the array is "+ getAverage());
		
		System.out.println("\nThe values greater than 22 are:"); 
		
		displayMyIntsGreaterThan(22); //Test12
		
		System.out.println("\nThe values that are even are:");
		
		even(); //Test 13
		
		System.out.println("\nThere are this many even numbers:" + howManyEven());//Test 14
		
		displayMyIntsBackward("\nThe ints in the array backward are:");//Test15
		
		everyOther("\nEvery other int in the array is: \n");//Test16
		
		System.out.println("\nThe sum of all of the ints is: "+ sumThem()); //Test17
		
		System.out.println("\nThe sum of all values greater than 20 is: " + sumOfIntsGreaterThan(20));//Test18
		
		System.out.println("\nSwapping 37 for -1 gives you: ");
		replace(37);//Test19
		
		System.out.println("\nReversing the order of the array gives you: ");
		reverse();//Test20
		
		System.out.println("\nRotating the array by 1 gives you: ");
		rotateBy1();//Test21
		
		System.out.println("\nRotating the array by 2 gives you: ");
		rotateBy2();//Test22
		
		System.out.println("\nRotating the array by 6 gives you: "); 
		rotateBy(6);//Test23
		
		every5("\nEvery 5 ints in the array are: \n");//Test24
		
		every4("\nEvery 4 ints in the array are: \n");//Test25
		
		System.out.println("\nEvery 7 ints in the array are:\n");
		everyX(7);//Test26
	
	}//main

}//ArraysAndForLoops
