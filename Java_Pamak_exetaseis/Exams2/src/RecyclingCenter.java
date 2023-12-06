import java.io.Serializable;

public class RecyclingCenter implements Serializable{

	private String code;
	private double material;

	public RecyclingCenter(String code, double material) {
		this.code = code;
		this.material = material;
	}
	
	public double getMaterial() {
		return material;
	}
	
}
