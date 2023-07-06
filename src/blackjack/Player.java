package blackjack;
import java.util.Random;
import java.util.Scanner;


public class Player {
	
	Random rand = new Random();
	
	private int card1;
	private int card2;
	
	
	public Player() {
		card1 = rand.nextInt(9) + 1;
		card2 = rand.nextInt(9) + 1;
	}
	
	public void hitCard() {
		card1 = rand.nextInt(9) + 1;
	}
	
	public int getCard1() {
		return card1;
	}
	
	public int getCard2() {
		return card2;
	}
	
	public void sum21(int sum) {
		if(sum > 21) {
			System.out.println("You lose, Dealer wins");
		}
		if(sum == 21) {
			System.out.println("You win");
		}
	}

	public void sumIsB(int sum1, int sum2) {
		if(sum1 > sum2) {
			System.out.println("PLAYER WINS");
		}else{
			System.out.println("DEALER WINS");
		}
	}
}
