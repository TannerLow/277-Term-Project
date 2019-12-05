import java.util.ArrayList;

public class TransactionLog {
	private ArrayList<String> transactions;
	
	public TransactionLog() {
		transactions = new ArrayList<>();
	}
	
	public void addTransaction(String s) {
		transactions.add(s);
	}
	
	public String toString() {
		String s = "";
		for(String t : transactions) {
			s += t + "\n";
		}
		return s;
	}
}
