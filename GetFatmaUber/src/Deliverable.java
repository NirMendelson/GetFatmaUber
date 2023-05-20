
// Interface representing a deliverable item or entity.
public interface Deliverable {

    // Checks if the deliverable can be delivered.
	public abstract boolean canDeliver();
	
    // Getter for type
	public abstract String getType();
	
	// Getter for license number
	public abstract int getLicenseNumber();
	
	// Getter for year
	public abstract int getYear();

	// Getter for model
	public abstract String getModel();
	
}
