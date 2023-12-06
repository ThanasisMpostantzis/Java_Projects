import java.io.Serializable;
import java.util.ArrayList;

public class City implements Serializable{

	private String edra;

	private ArrayList<Community> community = new ArrayList<>();
	
	public City(String edra) {
		this.edra = edra;
	}

	public double calculateFunding() {
		double sum = 0;
		for(Community c : community) {
			sum += c.calculateFunding();
		}
		return sum;
	}
	
	public String getEdra() {
		return edra;
	}
	
	public void add(Community c) {
		community.add(c);
	}
}