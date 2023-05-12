import java.util.Random;

public class Motorcycle extends Vehicle implements Deliverable {
	
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
	    double min = 0.6;
        double max = 0.8;
        int decimalPlaces = 3;
        double range = max - min;
        double scaledValue = random.nextDouble() * range + min;
        double P = Math.round(scaledValue * Math.pow(10, decimalPlaces)) / Math.pow(10, decimalPlaces);
		return (distance / (this.maxSpeed * P));
	}


	public boolean canDeliver() {
		return true;
	}
	
}
