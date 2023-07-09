package ticTacTow;


public class PrintInfo {
	
	public PrintInfo() {
		
	}
	
	public void printInfoo() {
		System.out.println("*****************************");
		System.out.println("Welcome to Tic_Tac_Toe Game!!");
		System.out.println("*****************************\n");
	}
	
	public void move() {
		System.out.println("Please enter the column (A, B or C) and then the row (1, 2, or 3) of your move.");
	}
	
	public void table() {
		System.out.println("   A B C");
		System.out.println("1 " + "| " + "| " + "| " + "| ");
		System.out.println("2 " + "| " + "| " + "| " + "| ");
		System.out.println("3 " + "| " + "| " + "| " + "| ");
	}
	
	public void table_toe(String a1, String a2, String a3,String b1,String b2,String b3,String c1,String c2,String c3) {
		System.out.println("   A B C");
		System.out.println("1 " + "| " + a1 + "| " + b1 + "| " + c1 + "| ");
		System.out.println("2 " + "| " + a2 + "| " + b2 + "| " + c2 + "| ");
		System.out.println("3 " + "| " + a3 + "| " + b3 + "| " + c3 + "| ");
	}
	
	public boolean pCoverC(String[] array1, String[] array2) {
		int size = Math.max(array1.length, array2.length);
		
		for(int i=0; i<size; i++)
			if(array1[i].equals("X") && array2[i].equals("O") || array1[i].equals("O") && array2[i].equals("X")) {
	    		System.out.println("You cant do this move !! Is already taken.");
	    		return true;
	    	}
		return false;
	}
	
	public String[] mergeData(String[] array1, String[] array2) {
		int size = Math.max(array1.length, array2.length);
		String[] mergedArray = new String[size];

		for (int i = 0; i < size; i++) {
		    if (i < array1.length && !array1[i].equals("")) {
		    	/*if(array1[i].equals("X") && array2[i].equals("O") ||
		    			array1[i].equals("X") && array2[i].equals("X") ||
		    			array1[i].equals("O") && array2[i].equals("X") ||
		    			array1[i].equals("O") && array2[i].equals("O"))*/
		    		//mergedArray[i] = array1[i];
		    	mergedArray[i] = array1[i];
		    }
		    else if (i < array2.length && !array2[i].equals("")) {
		    	/*if(array1[i].equals("O") && array2[i].equals("X") ||
		    			array1[i].equals("O") && array2[i].equals("O") ||
		    			array1[i].equals("X") && array2[i].equals("O") ||
		    			array1[i].equals("X") && array2[i].equals("X"))*/
		    		//mergedArray[i] = array1[i];	    	
	    		mergedArray[i] = array2[i];
		    }
		}
		for (int i = 0; i < mergedArray.length; i++)
		    if (mergedArray[i] == null)
		        mergedArray[i] = "";
		return mergedArray;

	}
	
	
	
}
