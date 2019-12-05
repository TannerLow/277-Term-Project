import java.util.ArrayList;

public class TransactionLog {
	private ArrayList<String> transactions;
	
	/**
	 * Creates a TransactionLog
	 */
	public TransactionLog() {
		transactions = new ArrayList<>();
	}
	
	/**
	 * Add a transaction to the log
	 * @param s The transcation to add
	 */
	public void addTransaction(String s) {
		transactions.add(s);
	}
	
	/**
	 * Returns a String representation of the log
	 * @return A String representation of the log
	 */
	public String toString() {
		String s = "";
		for(String t : transactions) {
			s += t + "\n";
		}
		return s;
	}
}
