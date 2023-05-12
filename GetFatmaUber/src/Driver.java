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
	
	public Driver(int ID, String name, String phoneNumber, double rating, String [] licenses) {
		this.ID = ID;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.rating = rating;
		this.licenses = licenses;
	}
	

	public double drivingProfit(Customer c, double time, Vehicle v) {
		Random random = new Random();
        double P = 0.5 + random.nextDouble() * 0.5;
        // getLatestExpenses is our pay
        this.allEarnings = this.allEarnings + (c.getLatestExpense() + c.getRatingToDriver()) - (time*P);
		return (c.getLatestExpense() + c.getRatingToDriver()) - (time*P);
	}
	
	public void addToAllEarnings(double profit) {
		this.allEarnings += profit;
	}

	
	public double getRating() {
		return this.rating;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setRating(double rating) {
		this.ratingsCount++;
		this.sumOfRating += rating;
		this.rating = (this.sumOfRating/this.ratingsCount) ;
		
	}
	
	public String[] getLicense() {
		return this.licenses;
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
