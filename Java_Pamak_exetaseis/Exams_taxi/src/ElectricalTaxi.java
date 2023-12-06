import java.io.Serializable;

public class ElectricalTaxi extends Taxi implements Serializable{

	private int batteryNo;

	public ElectricalTaxi(String noPlate, String driverName, int batteryNo) {
		super(noPlate, driverName);
		this.batteryNo = batteryNo;
	}
	
	public double consumptionCalc() {
		return 70 * batteryNo;
	}
	
	
}
