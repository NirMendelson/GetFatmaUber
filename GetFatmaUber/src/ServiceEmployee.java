
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
		
		if (gender > 4 || gender < 1) {
			throw new RuntimeException("gender is invalid");
		}
		else {
			this.gender = gender;
		}
	}
	
	public void Service(ServiceCall sc) {
//		this.callsMade++;
//		if (sc.getVehicle().canDeliver()) {
//			
//		}
	}
	
	public double getBonus() {
		return this.bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public void setCallsMadeInLatestUpgrade(int calls) {
		this.callsMadeInLatestUpgrade = calls;
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
