import java.util.Scanner;

public class Menu {
    public void OpeningMenu() {
        System.out.println("Big Banking Login");
        System.out.println("------------------------");
        System.out.println("Enter a number to select option.");
        System.out.println("1) Sign in");
        System.out.println("2) Create account");
        System.out.println("0) Exit");
    }

    public String[] LoginMenu() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Big Banking Login");
            System.out.println("------------------------");
            System.out.print("Enter Username: ");
            String userName =  input.nextLine();
            System.out.println("");
            System.out.print("Enter Password: ");
            String password =  input.nextLine();

            String[] userInput = {userName, password};
            return userInput;
        }
    }

    public String[] UserCreationMenu() {
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("New User Menu");
            System.out.println("------------------------");
            System.out.print("Enter First name: ");
            String firstName =  input.nextLine();
            System.out.println("");
            System.out.print("Enter Last name: ");
            String lastName =  input.nextLine();
            System.out.println("");
            System.out.print("Enter Username: ");
            String userName =  input.nextLine();
            System.out.println("");
            System.out.print("Enter Password: ");
            String password =  input.nextLine();

            String[] userInput = {firstName, lastName, userName, password};
            return userInput;
        }
    }

    public void AccountCreationMenu(User user) {
        System.out.println("Welcome " + user.getUserName() + "!");
        System.out.println("Select the type of account to create.");
        System.out.println("------------------------");
        System.out.println("1) Checking account");
        System.out.println("2) Savings account");
        System.out.println("0) Exit");        
    }

    public void UserMainMenu(User user) {
        System.out.println("Welcome " + user.getUserName() + "!");
        System.out.println("Account ID: " + user.getAccountID());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Create Savings account");
        System.out.println("2) Create Checking account");
        System.out.println("0) Exit.");
    }

    public void UserMainMenu(User user, SavingsAccount savingsAccount) {
        System.out.println("Welcome " + user.getUserName() + "!");
        System.out.println("Account ID: " + user.getAccountID());
        System.out.println("------------------------");
        System.out.println("Existing accounts:");
        System.out.println("- Savings account: " + savingsAccount.getSavingsAccountID());
        System.out.println("    Current Balance: " + savingsAccount.getBalance());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Go to Savings account");
        System.out.println("2) Create Checking account");
        System.out.println("0) Exit.");
    }

    public void UserMainMenu(User user, CheckingAccount checkingAccount) {
        System.out.println("Welcome " + user.getUserName() + "!");
        System.out.println("Account ID: " + user.getAccountID());
        System.out.println("------------------------");
        System.out.println("Existing accounts:");
        System.out.println("- Checking account: " + checkingAccount.getCheckingAccountID());
        System.out.println("    Current Balance: " + checkingAccount.getBalance());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Go to Checking account");
        System.out.println("2) Create Savings account");
        System.out.println("0) Exit.");
    }

    public void UserMainMenu(User user, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        System.out.println("Welcome " + user.getUserName() + "!");
        System.out.println("Account ID: " + user.getAccountID());
        System.out.println("------------------------");
        System.out.println("Existing accounts:");
        System.out.println("- Checking account: " + checkingAccount.getCheckingAccountID());
        System.out.println("    Current Balance: " + checkingAccount.getBalance());
        System.out.println("- Savings account: " + savingsAccount.getSavingsAccountID());
        System.out.println("    Current Balance: " + savingsAccount.getBalance());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Go to Checking account");
        System.out.println("2) Go to Savings account");
        System.out.println("0) Exit.");
    }

    public void AccountMenu(CheckingAccount checkingAccount) {
        System.out.println("User ID: " + checkingAccount.getUserID());
        System.out.println("Account ID: " + checkingAccount.getCheckingAccountID());
        System.out.println("Current Balance: " + checkingAccount.getBalance());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Deposit");
        System.out.println("2) Transfer");
        System.out.println("3) Withdraw");
        System.out.println("0) Exit.");
    }

    public void AccountMenu(SavingsAccount savingsAccount) {
        System.out.println("User ID: " + savingsAccount.getUserID());
        System.out.println("Account ID: " + savingsAccount.getSavingsAccountID());
        System.out.println("Current Balance: " + savingsAccount.getBalance());
        System.out.println("------------------------");
        System.out.println("Select an option");
        System.out.println("1) Deposit");
        System.out.println("2) Transfer");
        System.out.println("0) Exit.");
    }
}