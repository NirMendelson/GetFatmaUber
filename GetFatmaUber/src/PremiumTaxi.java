import java.util.Random;

public class PremiumTaxi extends Vehicle implements Upgradable {

	private double luxuryCharge;
	private int maxPassengers;

	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers, double luxuryCharge) {
		super(licenseNumber, model, year);
		this.type = "PremiumTaxi";
		this.luxuryCharge = luxuryCharge;
		this.baseFare = baseFare;
		setMaxPassengers(maxPassengers);
	}

    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 1 || maxPassengers > 10) {
            throw new IllegalArgumentException("Invalid number of passengers for PremiumTaxi.");
        }
        this.maxPassengers = maxPassengers;
    }
	
	public double getLuxuryCharge() {
		return this.luxuryCharge;
	}

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
