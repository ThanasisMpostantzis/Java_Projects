
public class SolarPanel {

	private String brandName;
	private double kW;
	
	public SolarPanel(String brandName, double kw) {
		super();
		this.brandName = brandName;
		kW = kw;
	}
	
	public double getKw() {
		return kW;
	}
	
	public String getBrandName() {
		return brandName;
	}
	
	
}
