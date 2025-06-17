import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
    }

    private void StartApp() {
        Scanner input = new Scanner(System.in);
        String[] inputLong;
        boolean run = true;
        int selector;
        Menu menu = new Menu();
        DataHandling data = new DataHandling();

        
        while (run) {
            
        }
    }

    private boolean CheckForExistingUser(DataHandling data, String[] userInput) {
        return data.RetrieveUser(userInput[0], userInput[1]) != null;
    }
    
    private void ChangeMenuDisplay(int state, Menu menu, User user) {
        switch (state) {
            case 1:
                menu.LoginMenu();
                break;
            case 2:
                menu.UserCreationMenu();
                break;
            case 3:
                menu.AccountCreationMenu(user);
                break;
            case 4:
                menu.UserMainMenu(user);
                break;
            }
        }

    private void ChangeMenuDisplay(int state, Menu menu, User user, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        switch (state) {
            case 1:
                menu.LoginMenu();
                break;
            case 2:
                menu.UserCreationMenu();
                break;
            case 3:
                menu.AccountCreationMenu(user);
                break;
            case 4:
                menu.UserMainMenu(user, checkingAccount, savingsAccount);
                break;
            case 5:
                menu.UserMainMenu(user, checkingAccount);
                break;
            case 6:
                menu.UserMainMenu(user, savingsAccount);
                break;
            case 7:
                menu.AccountMenu(checkingAccount);
                break;
            case 8:
                menu.AccountMenu(savingsAccount);
                break;
        }

    private void ChangeMenuDisplay(int state, Menu menu, User user, CheckingAccount checkingAccount, SavingsAccount savingsAccount) {
        switch (state) {
            case 1:
                menu.LoginMenu();
                break;
            case 2:
                menu.UserCreationMenu();
                break;
            case 3:
                menu.AccountCreationMenu(user);
                break;
            case 4:
                menu.UserMainMenu(user, checkingAccount, savingsAccount);
                break;
            case 5:
                menu.UserMainMenu(user, checkingAccount);
                break;
            case 6:
                menu.UserMainMenu(user, savingsAccount);
                break;
            case 7:
                menu.AccountMenu(checkingAccount);
                break;
            case 8:
                menu.AccountMenu(savingsAccount);
                break;
        }
    }
}
