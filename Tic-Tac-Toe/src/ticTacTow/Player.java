package ticTacTow;

import java.util.Scanner;

public class Player {

	private String[] array;
	private String inp = "";
	private String a1="",a2="",a3="",b1="",b2="",
			b3="",c1="",c2="",c3 ="";
	
	public Player() {
		
	}
	
	public void pMove() {
		Scanner s1 = new Scanner(System.in);
		boolean isValid = false;
		
		System.out.println("Player Move (X): ");
		inp = s1.nextLine();
		do {
			if (inp.equals("A1")) {
				a1 = "X";
				isValid = true;
			}else if(inp.equals("A2")) {
				a2 = "X";
				isValid = true;
			}else if(inp.equals("A3")) {
				a3 = "X";
				isValid = true;
			}else if(inp.equals("B1")) {
				b1 = "X";
				isValid = true;
			}else if(inp.equals("B2")) {
				b2 = "X";
				isValid = true;
			}else if(inp.equals("B3")) {
				b3 = "X";
				isValid = true;
			}else if(inp.equals("C1")) {
				c1 = "X";
				isValid = true;
			}else if(inp.equals("C2")) {
				c2 = "X";
				isValid = true;
			}else if(inp.equals("C3")) {
				c3 = "X";
				isValid = true;
			}
			else {
				System.out.println("Invalid Input: Please enter the column and row of your move (Example: A1).");
				inp = s1.nextLine();
		}		
	}while (!isValid);
	
		

	array = new String[9];
	array[0] = this.a1;
	array[1] = this.a2;
	array[2] = this.a3;
	array[3] = this.b1;
	array[4] = this.b2;
	array[5] = this.b3;
	array[6] = this.c1;
	array[7] = this.c2;
	array[8] = this.c3;
	
}
	public boolean checkWin(String[] array) {
		if(array[0] == "X" && array[1] == "X" && array[2] == "X" ||
				array[3] == "X" && array[4] == "X" && array[5] == "X" ||
				array[6] == "X" && array[7] == "X" && array[8] == "X" ||
				array[0] == "X" && array[3] =="X" && array[6] =="X"||
				array[1] =="X" && array[4] =="X" && array[7] =="X" ||
				array[2] == "X" && array[5] =="X" && array[8] =="X" ||
				array[0] == "X" && array[4] == "X" && array[8] == "X" ||
				array[2] == "X" && array[4] == "X" && array[6] == "X")
				return true;
		return false;
	}
	
	public String getA1() {
		return a1;
	}

	public String getA2() {
		return a2;
	}

	public String getA3() {
		return a3;
	}

	public String getB1() {
		return b1;
	}

	public String getB2() {
		return b2;
	}

	public String getB3() {
		return b3;
	}

	public String getC1() {
		return c1;
	}

	public String getC2() {
		return c2;
	}

	public String getC3() {
		return c3;
	}
	
	public String[] getArray() {
		return array;
	}
}
