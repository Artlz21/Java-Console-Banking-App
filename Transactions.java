public class Transactions {
    public static boolean Deposit(CheckingAccount account, double amount) {
        try {            
            account.setBalance(account.getBalance() + (double)amount);
            return true;  
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Deposit(SavingsAccount account, double amount) {
        try {            
            account.setBalance(account.getBalance() + (double)amount);
            return true;  
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Transfer(CheckingAccount from, SavingsAccount to, double amount) {
        try {
            if (from.getBalance() < amount) {
                return false;
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);
            
            return true;
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Transfer(CheckingAccount from, CheckingAccount to, double amount) {
        try {
            if (from.getBalance() < amount) {
                return false;
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            return true;
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Transfer(SavingsAccount from, CheckingAccount to, double amount) {
        try {
            if (from.getBalance() < amount) {
                return false;
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            return true;
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Transfer(SavingsAccount from, SavingsAccount to, double amount) {
        try {
            if (from.getBalance() < amount) {
                return false;
            }

            from.setBalance(from.getBalance() - amount);
            to.setBalance(to.getBalance() + amount);

            return true;
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }

    public static boolean Withdraw(CheckingAccount account, int amount) {
        try {
            if (account.getBalance() < amount) {
                return false;
            }
            
            account.setBalance(account.getBalance() - (double)amount);
            return true;  
        } 
        catch (Exception e) {
            System.err.println("Transaction error, process did not complete");
            return false;
        }
    }
}
