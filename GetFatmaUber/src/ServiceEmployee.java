
public class ServiceEmployee {

	private int ID;
	private String name;
	private double rating;
	private int age;
	private char gender;
	private String serviceArea;
	private double bonus;
	private int callsMade;
	private int callsMadeInLatestUpgrade;
	
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String
			serviceArea) {
	
		this.ID = ID;
		this.name = Name;
		this.rating = rating;
		this.age = age;
		this.serviceArea = serviceArea;
		this.bonus = this.rating*2;
		
		if (gender != 'M' && gender != 'F') {
			throw new RuntimeException("gender is invalid");
		}
		else {
			this.gender = gender;
		}
	}
	
	public void Service(ServiceCall sc) {
		if (sc.getServiceArea().equals(this.serviceArea)) {
			
			System.out.println("GetFatimaUber is here for you!");
			System.out.println("Driver name: " + sc.getVehicle().getDriver().getName());
			System.out.println("License number: " + sc.getVehicle().getLicenseNumber());
			System.out.println("Model: " + sc.getVehicle().getModel());
			System.out.println("Duration: " + sc.getVehicle().calculateDrivingTime());
			System.out.println("Payment: " + sc.getCustomer().getLatestExpense());
			System.out.println("Enjoy!");
			
			// updating drivers profit
			sc.getVehicle().getDriver().addToAllEarnings(sc.getVehicle().getDriver().drivingProfit(sc.getCustomer(), sc.getVehicle().calculateDrivingTime(), sc.getVehicle()));
			
			// updating the employee's rating
			this.setRating(sc.getCustomer().getGiveRating());
			
			// updating the driver's rating
			sc.getVehicle().getDriver().setRating(sc.getCustomer().getGiveRating());
			
			// updating the employee's bonus
			this.setBonus(sc.getCustomer().getGiveRating() * 2);
			

			// updating the driver and vehicle availability 
			sc.getVehicle().setIsAvailable(true);
			sc.getVehicle().getDriver().setIsAvailable(true);
		}
		else {
			System.out.println("Wrong service area");
		}
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setCallsMadeInLatestUpgrade(int calls) {
		this.callsMadeInLatestUpgrade = calls;
	}
	
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
