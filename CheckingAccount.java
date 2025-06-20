public class CheckingAccount {
    private final int userID;
    private final int accountID;
    private double accountBalance;

    public CheckingAccount(int userID) {
        this.userID = userID;
        this.accountID = userID * 100 + 1;
        this.accountBalance = 0;
    }

	public double getBalance() {
        return this.accountBalance;
    }

    public void setBalance(double amount) {
        this.accountBalance = amount;
    }
    
	public int getCheckingAccountID() {
        return this.accountID;
    }

    public int getUserID() {
        return this.userID;
    }
}