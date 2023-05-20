import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ServiceCSVReader {
	private Company company;

	// Constructor
	public ServiceCSVReader(Company company) {
		this.company = company;
		readCSVAndCreateServiceRequests();
	}

	// reads the file and call the company service for customer function
	private void readCSVAndCreateServiceRequests() {
		String servicePath = "src\\Service_Requests.csv";
		BufferedReader reader = null;
		String line;

		try {
			reader = new BufferedReader(new FileReader(servicePath));
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				String[] row = line.split("\t");
				int serviceCustomerID = Integer.parseInt(row[0]);
				String serviceType = row[1];
				String serviceArea = row[2];
				int distance = Integer.parseInt(row[3]);
				company.serviceForCustomer(serviceCustomerID, serviceType, serviceArea, distance);
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
