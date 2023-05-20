import java.util.Random;

public class PremiumTaxi extends Vehicle implements Upgradable {

	private double luxuryCharge;
	private int maxPassengers;

	// Constructs a PremiumTaxi object
	// Throws a PassengerCountInvalidException if the maximum number of passengers is not within the valid range of 1 to 10
	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers, double luxuryCharge) {
		super(licenseNumber, model, year);
		this.type = "PremiumTaxi";
		this.luxuryCharge = luxuryCharge;
		this.baseFare = baseFare;
		setMaxPassengers(maxPassengers);
	}

	// Sets the maximum number of passengers for the premium taxi
	// Throws a PassengerCountInvalidException if the number of passengers is not within the valid range of 1 to 10
    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 1 || maxPassengers > 10) {
        	throw new PassengerCountInvalidException("Invalid number of passengers: " + maxPassengers);
        }
        this.maxPassengers = maxPassengers;
    }
	
 
    // Getter for luxury charge
	public double getLuxuryCharge() {
		return this.luxuryCharge;
	}

	// Uses upgradable
	public boolean upgrade() {
		Random random = new Random();
		double probability = 0.5; // 50% probability
		if (random.nextDouble() < probability) {
			System.out.println("PremiumTaxi number: " + this.getLicenseNumber() + " got upgraded!");
			return true;
		} else {
			return false;
		}
	}

}
