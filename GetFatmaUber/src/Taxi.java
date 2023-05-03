import java.util.Random;

public class Taxi extends Vehicle implements Deliverable {
	
	private double baseFare;
	protected int maxPassengers;
	
	public Taxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year);
		this.baseFare = baseFare;
		this.type = "Taxi";
		if (maxPassengers > 4 || maxPassengers < 1) {
			throw new RuntimeException("max passengers is invalid");
		}
		else {
			this.maxPassengers = maxPassengers;
		}
	}
	
	public double calculateDrivingTime(double distance) {
	    Random random = new Random();
	    double P = 0.5 + (0.2 * random.nextDouble());
		return (distance / (100 * P)) + 2;
	    
	}

	@Override
	public boolean canDeliver() {
		return true;
	}
	
}
