import java.util.Random;

public class Motorcycle {

	private int licenseNumber;
	private String model;
	private int year;
	private int maxSpeed;
	private double engineDisplacement;
	
	public Motorcycle(int licenseNumber, String model, int year, int maxSpeed, double
			engineDisplacement) {
		this.licenseNumber = licenseNumber;
		this.model = model;
		this.year = year;
		this.engineDisplacement = engineDisplacement;
		if (maxSpeed < 0) {
			throw new RuntimeException("max speed is invalid");
		}
		else {
			this.maxSpeed = maxSpeed;
		}
	}
		
	
	public double calculateDrivingTime(double distance) {
	    Random random = new Random();
	    double P = 0.6 + (0.2 * random.nextDouble());
		return (distance / (this.maxSpeed * P));
	}
	
}
