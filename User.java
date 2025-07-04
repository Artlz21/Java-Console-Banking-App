public class User {
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;
    private final int accountID;
    private int checkingAccountID;
    private int savingsAccountID;

    public User(String firstName, String lastName, String userName, String password, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.accountID = id;
    }

    public String getFirstName() {
        return this.firstName;
    }
    
    public String getLastName() {
        return this.lastName;
    }
    
    public String getUserName() {
        return this.userName;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public int getAccountID() {
        return this.accountID;
    }
    
    public int getCheckingAccountID() {
        return this.checkingAccountID;
    }
    
    public void setCheckingAccountID(int id) {
        this.checkingAccountID = id;
    }
    
    public int getSavingsAccountID() {
        return this.savingsAccountID;
    }
    
    public void setSavingsAccountID(int id) {
        this.savingsAccountID = id;
    }
}
