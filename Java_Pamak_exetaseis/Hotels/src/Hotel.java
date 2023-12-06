import java.io.Serializable;
import java.util.ArrayList;


public class Hotel implements Serializable, Comparable {
	
	private String name;
	private ArrayList<Booking> bookings = new ArrayList<>();
	
	public Hotel(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Object o) {
		Hotel otherHotel = (Hotel) o;
		return this.name.compareTo(otherHotel.name);
	}
	
	public double totalCost() {
		double sum = 0;
		for(Booking b: bookings) {
			sum += b.bookingCost();
		}
		return sum;
	}
	
	public void resAdd(Booking r) {
		bookings.add(r);
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	
}
