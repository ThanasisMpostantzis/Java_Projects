import java.util.ArrayList;

public class Ship {

	private String name;
	private int capacity;
	private ArrayList<Container> containers = new ArrayList<>();
	
	public Ship(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}
	
	public void loadContainer(Container aContainer) {
		if(containers.size() < capacity) {
			containers.add(aContainer);
			System.out.println("Container has been loaded");
		}
		else {
			System.out.println("This ship is full");
		}
	}
	
	public double calculateTotalCharge() {
		double sum = 0;
		for(Container container: containers) {
			sum += container.calculateCharge();
		}
		return sum;
	}

	public String getName() {
		return name;
	}
	
	
	
	
}
