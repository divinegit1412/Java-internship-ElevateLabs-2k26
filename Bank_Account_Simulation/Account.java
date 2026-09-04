package Bank_Account_Simulation;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private long accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transaction;

    public Account(long accountNumber , String accountHolderName){
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.transaction = new ArrayList<>();
    }

    // Setter

    public void setaccountNumber(long Number){
        this.accountNumber = Number;
    }
    public void setaccountHolderName(String Name){
        this.accountHolderName = Name;
    }
    public void addbalance(double Balance){
        double total = balance + Balance;
        this.balance = total;
    }
    public void removebalance(double Balance){
        double total = balance - Balance;
        this.balance = total;
    }
    public void setaccountTransaction(String transHistory){
        this.transaction.add(transHistory);
    }

    // Getter

     public long getaccountNumber(){
        return accountNumber;
    }
    public String getaccountHolderName(){
        return accountHolderName;
    }
    public double getbalance(){
        return balance; 
    }
    public List<String> gettransaction(){
        return transaction;
    }

    
}
