import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
		
		System.out.println("started service for customer");
		// finding the customer
		System.out.println("customerID: " + customerID);
		int customerIndex = -1;
		for (int i = 0; i < customersList.size(); i++) {
			if (customersList.get(i).getID() == customerID) {
				customerIndex = i;
			}
		}
		if (customerIndex == -1) {
			System.out.println("Request is rejected because customerID is invalid");
			return false;
		}
		System.out.println("customerIndex: " + customerIndex);

		// finding the vehicle
		int vehicleIndex = -1;
		if (serviceType.equals("Delivery")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Motorcycle") &&  vehiclesList.get(i).getIsAvailable() == false|| vehiclesList.get(i).getType().equals("Taxi") && vehiclesList.get(i).getIsAvailable() == false) {
					vehicleIndex = i;
					vehiclesList.get(i).setIsAvailable(false);
					break;
				}
			}
		}

		else if (serviceType.equals("Taxi")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Taxi")) {
					vehicleIndex = i;
					vehiclesList.get(i).setIsAvailable(false);
					break;
				}
			}
		}
		else if (serviceType.equals("Premium Taxi")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Premium Taxi")) {
					vehicleIndex = i;
					vehiclesList.get(i).setIsAvailable(false);
					break;
				}
			}
		}
		else {
			System.out.println("Request is rejected because service type is invalid");
			return false;
		}
		System.out.println("vehicleIndex: " + vehicleIndex);

		if (vehicleIndex == -1) {
			System.out.println("Request is rejected because there are no available vehicles");
		}
		
		// finding the driver
		if (this.vehiclesList.get(vehicleIndex).getType().equals("Motorcycle")) {
			for (int i = 0; i < this.driversList.size(); i++) {
				if (Arrays.asList(this.driversList.get(i).getLicense()).contains("A")) {
					this.vehiclesList.get(vehicleIndex).setDriver(this.driversList.get(i));
					this.driversList.get(i).setIsAvailable(false);
				}
			}
		}
		else {
			for (int i = 0; i < this.driversList.size(); i++) {
				if (Arrays.asList(this.driversList.get(i).getLicense()).contains("B")) {
					this.vehiclesList.get(vehicleIndex).setDriver(this.driversList.get(i));
					this.driversList.get(i).setIsAvailable(false);
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
		System.out.println("employeeIndex: " + employeeIndex);
		System.out.println("serviceArea: " + serviceArea + ", distance: " + distance);
		
		System.out.println("Employee name:" + this.serviceEmployeeList.get(employeeIndex).getName());
		
		ServiceCall newServiceCall = new ServiceCall(this.customersList.get(customerIndex), this.vehiclesList.get(vehicleIndex), serviceArea, distance);
		this.serviceEmployeeList.get(employeeIndex).Service(newServiceCall);
		
		
		System.out.println("finished service for customer");
		return true;
	}
	
	public static double totalRevenues(ArrayList<Driver> driversList) {
		double totalRevenue = 0;
		for (int i = 0; i < driversList.size(); i++) {
			totalRevenue += driversList.get(i).getAllEarnings();
		}
		return totalRevenue;
	}
	
	public static double avgCustomerPayment(ArrayList<Customer> customersList) {
		double averagePayment = 0;
		for (int i = 0; i < customersList.size(); i++) {
			averagePayment += customersList.get(i).getAllExpenses();
		}
		return averagePayment;
	}
	
	public static Comparable getMin(ArrayList<? extends Comparable> list) {
	    if (list.isEmpty()) {
	        throw new IllegalArgumentException("List is empty.");
	    }

	    Comparable min = list.get(0);
	    for (int i = 1; i < list.size(); i++) {
	        Comparable current = list.get(i);
	        if (current.compareTo(min) < 0) {
	            min = current;
	        }
	    }

	    return min;
	}



	public static int upgrades(ArrayList<Upgrades> list) {
	    int numOfUpdraded = 0;
	    for (int i = 0; i < list.size(); i++) {
	    	if (list.get(i).upgrade()) {
	    		numOfUpdraded++;
	    	}
	    }
	    return numOfUpdraded;
	}

	
	public static void DeliveryVehicles(ArrayList<Deliverable> list) {
		System.out.println("Deliverable vehicles:");
		for (int i = 0; i < list.size(); i++) {
			System.out.println("Type:" + list.get(i).getType() + ", License: " + list.get(i).getLicenseNumber() + ", Model: " + list.get(i).getModel() + ", Year: " + list.get(i).getYear());
		}
	}
	
}
