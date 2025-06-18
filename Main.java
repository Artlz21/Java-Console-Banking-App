import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StartApp();
    }

    private static void StartApp() {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        DataHandling data = new DataHandling();
        Transactions transaction = new Transactions();
        User user = null;

        boolean runApp = true;

        while (runApp) {
            menu.OpeningMenu();
            int choice = input.nextInt();
            input.nextLine(); // Consume newline

            String[] userInput;
            boolean verified;
            CheckingAccount checkingAccount = null;
            SavingsAccount savingsAccount = null;

            switch (choice) {
                case 1: // Login
                    userInput = menu.LoginMenu();
                    verified = CheckForExistingUser(data, userInput);

                    if (!verified) {
                        System.out.println("Invalid username or password.");
                        break;
                    }

                    user = data.RetrieveUser(userInput[0]);

                    // Assume both might exist (simplified example)
                    checkingAccount = data.RetrieveChecking(user.getAccountID());
                    savingsAccount = data.RetrieveSavings(user.getAccountID());

                    showUserMenu(input, user, checkingAccount, savingsAccount, menu, data, transaction);
                    break;

                case 2: // Sign up
                    userInput = menu.UserCreationMenu();
                    verified = CheckForExistingUser(data, userInput);

                    if (verified) {
                        System.out.println("Username already exists.");
                        break;
                    }

                    user = data.CreateUser(userInput[0], userInput[1], userInput[2], userInput[3]);
                    menu.AccountCreationMenu(user);
                    int acctChoice = input.nextInt();
                    input.nextLine();

                    if (acctChoice == 1)
                        checkingAccount = data.CreateCheckingAccount(user.getAccountID());
                    else if (acctChoice == 2)
                        savingsAccount = data.CreateSavingsAccount(user.getAccountID());

                    showUserMenu(input, user, checkingAccount, savingsAccount, menu, data, transaction);
                    break;

                default:
                    System.out.println("Exiting...");
                    runApp = false;
                    break;
            }
        }
    }

    private static void showUserMenu(Scanner input, User user, CheckingAccount checking, SavingsAccount savings, Menu menu, DataHandling data, Transactions transaction) {
        boolean userMenu = true;
        while (userMenu) {
            if (checking != null && savings != null) {
                menu.UserMainMenu(user, checking, savings);
            } else if (checking != null) {
                menu.UserMainMenu(user, checking);
            } else if (savings != null) {
                menu.UserMainMenu(user, savings);
            } else {
                menu.AccountCreationMenu(user);
            }

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    if (checking != null) {
                        menu.AccountMenu(checking);
                        int option = input.nextInt();
                        input.nextLine();
                        // Add transaction logic here
                    } else if (savings != null) {
                        menu.AccountMenu(savings);
                        int option = input.nextInt();
                        input.nextLine();
                        // Add transaction logic here
                    }
                    break;
                case 2:
                    if (checking == null) {
                        checking = data.CreateCheckingAccount(user.getAccountID());
                    } else if (savings == null) {
                        savings = data.CreateSavingsAccount(user.getAccountID());
                    }
                    break;
                case 0:
                    userMenu = false;
                    break;
                default:
                    System.out.println("Invalid selection.");
            }
        }
    }

    private static boolean CheckForExistingUser(DataHandling data, String[] userInput) {
        return data.RetrieveUser(userInput[0]) != null;
    }
}
