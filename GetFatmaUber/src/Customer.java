import java.util.Random;

public class Customer implements Comparable <Customer>  {

	private int ID;
	private String name;
	private int age;
	private char gender;
	private double allExpenses = 10;
	private double latestExpense = 0; 
	private int ratingToDriver = 0;
	
	public Customer (int ID, String name, int age, char gender) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public int giveRating() {
		Random random = new Random();
		this.ratingToDriver = random.nextInt(5) + 1;
	    return random.nextInt(5) + 1;
	}
	
	public int getGiveRating() {
		return this.giveRating();
	}
	
	public double pay(double time, double Fare) {
		this.latestExpense = (2*time + Fare);
		this.allExpenses = this.allExpenses + this.latestExpense;
		return this.latestExpense;
	}
	
	public double getAllExpenses() {
		return this.allExpenses;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public double getLatestExpense() {
		return this.latestExpense;
	}
	
	public int getAge() {
		return this.age;
	}

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
	
	public int compareAge(Customer other) {
        customerAgeComparator ageComparator = new customerAgeComparator();
        return ageComparator.compare(this, other);
    }
}
