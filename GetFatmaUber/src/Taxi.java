import java.util.Random;

public class Taxi extends Vehicle implements Deliverable {
	
	protected int maxPassengers;
	
	public Taxi(int licenseNumber, String model, int year, double baseFare, int maxPassengers) {
		super(licenseNumber, model, year);
		this.baseFare = baseFare;
		this.type = "Taxi";
		setMaxPassengers(maxPassengers);
	}
	
	public void setMaxPassengers(int maxPassengers) {
        if (maxPassengers > 4 || maxPassengers < 1) {
            throw new IllegalArgumentException("you can only have 1-4 passengers in a taxi");
        }
        this.maxPassengers = maxPassengers;
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
	
	public double getFare() {
		return this.baseFare;
	}
	
}
