import java.util.HashMap;
import java.util.Random;

public class DataHandling {
    private HashMap<Integer, User> usersStorage;
    private HashMap<Integer, CheckingAccount> checkingAccountsStorage;
    private HashMap<Integer, SavingsAccount> savingsAccountsStorage;

    public DataHandling() {
        usersStorage = new HashMap<>();
        checkingAccountsStorage = new HashMap<>();
        savingsAccountsStorage = new HashMap<>();
    }

    public User CreateUser(String firstName, String secondName, String password, String userName) {
        Random random = new Random();
        int id = 1000 + random.nextInt(9000);
        while (usersStorage.containsKey(id)){
            id = 1000 + random.nextInt(9000);
        }
        User newUser = new User(firstName, firstName, userName, password, id);
        usersStorage.put(usersStorage.size()+1, newUser);
        return newUser;
    }

    public CheckingAccount CreateCheckingAccount(int userID) {
        CheckingAccount newCheckingAccount = new CheckingAccount(userID);
        checkingAccountsStorage.put(checkingAccountsStorage.size()+1, newCheckingAccount);
        return newCheckingAccount;
    }

    public SavingsAccount CreateSavingsAccount(int userID) {
        SavingsAccount newSavingsAccount = new SavingsAccount(userID);
        savingsAccountsStorage.put(savingsAccountsStorage.size()+1, newSavingsAccount);
        return newSavingsAccount;
    }

    public User RetrieveUser(int accountID, String password) {
        User targetUser = usersStorage.get(accountID);
        return targetUser;
    }
    public CheckingAccount RetrieveChecking(int id) {
        return checkingAccountsStorage.get(id);
    }
    public SavingsAccount RetrieveSavings(int id) {
        return savingsAccountsStorage.get(id);
    }
}
