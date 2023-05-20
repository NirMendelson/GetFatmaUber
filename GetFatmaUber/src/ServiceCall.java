
public class ServiceCall {
	
	private Customer c;
	private Vehicle v;
	private String serviceArea;
	private double distance;
	
	// Constructs a ServiceCall object
	public ServiceCall (Customer c, Vehicle v, String serviceArea, double distance) {
		this.c = c;
		this.v = v;
		this.serviceArea = serviceArea;
		this.distance = distance;
	}
	
	// Getter for customer
	public Customer getCustomer() {
		return this.c;
	}
	
	// Getter for  vehicle
	public Vehicle getVehicle() {
		return this.v;
	}
	
	// Getter for service area
	public String getServiceArea() {
		return this.serviceArea;
	}
	
	// Getter for distance
	public double getDistance() {
		return this.distance;
	}
	
	
}
