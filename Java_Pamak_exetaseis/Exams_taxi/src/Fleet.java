import java.io.Serializable;
import java.util.ArrayList;

public class Fleet implements Serializable{

	private String name;
	private ArrayList<Taxi> taxies = new ArrayList<>();
	
	
	public Fleet(String name) {
		super();
		this.name = name;
	}
	
	public void storeTaxi(Taxi taxi) {
		taxies.add(taxi);
	}
	
	public String getName() {
		return name;
	}
	
	public double totalTaxiCalc() {
		double sum = 0;
		for(Taxi t: taxies) {
			sum += t.consumptionCalc();
		}
		return sum;
	}

	public ArrayList<Taxi> getTaxies() {
		return taxies;
	}
	
}
