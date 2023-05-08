import java.util.ArrayList;

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
	    // 5 Taxi, 6 Premium Taxi, 5 Delivery
	    
	    Taxi taxi1 = new Taxi(1234, "a", 1990, 0, 3);
	    Taxi taxi2 = new Taxi(1234, "a", 1990, 0, 3);
	    Taxi taxi3 = new Taxi(1234, "a", 1990, 0, 3);
	    Taxi taxi4 = new Taxi(1234, "a", 1990, 0, 3);
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
	    company.addVehicle(taxi2);
	    company.addVehicle(taxi3);
	    company.addVehicle(taxi4);
	    company.addVehicle(taxi5);
	    company.addVehicle(PTaxi1);
	    company.addVehicle(PTaxi2);
	    company.addVehicle(PTaxi3);
	    company.addVehicle(PTaxi4);
	    company.addVehicle(PTaxi5);
	    company.addVehicle(PTaxi6);
	    company.addVehicle(motor1);
	    company.addVehicle(motor2);
	    company.addVehicle(motor3);
	    company.addVehicle(motor4);
	    company.addVehicle(motor5);





	    		
	    // (int licenseNumber, String model, int year, int maxSpeed, double engineDisplacement) {
	    
	    //(int licenseNumber, String model, int year, double baseFare, int maxPassengers, double luxuryCharge

	    
	    		
//	    (int licenseNumber, String model, int year, double baseFare, int maxPassengers)
	    
		for (int i = 0; i < customersIDList.size(); i++) {
			Customer customer = new Customer(customersIDList.get(i), customersNameList.get(i), customersAgeList.get(i), customersGenderList.get(i));
			company.addCustomer(customer);
		}
		
		for (int i = 0; i < serviceCustomersIDList.size(); i++) {
			company.serviceForCustomer(serviceCustomersIDList.get(i), serviceTypeList.get(i), serviceAreaList.get(i), distanceList.get(i));
		}
	}
}




