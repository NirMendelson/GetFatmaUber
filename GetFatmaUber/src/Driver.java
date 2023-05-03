import java.util.Random;

public class Driver implements Comparable <Driver> {

	private String name;
	private int ID;
	private String phoneNumber;
	private double rating;
	private String [] licenses;
	private double allEarnings = 0;
	
	public Driver(int ID, String name, String phoneNumber, double rating, String [] licenses) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.licenses = licenses;
		}
	

	public double drivingProfit(Customer c, int time, Vehicle v) {
		Random random = new Random();
        double P = 0.5 + random.nextDouble() * 0.5;
        // getLatestExpenses is our pay
        this.allEarnings = this.allEarnings + (c.getLatestExpense() + c.getGiveRating()) - (time*P);
		return (c.getLatestExpense() + c.getGiveRating()) - (time*P);
		
		
		
	}
	
	public double getRating() {
		return this.rating;
	}
	
	public double getAllEarnings() {
		return this.allEarnings;
	}
	
	public int compareTo(Driver dOther) {
		if (this.getRating() > dOther.getRating()) {
			return 1;
		}
		else if (dOther.getRating() > this.getRating()) {
			return -1;
		} 
		else {
			return 0;
		}
	}
 
	
}
