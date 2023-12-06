
public abstract class Taxi {

	private String noPlate;
	private String driverName;
	
	public Taxi(String noPlate, String driverName) {
		this.noPlate = noPlate;
		this.driverName = driverName;
	}
	
	public String driversName() {
		return driverName;
	}
	
	public String driversPlate() {
		return noPlate;
	}
	
	public abstract double consumptionCalc();
	
	
}
