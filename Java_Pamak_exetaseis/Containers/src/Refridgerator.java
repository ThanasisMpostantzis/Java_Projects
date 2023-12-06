
public class Refridgerator extends Container{

	private double power;

	public Refridgerator(String destination, String code, double power) {
		super(destination, code);
		this.power = power;
	}
	
	public double calculateCharge() {
		return 2000 * power;
	}
	
}
