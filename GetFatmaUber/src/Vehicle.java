
public class Vehicle implements Comparable <Vehicle>  {
	
	public boolean isAvailable;
	protected String type;
	private Driver driver;
	private int licenseNumber;
	private String model;
	private int year;
	
	// לבדוק אם אפשר לכתוב בצורה יותר חכמה
	public Vehicle(int licenseNumber, String model, int year) {
		this.licenseNumber = licenseNumber;
		this.model = model;
		if (year < 2022 || year > 1970) {
			throw new RuntimeException("year is invalid");
		}
		else {
			this.year = year;
		}

		
	}
	
	public boolean addDriver(Driver driver) {
		if (this.driver == null) {
			this.driver = driver;
			return true;
		}
		else {
			return false;
		}
	}
	
	public int getYear() {
		return this.year;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public String getType() {
		return this.type;
	}
	
	public boolean getIsAvailable() {
		return this.isAvailable;
	}
	
	public void setIsAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public int getLicenseNumber() {
		return this.licenseNumber;
	}
	

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

//	public boolean canDeliver() {
//		if (this.type.equals("PremiumTaxi")) {
//			return false;
//		}
//		else {
//			return true;
//		}
//	}


	
}
