import java.util.ArrayList;

public class MunicipalCommunity extends Community {

	private double area;  	//in square kilometers
	private ArrayList<RecyclingCenter> recycle = new ArrayList<>();
	
	
	public MunicipalCommunity(String name, int population, double area) {
		super(name, population);
		this.area = area;
	}
	
	public double calculateFunding() {
		double sum = 0;
		for(RecyclingCenter r: recycle) {
			sum += r.getMaterial();
		}
		return 10000 * Math.floor(area) + 1000 * Math.floor(sum);
	}
	
	public void add(RecyclingCenter name) {
		recycle.add(name);
	}
}
