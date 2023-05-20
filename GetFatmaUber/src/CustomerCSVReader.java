import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerCSVReader {
    private Company company;

    // Constructor 
    public CustomerCSVReader(Company company) {
        this.company = company;
        readCSVAndCreateCustomers();
    }
    
    // reads the file and add the customers to the company
    private void readCSVAndCreateCustomers() {
        String customersPath = "src\\Customers.csv";
        BufferedReader reader = null;
        String line;
        ArrayList<Customer> customersList = new ArrayList<>();

        try {
            reader = new BufferedReader(new FileReader(customersPath));
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] row = line.split("\t");
                int customerID = Integer.parseInt(row[0]);
                String name = row[1];
                int age = Integer.parseInt(row[2]);
                char gender = row[3].charAt(0);
                Customer customer = new Customer(customerID, name, age, gender);
                company.addCustomer(customer);
                customersList.add(customer);
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
