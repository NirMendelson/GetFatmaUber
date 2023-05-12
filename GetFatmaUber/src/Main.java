import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {

		ArrayList<ArrayList<?>> allLists = CSVReader.readCSVData("C:\\Users\\nirme\\git\\GetFatmaUber\\GetFatmaUber\\src\\Customers.txt.csv", "C:\\Users\\nirme\\git\\GetFatmaUber\\GetFatmaUber\\src\\Service_Requests.txt.csv");
		ArrayList<Integer> customersIDList = CSVReader.getCustomersIDList();
	    ArrayList<String> customersNameList = CSVReader.getCustomersNameList();
	    ArrayList<Integer> customersAgeList = CSVReader.getCustomersAgeList();
	    ArrayList<Character> customersGenderList = CSVReader.getCustomersGenderList();
	    ArrayList<Integer> serviceCustomersIDList = CSVReader.getServiceCustomersIDList();
	    ArrayList<String> serviceTypeList = CSVReader.getServiceTypeList();
	    ArrayList<String> serviceAreaList = CSVReader.getServiceAreaList();
	    ArrayList<Integer> distanceList = CSVReader.getDistanceList();
	    
	    Company company = new Company();
	    
	    // DRAFT //
	 
	    
	    // creating vehicles
	    // 5 Taxi, 6 Premium Taxi, 5 Delivery
	    
	    Taxi taxi1 = new Taxi(1234, "a", 1973, 0, 3);
	    Taxi taxi2 = new Taxi(1234, "a", 1989, 0, 3);
	    Taxi taxi3 = new Taxi(1234, "a", 1980, 0, 3);
	    Taxi taxi4 = new Taxi(1234, "a", 1974, 0, 3);
	    Taxi taxi5 = new Taxi(1234, "a", 1990, 0, 3);
	    
	    PremiumTaxi PTaxi1 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    PremiumTaxi PTaxi2 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    PremiumTaxi PTaxi3 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    PremiumTaxi PTaxi4 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    PremiumTaxi PTaxi5 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    PremiumTaxi PTaxi6 = new PremiumTaxi(123, "b", 1998, 0, 8, 2);
	    
	    Motorcycle motor1 = new Motorcycle(12, "c", 2001, 120, 3);
	    Motorcycle motor2 = new Motorcycle(12, "c", 2001, 120, 3);
	    Motorcycle motor3 = new Motorcycle(12, "c", 2001, 120, 3);
	    Motorcycle motor4 = new Motorcycle(12, "c", 2001, 120, 3);
	    Motorcycle motor5 = new Motorcycle(12, "c", 2001, 120, 3);
	    
	    
	    company.addVehicle(taxi1);
//	    company.addVehicle(taxi2);
//	    company.addVehicle(taxi3);
//	    company.addVehicle(taxi4);
//	    company.addVehicle(taxi5);
	    company.addVehicle(PTaxi1);
//	    company.addVehicle(PTaxi2);
//	    company.addVehicle(PTaxi3);
//	    company.addVehicle(PTaxi4);
//	    company.addVehicle(PTaxi5);
//	    company.addVehicle(PTaxi6);
	    company.addVehicle(motor1);
//	    company.addVehicle(motor2);
//	    company.addVehicle(motor3);
//	    company.addVehicle(motor4);
	    
	    


	    // creating drivers
	    // 11 B drivers and 5 A drivers
	    Driver driver1 = new Driver(1, "a", "050", 0, new String[]{"A"});
	    Driver driver2 = new Driver(2, "b", "050", 0, new String[]{"B"});
	    Driver driver3 = new Driver(3, "c", "050", 0, new String[]{"B"});
	    Driver driver4 = new Driver(4, "d", "050", 0, new String[]{"B"});
	    Driver driver5 = new Driver(5, "e", "050", 0, new String[]{"B"});
	    Driver driver6 = new Driver(6, "f", "050", 0, new String[]{"B"});
	    Driver driver7 = new Driver(7, "g", "050", 0, new String[]{"B"});
	    Driver driver8 = new Driver(8, "h", "050", 0, new String[]{"B"});
	    Driver driver9 = new Driver(9, "i", "050", 0, new String[]{"B"});
	    Driver driver10 = new Driver(10, "j", "050", 0, new String[]{"B"});
	    Driver driver11 = new Driver(11, "k", "050", 0, new String[]{"B"});
	    Driver driver12 = new Driver(12, "l", "050", 0, new String[]{"A"});
	    Driver driver13 = new Driver(13, "m", "050", 0, new String[]{"A"});
	    Driver driver14 = new Driver(14, "n", "050", 0, new String[]{"A"});
	    Driver driver15 = new Driver(15, "o", "050", 0, new String[]{"A"});
	    Driver driver16 = new Driver(16, "p", "050", 0, new String[]{"B"});
	    
	    company.addDriver(driver1);
//	    company.addDriver(driver2);
//	    company.addDriver(driver3);
//	    company.addDriver(driver4);
//	    company.addDriver(driver5);
//	    company.addDriver(driver6);
//	    company.addDriver(driver7);
//	    company.addDriver(driver8);
//	    company.addDriver(driver9);
//	    company.addDriver(driver10);
//	    company.addDriver(driver11);
//	    company.addDriver(driver12);
//	    company.addDriver(driver13);
//	    company.addDriver(driver14);
//	    company.addDriver(driver15);
	    company.addDriver(driver16);
	    

	    
	    
	    // creating Employees
	    // creating 15 employees, 4 in Jerusalem, 4 in Haifa, 4 in Beer Sheva, 3 in Tel Aviv
	    
	    ServiceEmployee employee1 = new ServiceEmployee(1, "a", 3, 19, 'M', "Haifa");
	    ServiceEmployee employee2 = new ServiceEmployee(1, "b", 4, 19, 'M', "Haifa");
	    ServiceEmployee employee3 = new ServiceEmployee(1, "c", 0, 19, 'M', "Haifa");
	    ServiceEmployee employee4 = new ServiceEmployee(1, "d", 0, 19, 'M', "Haifa");
	    ServiceEmployee employee5 = new ServiceEmployee(1, "e", 0, 19, 'M', "Jerusalem");
	    ServiceEmployee employee6 = new ServiceEmployee(1, "f", 0, 19, 'M', "Jerusalem");
	    ServiceEmployee employee7 = new ServiceEmployee(1, "g", 0, 19, 'M', "Jerusalem");
	    ServiceEmployee employee8 = new ServiceEmployee(1, "h", 0, 19, 'M', "Jerusalem");
	    ServiceEmployee employee9 = new ServiceEmployee(1, "i", 0, 19, 'M', "Beer Sheva");
	    ServiceEmployee employee10 = new ServiceEmployee(1, "j", 0, 19, 'M', "Beer Sheva");
	    ServiceEmployee employee11 = new ServiceEmployee(1, "k", 0, 19, 'M', "Beer Sheva");
	    ServiceEmployee employee12 = new ServiceEmployee(1, "l", 0, 19, 'M', "Beer Sheva");
	    ServiceEmployee employee13 = new ServiceEmployee(1, "m", 0, 19, 'M', "Tel Aviv");
	    ServiceEmployee employee14 = new ServiceEmployee(1, "n", 0, 19, 'M', "Tel Aviv");
	    ServiceEmployee employee15 = new ServiceEmployee(1, "o", 0, 19, 'M', "Tel Aviv");
	    
	    company.addSerivceEmployee(employee1);
	    company.addSerivceEmployee(employee2);
	    company.addSerivceEmployee(employee3);
	    company.addSerivceEmployee(employee4);
	    company.addSerivceEmployee(employee5);
	    company.addSerivceEmployee(employee6);
	    company.addSerivceEmployee(employee7);
	    company.addSerivceEmployee(employee8);
	    company.addSerivceEmployee(employee9);
	    company.addSerivceEmployee(employee10);
	    company.addSerivceEmployee(employee11);
	    company.addSerivceEmployee(employee12);
	    company.addSerivceEmployee(employee13);
	    company.addSerivceEmployee(employee14);
	    company.addSerivceEmployee(employee15);
	    



	    
		for (int i = 0; i < customersIDList.size(); i++) {
			Customer customer = new Customer(customersIDList.get(i), customersNameList.get(i), customersAgeList.get(i), customersGenderList.get(i));
			company.addCustomer(customer);
		}
		
		
		for (int i = 0; i < serviceCustomersIDList.size(); i++) {
			System.out.println(serviceCustomersIDList.get(i) + " " +  serviceTypeList.get(i) + " " + serviceAreaList.get(i) + " " + distanceList.get(i));
			company.serviceForCustomer(serviceCustomersIDList.get(i), serviceTypeList.get(i), serviceAreaList.get(i), distanceList.get(i));
		}
	}
}




