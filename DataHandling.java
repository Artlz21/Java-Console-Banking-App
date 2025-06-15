import java.util.HashMap;
import java.util.Random;

public class DataHandling {
    private final HashMap<String, Integer> userNameStorage;
    private final HashMap<Integer, User> usersStorage;
    private final HashMap<Integer, CheckingAccount> checkingAccountsStorage;
    private final HashMap<Integer, SavingsAccount> savingsAccountsStorage;

    public DataHandling() {
        userNameStorage = new HashMap<>();
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
        User newUser = new User(firstName, secondName, userName, password, id);
        userNameStorage.put(userName, id);
        usersStorage.put(id, newUser);
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

    public User RetrieveUser(String userName, String password) {
        try {
            Integer id = userNameStorage.get(userName);
            User targetUser = usersStorage.get(id);
            return targetUser;
        } 
        catch (Exception e) {
            System.err.println("Error user could not be retrieved.");
            return null;
        }
    }
    
    public CheckingAccount RetrieveChecking(int id) {
        try {
            return checkingAccountsStorage.get(id);
        } 
        catch (Exception e) {
            System.err.println("Error account could not be retrieved.");
            return null;
        }
    }
    
    public SavingsAccount RetrieveSavings(int id) {
        try {
            return savingsAccountsStorage.get(id);
        } 
        catch (Exception e) {
            System.err.println("Error account could not be retrieved.");
            return null;
        }
    }
}
