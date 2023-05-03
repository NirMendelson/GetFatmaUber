import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVReader {

	public static void main(String[] args) {
		
		String customersPath = "Customers.txt";
//		String serviceRequestsPath = "Service_Requests.txt";
		
		BufferedReader inFile=null;
		try
		{
		  	FileReader fr = new FileReader (customersPath);
		inFile = new BufferedReader (fr);
		}

		catch (FileNotFoundException exception)
		{
		 System.out.println ("The file " + customersPath + " was not found.");
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
		
		


	}
	
}
