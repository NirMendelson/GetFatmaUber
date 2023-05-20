import java.util.Comparator;

//Comparator implementation for comparing customers based on their age.
public class customerAgeComparator implements Comparator<Customer> {
    public int compare(Customer c1, Customer c2) {
        if (c1.getAge() < c2.getAge()) {
            return -1;
        } else if (c1.getAge() > c2.getAge()) {
            return 1;
        } else {
            return 0;
        }
    }
}
