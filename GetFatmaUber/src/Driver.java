import java.util.Random;

public class Driver implements Comparable <Driver> {

	private String name;
	private int ID;
	private String phoneNumber;
	private double rating;
	private String [] licenses;
	private double allEarnings;
	private int ratingsCount;
	private double sumOfRating;

	// Constructs a Driver object
	public Driver(int ID, String name, String phoneNumber, double rating, String [] licenses) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.licenses = licenses;
	}
	
	// Calculates driving profit
	public double drivingProfit(Customer c, double time, Vehicle v) {
		Random random = new Random();
        double P = 0.5 + random.nextDouble() * 0.5;
        // getLatestExpenses is our pay
        this.allEarnings = this.allEarnings + (c.getLatestExpense() + c.getRatingToDriver()) - (time*P);
		return (c.getLatestExpense() + c.getRatingToDriver()) - (time*P);
	}
	
	// Adding profit to all earnings
	public void addToAllEarnings(double profit) {
		this.allEarnings += profit;
	}

	// Getter for rating
	public double getRating() {
		return this.rating;
	}
	
	// Getter for name
	public String getName() {
		return this.name;
	}
	
	// Setter for rating
	public void setRating(double rating) {
		this.ratingsCount++;
		this.sumOfRating += rating;
		this.rating = (this.sumOfRating/this.ratingsCount) ;
		
	}
	
	// Getter for license
	public String[] getLicense() {
		return this.licenses;
	}
	
	// Getter for all earnings
	public double getAllEarnings() {
		return this.allEarnings;
	}
	
	// Uses Comparable
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
