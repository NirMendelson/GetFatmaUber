import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
	
	static String[] customerData;
	static String[] serviceData;
	static ArrayList<Integer> customersIDList = new ArrayList<>();
	static ArrayList<String> customersNameList = new ArrayList<>();
	static ArrayList<Integer> customersAgeList = new ArrayList<>();
	static ArrayList<String> customersGenderList = new ArrayList<>();
	static ArrayList<Integer> serviceCustomersIDList = new ArrayList<>();
	static ArrayList<String> serviceTypeList = new ArrayList<>();
	static ArrayList<String> serviceAreaList = new ArrayList<>();
	static ArrayList<Integer> distanceList = new ArrayList<>();


	public static void main(String[] args) {

		String customersPath = "C:\\Users\\nirme\\git\\GetFatmaUber\\GetFatmaUber\\src\\Customers.txt.csv";
		String servicePath = "C:\\Users\\nirme\\git\\GetFatmaUber\\GetFatmaUber\\src\\Service_Requests.txt.csv";

		BufferedReader inFile=null;
		try
		{
			// Read data from the first file
			FileReader fr = new FileReader(customersPath);
			inFile = new BufferedReader(fr);
			// read and ignore the first row
			inFile.readLine();

			String line;
			int lineNumber = 0; // add a line number counter
			while ((line = inFile.readLine()) != null) {
				if (lineNumber == 1) { // if it's the first row, skip it
					lineNumber++;
					continue;
				}
				customerData = line.split("'");
				int customerID = Integer.parseInt(customerData[1]);
				String name = customerData[3];
				int age = Integer.parseInt(customerData[5]);
				String gender = customerData[7];
				customersIDList.add(customerID);
				customersNameList.add(name);
				customersAgeList.add(age);
				customersGenderList.add(gender);
				lineNumber++;
			}

			// Read data from the second file
			fr = new FileReader(servicePath);
			inFile = new BufferedReader(fr);
			// read and ignore the first row
			inFile.readLine();

			lineNumber = 0;
			while ((line = inFile.readLine()) != null) {
				if (lineNumber == 1) { // if it's the first row, skip it
					lineNumber++;
					continue;
				}
				serviceData = line.split("'");
				int serviceCustomerID = Integer.parseInt(serviceData[1]);
				String serviceType = serviceData[3];
				String serviceArea = serviceData[5];
				int distance = Integer.parseInt(serviceData[7]);
				serviceCustomersIDList.add(serviceCustomerID);
				serviceTypeList.add(serviceType);
				serviceAreaList.add(serviceArea);
				distanceList.add(distance);
				lineNumber++;
			}
		}

		catch (FileNotFoundException exception)
		{
			System.out.println ("The file was not found.");
		}
		catch (IOException exception)
		{
			System.out.println (exception);
		}
		finally{
			try{
				inFile.close();
			} catch(IOException exception){
				exception.printStackTrace();
			}
		}

		System.out.println(distanceList);
	}
}
