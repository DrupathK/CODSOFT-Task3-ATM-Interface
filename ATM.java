
package ATMInterface;

import java.util.Scanner;

public class ATM {

    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {

        Scanner sc = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        while (true) {

            System.out.println("\n1. Withdraw Money");
            System.out.println("2. Deposit Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            System.out.print("\nEnter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {

                case "1":
                    System.out.print("Enter amount to withdraw: ");

                    try {
                        double amount = Double.parseDouble(sc.nextLine());
                        account.withdraw(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "2":
                    System.out.print("Enter amount to deposit: ");

                    try {
                        double amount = Double.parseDouble(sc.nextLine());
                        account.deposit(amount);
                    } catch (NumberFormatException e) {
                        System.out.println("Please enter a valid number.");
                    }
                    break;

                case "3":
                    account.checkBalance();
                    break;

                case "4":
                    System.out.println("Thank you for using our ATM!");
                    System.out.println("Have a nice day!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount(10000);

        ATM atm = new ATM(account);

        atm.start();
    }
}
