
public class AllInclusive extends Booking{

	private int sumMeals;

	public AllInclusive(int sumMeals, int days) {
		super(days);
		this.sumMeals = sumMeals;
	}
	
	public double bookingCost() {
		return super.days * (120 + sumMeals * 30);
	}
}
