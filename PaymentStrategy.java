/**
 * Objects inheriting PaymentStrategy are able to pay(value) for a value
 */
public interface PaymentStrategy {
	/**
	 * Pay for an amount
	 * @param amount Amount to pay for
	 * @return String
	 */
	 public String pay(int amount);
}
