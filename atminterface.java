import java.util.*;
 class bankaccount {

    bankaccount(double par) {
    }
    private double balance;

    public  void bankaccount(double initialBalance){
        this.balance = initialBalance;
    }
    public double getbalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance+=amount;
        }
    }
    public boolean withdraw(double amount){
        if(amount>0&&amount<=balance){
            balance-=amount;
            return true;
        }
        return false;
    }

}

class ATM {
    private bankaccount account;
    private Scanner scanner;

    public ATM(bankaccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int option = 0;
        do {
            displayMenu();
            option = scanner.nextInt();
            processOption(option);
        } while (option != 4);
    }

    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private void processOption(int option) {
        switch (option) {
            case 1:
                checkBalance();
                break;
            case 2:
                deposit();
                break;
            case 3:
                withdraw();
                break;
            case 4:
                System.out.println("Thank you for using the ATM.hope you liked our services");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Current balance:" + account.getbalance());
    }

    private void deposit() {
        System.out.print("Enter deposit amount: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    public static void main(String[] args) {
        bankaccount account = new bankaccount(500.00); 
        ATM atm = new ATM(account);
        atm.start();
    }
}
