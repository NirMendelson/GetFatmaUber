import java.util.Random;

public class Motorcycle extends Vehicle {
	
	private int maxSpeed;
	private double engineDisplacement;
	
	public Motorcycle(int licenseNumber, String model, int year, int maxSpeed, double
			engineDisplacement) {
		super(licenseNumber, model, year);
		this.engineDisplacement = engineDisplacement;
		this.type = "Motorcycle";
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
