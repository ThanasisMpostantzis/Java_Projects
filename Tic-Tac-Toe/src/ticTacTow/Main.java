package ticTacTow;


public class Main {

	public static void main(String[] args) {
		PrintInfo p1 = new PrintInfo();
		p1.printInfoo();
		p1.move();
		p1.table();
		Player player1 = new Player();
		player1.pMove();
		String[] s1 = player1.getArray();
		p1.table_toe(s1[0], s1[1], s1[2], s1[3], s1[4], s1[5], s1[6], s1[7], s1[8]);
		
		
		
		String[] a1 = null;
		Computer computer1 = new Computer();
		boolean ep = true;
		
		while(ep) {
			computer1.computerMove();
			String[] s2 = computer1.getArray();
			/*if(p1.pCoverC(s1, s2)) {
				computer1.computerMove();
				s2 = computer1.getArray();
			}*/
			a1 = p1.mergeData(s1, s2);
			p1.table_toe(a1[0], a1[1], a1[2], a1[3], a1[4], a1[5], a1[6], a1[7], a1[8]);
			
			
			
			player1.pMove();
			s1 = player1.getArray();
			/*if(p1.pCoverC(a1, s1)) {
					player1.pMove();
					s1 = player1.getArray();
			}*/
			s2 = p1.mergeData(a1, s1);
			p1.table_toe(s2[0], s2[1], s2[2], s2[3], s2[4], s2[5], s2[6], s2[7], s2[8]);
			
			
			
			if(player1.checkWin(s2)) {
				System.out.println("Player Wins !!!");
				ep = false;
			}
			if(computer1.checkWin(s2)) {
				System.out.println("Computer Wins !!!");
				ep = false;
			}
		}
	}

}
