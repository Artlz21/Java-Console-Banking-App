import java.util.ArrayList;
import java.util.Random;

public class CheckingAccount extends Account {
    private final int accountID;
    private double accountBalance;
    private ArrayList<String> transactionHistory = new ArrayList<>();

    public CheckingAccount() {
        Random random = new Random();
        this.accountID = getAccountID() * 1000 + (1000 + random.nextInt(9000));
        this.accountBalance = 0;
    }

	public double getBalance() {
        return this.accountBalance;
    }
    public void setBalance(double amount) {
        this.accountBalance += amount;
    }
    @Override
	public int getCheckingAccountID() {
        return this.accountID;
    }
	public ArrayList<String> getTransactionHistory() {
        return this.transactionHistory;
    }
	public void setTransactionHistory(String transaction) {
        this.transactionHistory.add(transaction);
    }
}