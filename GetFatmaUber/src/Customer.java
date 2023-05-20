import java.util.Random;

public class Customer implements Comparable <Customer>  {

	private int ID;
	private String name;
	private int age;
	private char gender;
	private double allExpenses = 10;
	private double latestExpense = 0; 
	private int ratingToDriver = 0;

	// Constructs a Customer object
	public Customer (int ID, String name, int age, char gender) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	// Decide the rating 
	public int giveRating() {
		Random random = new Random();
		this.ratingToDriver = random.nextInt(5) + 1;
		return this.ratingToDriver;
	}

	// Getter for Rating to driver
	public int getRatingToDriver() {
		return this.ratingToDriver;
	}

	// Calculates how much to pay, add to all expenses and return latest expense
	public double pay(double time, double Fare) {
		this.latestExpense = (2*time + Fare);
		this.allExpenses = this.allExpenses + this.latestExpense;
		return this.latestExpense;
	}

	// Getter for all expenses
	public double getAllExpenses() {
		return this.allExpenses;
	}

	// Getter for ID
	public int getID() {
		return this.ID;
	}

	// Getter for latest expense
	public double getLatestExpense() {
		return this.latestExpense;
	}

	// Getter for age
	public int getAge() {
		return this.age;
	}

	// Uses Comparable
	public int compareTo(Customer other) {
		if (this.getAllExpenses() > other.getAllExpenses()) {
			return 1;
		}
		else if (other.getAllExpenses() > this.getAllExpenses()) {
			return -1;
		} 
		else {
			return 0;
		}
	}

	// Uses Comparator to compare age
	public int compareAge(Customer other) {
		customerAgeComparator ageComparator = new customerAgeComparator();
		return ageComparator.compare(this, other);
	}
}
