import java.util.ArrayList;

public class GreenSubscriber extends Subscriber{
	
	private String location;
	private ArrayList<SolarPanel> solarPanels = new ArrayList<>();
	
	public GreenSubscriber(String lastName, double avgKw, String location) {
		super(lastName, avgKw);
		this.location = location;
	}
	
	public void addSolarPanel(SolarPanel solarP) {
		solarPanels.add(solarP);
	}
	
	public double calculateNetEnergy() {
		double sum = 0;
		double mo = 0;
		
		for(SolarPanel s: solarPanels) {
			if(s.getBrandName().equals("SunPower")) {
				sum++;
				mo = 480;
			}else if( s.getBrandName().equals("Panasonic")) {
				sum++;
				mo = 550;
			}else {
				sum++;
				mo = 490;
			}
		}
		return super.avgKw - (sum * mo);
	}
	
}
