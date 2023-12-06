import java.io.Serializable;

public class GasolineTaxi extends Taxi implements Serializable{

	
	private int gasLiter;
	private double consumption;
	public GasolineTaxi(String noPlate, String driverName, int gasLiter, double consumption) {
		super(noPlate, driverName);
		this.gasLiter = gasLiter;
		this.consumption = consumption;
	}
	
	public double consumptionCalc() {
		return 90 * (gasLiter / consumption);
	}
	
	
	
}
