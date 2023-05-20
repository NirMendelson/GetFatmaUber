
public class ServiceEmployee implements Comparable <ServiceEmployee>, Upgradable{

	private int ID;
	private String name;
	private double rating;
	private int age;
	private char gender;
	private String serviceArea;
	private double bonus;
	private int callsMade;
	private int callsMadeInLatestUpgrade;
	private int numOfRatings;

	// Constructs a ServiceEmployee object.
	// Throws a InvalidGenderException if the gender is not M or F.

	public ServiceEmployee(int ID, String Name, double rating, int age, char gender, String serviceArea) {
	    this.ID = ID;
	    this.name = Name;
	    this.rating = rating;
	    this.age = age;
	    this.serviceArea = serviceArea;
	    this.bonus = this.rating * 2;

	    if (gender != 'M' && gender != 'F') {
	        throw new InvalidGenderException("Invalid gender: " + gender);
	    } else {
	        this.gender = gender;
	    }
	}

	// Performs the service for a given service call, updating relevant information such as calls made, customer payment ect.
	public void Service(ServiceCall sc) {
		
		// update calls made
		this.callsMade++;
		
		// making the customer pay
		sc.getCustomer().pay(sc.getVehicle().calculateDrivingTime(sc.getDistance()), sc.getVehicle().getFare());

		System.out.println("GetFatimaUber is here for you!");
		System.out.println("Driver name: " + sc.getVehicle().getDriver().getName());
		System.out.println("License number: " + sc.getVehicle().getLicenseNumber());
		System.out.println("Model: " + sc.getVehicle().getModel());
		System.out.println("Duration: " + sc.getVehicle().calculateDrivingTime(sc.getDistance()));
		System.out.println("Payment: " + sc.getCustomer().getLatestExpense());
		System.out.println("Enjoy!");

		// updating drivers profit
		sc.getVehicle().getDriver().addToAllEarnings(sc.getCustomer().getLatestExpense());

		// updating the employee's rating
		sc.getCustomer().giveRating();
		this.setRating(sc.getCustomer().getRatingToDriver());
		System.out.println("rating customer gave: " + sc.getCustomer().getRatingToDriver());
		System.out.println("Employee rating: " + this.getRating());

		// updating the driver's rating
		sc.getVehicle().getDriver().setRating(sc.getCustomer().getRatingToDriver());
		System.out.println("Drivers rating: " + sc.getVehicle().getDriver().getRating());

		// updating the employee's bonus
		this.setBonus(sc.getCustomer().getRatingToDriver() * 2);
		
		System.out.println("driver Earnings: " + sc.getVehicle().getDriver().getAllEarnings());
		
		// disconnent between the vehicle and the driver
		sc.getVehicle().setDriver(null);

	}

	// Getter for bonus
	public double getBonus() {
		return this.bonus;
	}

	// Getter for service area
	public String getServiceArea() {
		return this.serviceArea;
	}

	// Setter for bonus
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	// Setter for rating
	public void setRating(double rating) {
		this.numOfRatings++;
		this.rating = (this.rating + rating)/this.numOfRatings ;
	}
	
	// Getter for rating
	public double getRating() {
		return this.rating;
	}

	// Getter for name
	public String getName() {
		return this.name;
	}

	// Setter for calls made in latest upgrade
	public void setCallsMadeInLatestUpgrade(int calls) {
		this.callsMadeInLatestUpgrade = calls;
	}

	// Uses Comparable
	public int compareTo(ServiceEmployee other) {
		if (this.getBonus() > other.getBonus()) {
			return 1;
		}
		else if (other.getBonus() > this.getBonus()) {
			return -1;
		} 
		else {
			return 0;
		}
	}

	// Uses Upgradable
	public boolean upgrade() {
		if (this.callsMade >= this.callsMadeInLatestUpgrade * 2) {
			if (this.bonus*2 > 16) {
				this.setBonus(16);
			}
			else {
				this.setBonus(bonus*2);
			}
			this.setCallsMadeInLatestUpgrade(this.callsMade);
			return true;
		}
		else {
			return false;
		}
	}

}
