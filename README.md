# 💳 Big Banking CLI Application (Java)

This is a Java-based command-line interface (CLI) banking application that allows users to create accounts, manage their checking and savings accounts, and perform transactions like deposits, withdrawals, and transfers.

---

## 📋 Requirements

1. User should be prompted to **log in** or **create an account**.
2. On account creation, user should choose to create a **checking or savings account** if neither exists.
3. Users should see a menu displaying existing accounts and be able to **interact** with them.
4. Users should be able to **create a new checking or savings account** if one does not exist.
5. Upon entering an account, users should be prompted with a **transaction menu**:
    - View balance
    - Withdraw funds
    - Deposit funds
    - Transfer funds
6. Balance inquiry should display current balance.
7. Withdrawals should prompt and verify amount before proceeding.
8. Deposits should prompt and verify amount before adding to balance.
9. Transfers should prompt for **target account number** and **amount**.
10. Transfer should **verify account exists** and require user confirmation.
11. User should be able to **exit the app** once finished.

---

## 🧱 Class Breakdown

### `Menu`
Handles all **CLI and UI interactions**. It presents menus for login, account creation, account operations, etc.

#### Methods
- `LoginMenu()`
- `UserCreationMenu()`
- `AccountCreationMenu(User user)`
- `UserMainMenu(User user)`
- `UserMainMenu(User user, CheckingAccount)`
- `UserMainMenu(User user, SavingsAccount)`
- `UserMainMenu(User user, CheckingAccount, SavingsAccount)`
- `AccountMenu(CheckingAccount account)`
- `AccountMenu(SavingsAccount account)`

---

### `User`
Handles **user data** and account relationships.

#### Attributes
- `firstName`
- `lastName`
- `userName`
- `password`
- `accountID`
- `checkingAccountID`
- `savingsAccountID`

#### Methods
- `getCheckingAccountID()`
- `setCheckingAccountID(int)`
- `getSavingsAccountID()`
- `setSavingsAccountID(int)`
- `getUserName()`
- `getAccountID()`

---

### `CheckingAccount` & `SavingsAccount`
Handle account-specific data like balance and IDs.

#### Attributes
- `accountID`
- `userID`
- `balance`

#### Methods
- `getBalance()`
- `setBalance(double)`
- `getAccountID()`
- `getUserID()`

---

### `Transactions`
Handles **all financial actions**: deposits, withdrawals, and transfers between accounts.

#### Methods
- `Deposit(CheckingAccount, double)`
- `Deposit(SavingsAccount, double)`
- `Withdraw(CheckingAccount, int)`
- `Transfer(CheckingAccount, CheckingAccount, double)`
- `Transfer(CheckingAccount, SavingsAccount, double)`
- `Transfer(SavingsAccount, CheckingAccount, double)`
- `Transfer(SavingsAccount, SavingsAccount, double)`

---

### `DataHandling`
Acts as an in-memory **data layer**, storing and managing all user and account data.

#### Attributes
- `HashMap<String, Integer> userNameStorage`
- `HashMap<Integer, User> usersStorage`
- `HashMap<Integer, CheckingAccount> checkingAccountsStorage`
- `HashMap<Integer, SavingsAccount> savingsAccountsStorage`

#### Methods
- `CreateUser(String, String, String, String)`
- `CreateCheckingAccount(int userID)`
- `CreateSavingsAccount(int userID)`
- `RetrieveUser(String userName)`
- `RetrieveChecking(int accountID)`
- `RetrieveSavings(int accountID)`

---

### `Main`
The **controller class** that runs the program and connects all components.

#### Responsibilities
- Display initial menus
- Handle user input and routing
- Validate login credentials
- Switch between app states
- Route data to/from storage and UI
- Perform transaction logic

#### Key Methods
- `StartApp()`
- `CheckForExistingUser(DataHandling, String[] userInput)`
- `showUserMenu(...)`

---

## 🚀 Getting Started

To compile and run the application:

```bash
javac *.java
java Main
