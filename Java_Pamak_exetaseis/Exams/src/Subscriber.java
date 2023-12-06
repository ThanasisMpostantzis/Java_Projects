
public class Subscriber {
	
	protected String lastName;
	protected double avgKw;
	
	public Subscriber(String lastName, double avgKw) {
		this.lastName = lastName;
		this.avgKw = avgKw;
	}
	
	public double calculateNetEnergy() {
		return avgKw;
	}
	
	
}
