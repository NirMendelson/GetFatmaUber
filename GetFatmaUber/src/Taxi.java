import java.util.Random;

public class Taxi {

	private int licenseNumber;
	private String model;
	private int year;
	private double baseFare;
	private int maxPassengers;
	
	public Taxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.baseFare = baseFare;
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
	
}
