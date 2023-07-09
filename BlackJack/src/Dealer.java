import java.util.Random;
import java.util.Scanner;

public class Dealer {
	Random rand = new Random();
	 
	private int card1;
	private int card2;
	
	public Dealer() {
		card1 = rand.nextInt(9) + 1;
		card2 = rand.nextInt(9) + 1;
	}
	public void hitCard() {
		card1 = rand.nextInt(9) + 1;
	}
		
	public int getCard1d() {
		return card1;
	}
	
	public int getCard2d() {
		return card2;
	}
}
