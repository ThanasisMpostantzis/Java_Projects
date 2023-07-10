package ticTacTow;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Computer {
	
	private String[] array;
	private String a1="",a2="",a3="",b1="",b2="",
			b3="",c1="",c2="",c3 ="";
	
	public Computer() {
		
	}
	
	public void computerMove() {
		
		System.out.println("Computer Move (O): ");

	    List<String> options = new ArrayList<>();
        options.add("A1");
        options.add("A2");
        options.add("A3");
        options.add("B1");
        options.add("B2");
        options.add("B3");
        options.add("C1");
        options.add("C2");
        options.add("C3");

        Random random = new Random();
        int numChoices = 5; // Αριθμός επιλογών που θέλουμε να κάνουμε

        String randomOption = "";
        int randomIndex;
        for (int i = 0; i < numChoices; i++) {
            randomIndex = random.nextInt(options.size());
            randomOption = options.get(randomIndex);
            options.remove(randomIndex);
        }
        
	    if (randomOption.equals("A1")) 
	        a1 = "O";
	    else if (randomOption.equals("A2")) 
	        a2 = "O";
	        
	    else if (randomOption.equals("A3"))
	        a3 = "O";
	        
	    else if (randomOption.equals("B1"))
	        b1 = "O";
	        
	    else if (randomOption.equals("B2"))
	        b2 = "O";
	       
	    else if (randomOption.equals("B3"))
	        b3 = "O";
	        
	    else if (randomOption.equals("C1"))
	        c1 = "O";
	       
	    else if (randomOption.equals("C2")) 
	        c2 = "O";
	        
	    else if (randomOption.equals("C3")) 
	        c3 = "O";
	        
		
		array = new String[9];
		array[0] = a1;
		array[1] = a2;
		array[2] = a3;
		array[3] = b1;
		array[4] = b2;
		array[5] = b3;
		array[6] = c1;
		array[7] = c2;
		array[8] = c3;
}
	
	public boolean checkWin(String[] array) {
		if(array[0] == "O" && array[1] == "O" && array[2] == "O" ||
				array[3] == "O" && array[4] == "O" && array[5] == "O" ||
				array[6] == "O" && array[7] == "O" && array[8] == "O" ||
				array[0] == "O" && array[3] =="O" && array[6] =="O"||
				array[1] =="O" && array[4] =="O" && array[7] =="O" ||
				array[2] == "O" && array[5] =="O" && array[8] =="O" ||
				array[0] == "O" && array[4] == "O" && array[8] == "O" ||
				array[2] == "O" && array[4] == "O" && array[6] == "O")
				return true;
		return false;
	}
	
	public String[] sGett() {
		Player playerr = new Player();
		String[] a = playerr.getArray();
		return a;
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
