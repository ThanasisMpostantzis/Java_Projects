
public class Bulk extends Container{

	private double weight;
	
	public Bulk(String destination, String code, double weight) {
		super(destination, code);
		this.weight = weight;
	}

	public double calculateCharge() {
		return weight * 10;
	}
	
}
