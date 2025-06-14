public class SavingsAccount{
    private final int userID;
    private final int accountID;
    private double accountBalance;

    public SavingsAccount(int userID) {
        this.userID = userID;
        this.accountID = userID * 100 + 2;
        this.accountBalance = 0;
    }

	public double getBalance() {
        return this.accountBalance;
    }
    
    public void setBalance(double amount) {
        this.accountBalance = amount;
    }
    
	public int getSavingsAccountID() {
        return this.accountID;
    }
    
    public int getUserID() {
        return this.userID;
    }
}