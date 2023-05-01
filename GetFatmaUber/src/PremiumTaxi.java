import java.util.Random;

public class PremiumTaxi {

	private int licenseNumber;
	private String model;
	private int year;
	private double baseFare;
	private int maxPassengers;
	private double luxuryCharge;
	
	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int
			maxPassengers, double luxuryCharge) {
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.baseFare = baseFare;
		this.luxuryCharge = luxuryCharge;
		if (maxPassengers > 10 || maxPassengers < 1) {
			throw new RuntimeException("max passengers is invalid");
		}
		else {
			this.maxPassengers = maxPassengers;
		}
		
	}
	
	public boolean upgrade() {
	    Random random = new Random();
	    double probability = 0.5; // 50% probability
	    if (random.nextDouble() < probability) {
	      // Apply the function here
	    	System.out.println("Taxi upgraded!");
	    	return true;
	    } else {
	    	return false;
	    }
	}

}
