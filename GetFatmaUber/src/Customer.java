import java.util.Random;

public class Customer implements Comparable <Customer>  {

	private int ID;
	private String name;
	private int age;
	private char gender;
	private double expenses = 10;
	
	public Customer (int ID, String name, int age, char gender) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public int giveRating() {
		Random random = new Random();
	    return random.nextInt(5) + 1;
	}
	
	public double pay(double time, double Fare) {
		this.expenses = this.expenses + (2*time + Fare);
		return 2*time + Fare;
	}
	
	public double getExpenses() {
		return this.expenses;
	}
	
	public int getAge() {
		return this.age;
	}

	public int compareTo(Customer other) {
		if (this.getExpenses() > other.getExpenses()) {
			return 1;
		}
		else if (other.getExpenses() > this.getExpenses()) {
			return -1;
		} 
		else {
			return 0;
		}
	}
	
	public int compareAge(Customer other) {
        customerAgeComparator ageComparator = new customerAgeComparator();
        return ageComparator.compare(this, other);
    }
}
