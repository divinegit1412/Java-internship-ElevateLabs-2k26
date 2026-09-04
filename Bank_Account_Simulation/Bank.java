package Bank_Account_Simulation;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    
    private List<Account> accounts;

    public Bank() {
        this.accounts = new ArrayList<>();
    }

   
    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(long accountNumber) {
        for (Account acc : accounts) {
            if (acc.getaccountNumber() == accountNumber) {
                accounts.remove(acc);
                System.out.println("Account Removed Successfully!");
                return;
            }
        }
        System.out.println("Account not found!");
    }

    public void deposit(long account, double amount){
        for(Account acc : accounts){

            if( acc.getaccountNumber() == account){
                acc.addbalance(amount);
                double Total = acc.getbalance();
                acc.setaccountTransaction("Amount : "+ amount + " is deposited, Total balance : "+ Total +" in " + acc.getaccountHolderName() + " Account");
                System.out.println("Deposit");
                return;
            }
            
        }
        System.out.println("Account not found!");
    }


    public void withdrawl(long account, double amount){

        for(Account acc : accounts){
            if( acc.getaccountNumber() == account){
                if(acc.getbalance() >= amount){
                acc.removebalance(amount);
                double Total = acc.getbalance();
                acc.setaccountTransaction("Amount : "+ amount + " is withdrawn, Total balance : "+ Total +" in " + acc.getaccountHolderName() + " Account");
                System.out.println("Withdrawal Successful!");
                return;
                }
                else{
                    System.out.println("Insufficient Balance!");
                    return;
                }                
            }
            
        }
        System.out.println("Account not found!");
    }

    public void DisplayTransaction(long accountNumber){
        for(Account acc : accounts){
            if( acc.getaccountNumber() == accountNumber){
                List<String> allTrans = acc.gettransaction();
                if(allTrans == null){
                        System.out.println("No Transaction History!");
                        return;
                    }
                for( String s : allTrans){
                    System.out.println(s);
                }
                return;
            }
            
        }
        System.out.println("Account not found!");
    }


    public void DisplayBalance(long account){
        for(Account acc : accounts){
            if( acc.getaccountNumber() == account){
                double Total = acc.getbalance();
                System.out.println("Total Balance :"+ Total);
                return;
            }
            
        }
        System.out.println("Account not found!");
    }
    
}
