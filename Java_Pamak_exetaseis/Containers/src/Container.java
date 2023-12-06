
public abstract class Container {

	private String destination;
	private String code;
	
	public Container(String destination, String code) {
		this.destination = destination;
		this.code = code;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public abstract double calculateCharge();
	
	
	
}
