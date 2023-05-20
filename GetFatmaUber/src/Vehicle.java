
public class Vehicle implements Comparable <Vehicle>  {
	
	public boolean isAvailable;
	protected String type;
	private Driver driver;
	private int licenseNumber;
	private String model;
	private int year;
	public double baseFare;
	
	// Constructs a Vehicle object.
	// Throws a YearInvalidException if the year is not within the valid range of 1970 to 2022.
	public Vehicle(int licenseNumber, String model, int year) {
	    this.licenseNumber = licenseNumber;
	    this.model = model;
	    if (year > 2022 || year < 1970) {
	        throw new YearInvalidException("Year is invalid: " + year);
	    }
	    else {
	        this.year = year;
	    }   
	}
	
	// Calculates the driving time for the given distance, for the motorcycle, taxi and premium taxi classes
	public double calculateDrivingTime(double distance) {
		return 0;
	}
	
	// Adds a driver to the vehicle if it doesn't already have one.
	// Returns true if the driver is successfully added, false otherwise.
	public boolean addDriver(Driver driver) {
		if (this.driver == null) {
			this.driver = driver;
			return true;
		}
		else {
			return false;
		}
	}
	
	// Getter for year.
	public int getYear() {
		return this.year;
	}
	
	// Setter for driver.
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	
	// Getter for driver.
	public Driver getDriver() {
		return this.driver;
	}
	
	// Getter for model.
	public String getModel() {
		return this.model;
	}
	
	// Getter for type.
	public String getType() {
		return this.type;
	}
	
	// Getter for isAvailable.
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	// Setter for isAvailable.
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	// Getter for license number.
	public int getLicenseNumber() {
		return this.licenseNumber;
	}
	
	// Uses Comparable.
	public int compareTo(Vehicle vOther) {
		if (this.getYear() > vOther.getYear()) {
			return 1;
		}
		else if (vOther.getYear() > this.getYear()) {
			return -1;
		} 
		else {
			return 0;
		}
	}
	
	// Getter for fare.
	public double getFare() {
		return 0;
	}
	
}
