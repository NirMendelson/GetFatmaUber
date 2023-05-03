
public class ServiceCall {
	
	private Customer c;
	private Vehicle v;
	private String serviceArea;
	private double distance;
	
	public ServiceCall (Customer c, Vehicle v, String serviceArea, double distance) {
		this.c = c;
		this.v = v;
		this.serviceArea = serviceArea;
		this.distance = distance;
	}
	
	public Customer getCustomer() {
		return this.c;
	}
	
	public Vehicle getVehicle() {
		return this.v;
	}
	
	public String getServiceArea() {
		return this.serviceArea;
	}
	
	public double getDistance() {
		return this.distance;
	}
	
	
}
