import java.util.Random;

public class Taxi extends Vehicle implements Deliverable {

	protected int maxPassengers;

	// Constructs a Taxi object
	public Taxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year);
		this.baseFare = baseFare;
		this.type = "Taxi";
		setMaxPassengers(maxPassengers);
	}

	// Throws a PassengerCountInvalidException if the maximum number of passengers is not within the valid range of 1 to 4
	public void setMaxPassengers(int maxPassengers) {
		if (maxPassengers > 4 || maxPassengers < 1) {
			throw new PassengerCountInvalidException("Invalid number of passengers: " + maxPassengers);
		}
		this.maxPassengers = maxPassengers;
	}

	// Calculates the driving time for the given distance
	// Returns the calculated driving time
	public double calculateDrivingTime(double distance) {
		Random random = new Random();
		double min = 0.5;
		double max = 0.7;
		int decimalPlaces = 3;
		double range = max - min;
		double scaledValue = random.nextDouble() * range + min;
		double P = Math.round(scaledValue * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
		return (distance / (100 * P)) + 2;  
	}

	// Uses deliverable and returns true
	@Override
	public boolean canDeliver() {
		return true;
	}

	// Getter for fare
	@Override
	public double getFare() {
		return this.baseFare;
	}

}
