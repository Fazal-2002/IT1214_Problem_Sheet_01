class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    int getAccountNumber() {
        return accountNumber;
    }

    double getBalance() {
        return balance;
    }

    void withdraw(double amount) {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber + ", Holder: " + accountHolder + ", Balance: " + balance);
    }
}

class Bank {
    private BankAccount[] accounts = new BankAccount[5];
    private int count = 0;

    void addAccount(BankAccount account) {
        if (count < 5) {
            accounts[count++] = account;
        } else {
            System.out.println("Bank is full.");
        }
    }

    void withdraw(int accountNumber, double amount) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber) {
                try {
                    accounts[i].withdraw(amount);
                    System.out.println("Withdrawn: " + amount + " from account " + accountNumber);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }
                return;
            }
        }
        System.out.println("Account not found: " + accountNumber);
    }

    void displayAll() {
        for (int i = 0; i < count; i++) {
            accounts[i].display();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdraw(1001, 6000.0);
        bank.withdraw(1002, 1000.0); 

        bank.displayAll(); 
    }
}
