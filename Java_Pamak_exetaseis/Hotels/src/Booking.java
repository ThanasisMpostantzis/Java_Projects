
public class Booking {

	protected int days;

	public Booking(int days) {
		super();
		this.days = days;
	}
	
	public double bookingCost() {
		return days * 120;
	}
	
}
