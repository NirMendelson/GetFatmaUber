
public class ServiceEmployee {

	private int ID;
	private String name;
	private double rating;
	private int age;
	private char gender;
	private String serviceArea;
	
	public ServiceEmployee (int ID, String Name, double rating, int age, char gender, String
			serviceArea) {
	
		this.ID = ID;
		this.name = name;
		this.rating = rating;
		this.age = age;
		this.gender = gender;
		this.serviceArea = serviceArea;
	}
	
	public void Service(ServiceCall sc) {
		
	}

}
