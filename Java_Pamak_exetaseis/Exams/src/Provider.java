import java.util.ArrayList;


public class Provider {

	private String coName;
	private ArrayList<Subscriber> subscribers = new ArrayList<>();
	
	public Provider(String coName) {
		this.coName = coName;
	}

	public void addSubscriber(Subscriber sub1) {
		subscribers.add(sub1);
	}
	
	public int calculateTotalNetEnergy() {
		int sum = 0;
		for(Subscriber s: subscribers) {
			sum += s.calculateNetEnergy();
		}
		return sum;
	}
	
	public String getCoName() {
		return this.coName;
	}
}
