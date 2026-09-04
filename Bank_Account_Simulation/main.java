package Bank_Account_Simulation;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        boolean choice = true;
        while (choice) {
            System.out.println("\n===== BANK ACCOUNT SIMULATION =====");
            System.out.println("1. Add Account");
            System.out.println("2. Remove Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Display Balance");
            System.out.println("6. Display Transactions");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int ch = scanner.nextInt();
            switch (ch) {
                case 1:

                    System.out.print("Enter Account Number: ");
                    long number = scanner.nextLong();
                    scanner.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = scanner.nextLine();Account account = new Account(number, name);
                    System.out.println();
                    bank.addAccount(account);
                    System.out.println();
                    System.out.println("Account Created Successfully!");
                    break;

                case 2:

                     System.out.print("Enter Account Number: "); 
                     long removeNumber = scanner.nextLong();
                     System.out.println();
                     bank.removeAccount(removeNumber);
                    break;

                case 3:

                    System.out.print("Enter Account Number: ");
                    long depositNumber = scanner.nextLong();
                    System.out.print("Enter Amount: ");
                    double depositAmount = scanner.nextDouble();
                    System.out.println();
                    bank.deposit(depositNumber, depositAmount);
                    System.out.println();
                    break;


                case 4:
                    System.out.print("Enter Account Number: ");
                    long withdrawNumber = scanner.nextLong();
                    System.out.print("Enter Amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println();
                    bank.withdrawl(withdrawNumber, withdrawAmount);
                    System.out.println();
                    break;

                case 5:
                    System.out.print("Enter Account Number: ");
                    long balanceNumber = scanner.nextLong();
                    System.out.println();
                    bank.DisplayBalance(balanceNumber);
                    System.out.println();
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    long transactionNumber = scanner.nextLong();
                    System.out.println();
                    bank.DisplayTransaction(transactionNumber);
                    System.out.println();
                    break;
                case 7:
                    choice = false;
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }
}