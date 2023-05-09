import java.util.Random;

public class PremiumTaxi extends Taxi implements Upgrades {

	private double luxuryCharge;

	public PremiumTaxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers, double luxuryCharge) {
		super(licenseNumber, model, year, baseFare, maxPassengers);
		this.type = "PremiumTaxi";
		this.luxuryCharge = luxuryCharge;
		setMaxPassengers(maxPassengers);
	}

	@Override
    public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers < 1 || maxPassengers > 10) {
            throw new IllegalArgumentException("Invalid number of passengers for PremiumTaxi.");
        }
        this.maxPassengers = maxPassengers;
    }

	public boolean upgrade() {
		Random random = new Random();
		double probability = 0.5; // 50% probability
		if (random.nextDouble() < probability) {
			System.out.println("Taxi upgraded!");
			return true;
		} else {
			return false;
		}
	}

}
