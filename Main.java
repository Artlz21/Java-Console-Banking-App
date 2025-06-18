import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StartApp();
    }

    private static void StartApp() {
        Scanner input = new Scanner(System.in);
        Menu menu = new Menu();
        DataHandling data = new DataHandling();
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

                    checkingAccount = data.RetrieveChecking(user.getAccountID());
                    savingsAccount = data.RetrieveSavings(user.getAccountID());

                    showUserMenu(input, user, checkingAccount, savingsAccount, menu, data);
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

                    showUserMenu(input, user, checkingAccount, savingsAccount, menu, data);
                    break;

                default:
                    System.out.println("Exiting...");
                    runApp = false;
                    break;
            }
        }
    }

    private static void showUserMenu(Scanner input, User user, CheckingAccount checking, SavingsAccount savings, Menu menu, DataHandling data) {
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
                    // Access account
                    if (checking != null && savings != null) {
                        System.out.println("Select account to access:");
                        System.out.println("1) Checking");
                        System.out.println("2) Savings");
                        int acctChoice = input.nextInt();
                        input.nextLine();

                        if (acctChoice == 1) {
                            handleCheckingMenu(input, checking, savings);
                        } else if (acctChoice == 2) {
                            handleSavingsMenu(input, savings, checking);
                        }
                    } else if (checking != null) {
                        handleCheckingMenu(input, checking, savings);
                    } else if (savings != null) {
                        handleSavingsMenu(input, savings, checking);
                    } else {
                        System.out.println("No accounts found.");
                    }
                    break;

                case 2:
                    // Create additional account
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

    private static void handleCheckingMenu(Scanner input, CheckingAccount checking, SavingsAccount savings) {
        Menu menu = new Menu();
        menu.AccountMenu(checking);
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1: // Deposit
                System.out.print("Enter amount to deposit: ");
                double deposit = input.nextDouble();
                input.nextLine();
                if (Transactions.Deposit(checking, deposit)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Deposit failed.");
                }
                break;
            case 2: // Transfer to savings
                if (savings == null) {
                    System.out.println("No savings account to transfer to.");
                    break;
                }
                System.out.print("Enter amount to transfer to savings: ");
                double transfer = input.nextDouble();
                input.nextLine();
                if (Transactions.Transfer(checking, savings, transfer)) {
                    System.out.println("Transfer successful.");
                } else {
                    System.out.println("Transfer failed. Check funds.");
                }
                break;
            case 3: // Withdraw
                System.out.print("Enter amount to withdraw: ");
                int withdraw = input.nextInt();
                input.nextLine();
                if (Transactions.Withdraw(checking, withdraw)) {
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Withdrawal failed. Check funds.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void handleSavingsMenu(Scanner input, SavingsAccount savings, CheckingAccount checking) {
        Menu menu = new Menu();
        menu.AccountMenu(savings);
        int option = input.nextInt();
        input.nextLine();

        switch (option) {
            case 1: // Deposit
                System.out.print("Enter amount to deposit: ");
                double deposit = input.nextDouble();
                input.nextLine();
                if (Transactions.Deposit(savings, deposit)) {
                    System.out.println("Deposit successful.");
                } else {
                    System.out.println("Deposit failed.");
                }
                break;
            case 2: // Transfer to checking
                if (checking == null) {
                    System.out.println("No checking account to transfer to.");
                    break;
                }
                System.out.print("Enter amount to transfer to checking: ");
                double transfer = input.nextDouble();
                input.nextLine();
                if (Transactions.Transfer(savings, checking, transfer)) {
                    System.out.println("Transfer successful.");
                } else {
                    System.out.println("Transfer failed. Check funds.");
                }
                break;
            case 0:
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static boolean CheckForExistingUser(DataHandling data, String[] userInput) {
        User user = data.RetrieveUser(userInput[0]);
        return user != null && user.getPassword().equals(userInput[1]);
    }
}
