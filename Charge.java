
public class Charge {
	private String description;
	private int price;
	
	/**
	 * Creates a default (no value) charge
	 */
	public Charge() {
		description = "N/A";
		price = 0; 
	}
	/**
	 * Creates a Charge with a description and price
	 * @param description The description of the Charge
	 * @param price The price of the Charge
	 */
	public Charge(String description, int price) {
		this.description = description;
		this.price = price;
	}
	/**
	 * Returns the price of the Charge
	 * @return The price of the Charge
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * Returns a String representation of this Charge
	 * @return A String representation of this Charge
	 */
	public String toString() {
		return description + " - $" + price;
	}
}
