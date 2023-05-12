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
				if (vehiclesList.get(i).getType().equals("Motorcycle")|| vehiclesList.get(i).getType().equals("Taxi")) {
					vehicleIndex = i;
					break;
				}
			}
		}

		else if (serviceType.equals("Taxi")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("Taxi")) {
					vehicleIndex = i;
					break;
				}
			}
		}
		else if (serviceType.equals("PremiumTaxi")) {
			for (int i = 0; i < vehiclesList.size(); i++) {
				if (vehiclesList.get(i).getType().equals("PremiumTaxi")) {
					vehicleIndex = i;
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
		int driverIndex = -1;
		if (this.vehiclesList.get(vehicleIndex).getType().equals("Motorcycle")) {
			for (int i = 0; i < this.driversList.size(); i++) {
				if (Arrays.asList(this.driversList.get(i).getLicense()).contains("A")) {
					this.vehiclesList.get(vehicleIndex).setDriver(this.driversList.get(i));
					driverIndex = i;
					break;
				}
			}
		}
		else {
			for (int i = 0; i < this.driversList.size(); i++) {
				if (Arrays.asList(this.driversList.get(i).getLicense()).contains("B")) {
					this.vehiclesList.get(vehicleIndex).setDriver(this.driversList.get(i));
					driverIndex = i;
					break;
				}
			}
		}

		
		// finding the employee
		ArrayList <ServiceEmployee> tempEmployeeList = new ArrayList<>();
		for (int i = 0; i < this.serviceEmployeeList.size(); i++) {
			if (serviceArea.equals(this.serviceEmployeeList.get(i).getServiceArea())) {
				tempEmployeeList.add(this.serviceEmployeeList.get(i));
			}
		}
 		System.out.println("serviceArea: " + serviceArea + ", distance: " + distance);
		
		System.out.println("Employee name:" + getMin(tempEmployeeList).getName());
		
		// storing the driver and the vehicle
		Driver chosenDriver = this.driversList.get(driverIndex);
		Vehicle chosenVehicle = this.vehiclesList.get(vehicleIndex);
		
		// checking that the age compartor works
//		customerAgeComparator ageComparator = new customerAgeComparator();
//		Customer youngestCustomer = customersList.get(0); // Assuming customersList is your list of customers
//		for (int i = 1; i < customersList.size(); i++) {
//		    Customer currentCustomer = customersList.get(i);
//		    if (ageComparator.compare(currentCustomer, youngestCustomer) < 0) {
//		        youngestCustomer = currentCustomer;
//		    }
//		}
//		System.out.println("youngest customer: " + youngestCustomer.getID());
		
		////////////////////////////////////////////////
		
		// checking deliveryVehicles
//		ArrayList <Deliverable> deliverableList = new ArrayList<>();
//		for (int i = 0; i < this.vehiclesList.size(); i++) {
//			if (this.vehiclesList.get(i).getType().equals("PremiumTaxi")) {
//			}
//			else {
//				deliverableList.add((Deliverable) this.vehiclesList.get(i));
//			}
//		}
//		this.DeliveryVehicles(deliverableList);


	
		
		// checking upgrades function
//		ArrayList <Upgradable> upgradableList = new ArrayList<>();
//		for (int i = 0; i < this.vehiclesList.size(); i++) {
//			if (this.vehiclesList.get(i).getType().equals("PremiumTaxi")) {
//				upgradableList.add((Upgradable) this.vehiclesList.get(i));
//			}
//		}
//		for (int i = 0; i < this.serviceEmployeeList.size(); i++) {
//				upgradableList.add((Upgradable) this.serviceEmployeeList.get(i));
//		}
//		
//		System.out.println("num of upgrades objects: " + this.upgrades(upgradableList));
		
		////////////////////////////////////////////////
		
		// removing the vehicle and the driver from the list
		this.driversList.remove(driverIndex);
		this.vehiclesList.remove(vehicleIndex);
		
		
		ServiceCall newServiceCall = new ServiceCall(this.customersList.get(customerIndex), chosenVehicle, serviceArea, distance);
		getMin(tempEmployeeList).Service(newServiceCall);
		
		
		// adding the vehicle and the driver to the list
		this.driversList.add(driversList.size(), chosenDriver);
		this.vehiclesList.add(vehiclesList.size(), chosenVehicle);
		
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
		double sumPayment = 0;
		int numOfCustomers = customersList.size();
		for (int i = 0; i < customersList.size(); i++) {
			sumPayment += customersList.get(i).getAllExpenses();
		}
		double averagePayment = sumPayment / numOfCustomers;
		return averagePayment;
	}
	
	public static <T extends Comparable<T>> T getMin(ArrayList<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }

        // Sort the list using natural ordering (based on compareTo method)
        Collections.sort(list);

        // Return the minimum value (first element after sorting)
        return list.get(0);
    }
	
//	public static Comparable getMin(ArrayList<? extends Comparable> list) {
//		Comparable min = list.get(0);
//		for (int i = 1; i < list.size(); i++) {
//			if (min.compareTo(list.get(i)) > 0) {
//				min = list.get(i);
//			}
//		}
//		return min;
//	}



	public static int upgrades(ArrayList<Upgradable> list) {
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
