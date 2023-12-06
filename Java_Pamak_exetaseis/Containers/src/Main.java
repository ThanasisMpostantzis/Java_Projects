import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Ship ship1 = new Ship("Copacabana", 3);
		Ship ship2 = new Ship("Hercules", 100);
		Ship ship3 = new Ship("Zeus", 80);
		Ship ship4 = new Ship("Olympus", 120);
		Ship ship5 = new Ship("Tinos", 140);
		
		ArrayList<Ship> ships = new ArrayList<>();
		ships.add(ship1);
		ships.add(ship2);
		ships.add(ship3);
		ships.add(ship4);
		ships.add(ship5);
		
		new ContainerFrame(ships);
		
	}

}
