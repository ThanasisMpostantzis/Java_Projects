import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		 
		System.out.println("Welcome to the simplified BlackJack game !!\n");
		Player player = new Player();
		System.out.println("You get a " + player.getCard1() +
				" and a " + player.getCard2() + "\n");
		
		int sum = player.getCard1() + player.getCard2();
		System.out.println("Your total is " + sum + ".\n\n");
		
		
		Dealer dealer = new Dealer();
		System.out.println("The Dealer has a "+ dealer.getCard1d() + 
				" and a hidden card.\n");
		
		Scanner in = new Scanner(System.in);
		boolean a = true;
		
		while(a && sum < 21) {
			System.out.println("Would you like to hit OR stay?? ");
			String inn = in.nextLine();
			int sum2 = 0;
			if(inn.equals("hit")) {
				player.hitCard();
				System.out.println("You drew a " + player.getCard1() + " .\n");
				sum = sum + player.getCard1();
				System.out.println("Your total is " + sum + ".\n");
				player.sum21(sum);
			}
			if(inn.equals("stay")){
				a = false;
				System.out.println("OK, dealer is playing.\n");
				System.out.println("His hidden card was "+ dealer.getCard2d()+ ".\n");
				sum2 = dealer.getCard1d() + dealer.getCard2d();
				System.out.println("His total is "+ sum2 + ".\n");
				player.sum21(sum2);
				
				while(sum2 < 15) {
					System.out.println("Dealer chooses to hit.\n");
					dealer.hitCard();
					System.out.println("He draws a "+ dealer.getCard1d() + ".\n");
					sum2 = sum2 + dealer.getCard1d();
					System.out.println("His total is "+ sum2 + ".\n");
					player.sum21(sum2);
				}
				if(sum2 > 15) {
					System.out.println("Dealer stays.\n");
				}
				System.out.println("Dealer total is " + sum2);
				System.out.println("Your total is " + sum);
				
				player.sumIsB(sum, sum2);
				in.close();
			}
		}
	}
}
