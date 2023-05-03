import java.util.ArrayList;

public class Company {
	
	private ArrayList<Customer> customersList;
	private ArrayList<Vehicle> vehiclesList;
	private ArrayList<ServiceEmployee> serviceEmployeeList;
	private ArrayList<Driver> driversList;
	
	public Company() {
		this.customersList = new ArrayList<Customer>();
		this.vehiclesList = new ArrayList<Vehicle>();
		this.serviceEmployeeList = new ArrayList<ServiceEmployee>();
		this.driversList = new ArrayList<Driver>();
	}
	
	public void addCustomer(Customer c) {
		this.customersList.add(c);
	}
	
	public void addVehicle(Vehicle v) {
		this.vehiclesList.add(v);
	}
	
	public void addSerivceEmployee(ServiceEmployee se) {
		this.serviceEmployeeList.add(se);
	}
	
	public void addDriver(Driver driver) {
		this.driversList.add(driver);
	}

	public boolean serviceForCustomer(int customerID, String serviceType, String serviceArea, double distance) {
		// finding the customer
		int customerIndex = 0;
		for (int i = 0; i < customersList.size(); i++) {
			if (customersList.get(i).getID() == customerID) {
				customerIndex = i;
			}
		}
		
		// finding the vehicle
		int vehicleIndex = 0;
		if (serviceType.equals("Delivery")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Motorcycle") || vehiclesList.get(i).getType().equals("Taxi")) {
					vehicleIndex = i;
					vehiclesList.get(i).setOccupied(true);
					break;
				}
			}
		}
		else if (serviceType.equals("Taxi")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Taxi")) {
					vehicleIndex = i;
					vehiclesList.get(i).setOccupied(true);
					break;
				}
			}
		}
		else {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Premium Taxi")) {
					vehicleIndex = i;
					vehiclesList.get(i).setOccupied(true);
					break;
				}
			}
		}
		
		// finding the employee
		double minBonus = this.serviceEmployeeList.get(0).getBonus();
		int employeeIndex = 0;
		for (int i = 1; i < this.serviceEmployeeList.size(); i++) {
			if (this.serviceEmployeeList.get(i).getBonus() < minBonus) {
				minBonus = this.serviceEmployeeList.get(i).getBonus();
				employeeIndex = i;
			}
		}
	}
	
	
	Customer c, Vehicle v, String serviceArea, double distance
	
	this.customerList.get(customerIndex), this.vehiclesList.get(vehicleIndex), String serviceArea, double distance
	
	public static double totalRevenues {
		
	}
	
	public static double avgCustomerPayment {
		
	}
	
	public static Comparable getMin {
		
	}

	public static int upgrades {
		
	}
	
	public static void DeliveryVehicles {
		
	}
	
}
