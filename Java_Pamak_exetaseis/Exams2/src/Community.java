import java.io.Serializable;

public class Community implements Serializable {
	
	private String name;
	private int population;
	
	public Community(String name, int population) {
		this.name = name;
		this.population = population;
	}
	
	public double calculateFunding() {
		return 50 * population;
	}
}
