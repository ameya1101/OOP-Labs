import java.io.Serializable;

/**
 * This class implements a bank account
 */
abstract class BankAccount implements ITRules, Comparable<BankAccount>, Serializable {
    /** 
     * The account balance
    */
    public double balance;

    /**
     * The user's account number
     */
    public long accNo;

    /**
     * Number of successful transactions by the user
     */
    public int numberOfTransaction = 0;

    // Type of last transaction by the user
    protected String lastTran;

    // Name of the user
    public String name;

    // Address of the user
    public String address;

    // Minimum required balance 
    protected static final int MINIMUM_BALANCE = 250;

    // A Base account number
    protected static long baseAccNo = 180020131111l;

    /**
     * A method that implements the deposit transaction.
     * @param amount Amount to be deposited.
     */
    public void deposit(double amount) {
        this.balance += amount;
        this.numberOfTransaction += 1;
        this.lastTran = "Deposit";
    }

    /**
     * Getter method for the account balance.
     * @return Current account balance.
     */
    public double getBalance(){
        return this.balance;
    }

    /**
     * Implements the withdrawal transaction. 
     * @param amount Amount to be withdrawn.
     * @return True if transaction was successful, else false.
     */
    public boolean withdraw(double amount) {
        if(this.balance < MINIMUM_BALANCE + amount) {
            return false;
        }

        this.balance -= amount;
        this.lastTran = "Withdraw";
        this.numberOfTransaction += 1;
        return true;
    }

    public double calculateTax(double amount){
        for(int i = 0; i < taxSlabs.length-1; i++){
            if(amount > taxSlabs[i]){
                return amount * (taxRates[i]/100);
            }
        }
        return 0;
    }

    public int compareTo(BankAccount other) {
        if(this.balance > other.balance){
            return 1;
        }
        else if(this.balance < other.balance){
            return -1;
        }
        
        return 0;
    }

    /**
     * Method to implement the transfer transaction. 
     * @param sender The person sending the money.
     * @param recipient The person recieving the money.
     * @param amount The amount to be transferred.
     * @return True if transaction was successful, else false.
     */
    public static boolean transfer(BankAccount sender, BankAccount recipient, int amount) {
        
        if(sender.withdraw(amount)) {
            recipient.deposit(amount);
            sender.lastTran = "Transfer";
            recipient.lastTran = "Transfer";
            return true;
        }

        return false;
    }

    /**
     * Function to return account details.
     */
    @Override
    public String toString() {
        return("Account Number: " + Long.toString(accNo) + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Last Transaction: " + lastTran + "\n");
    }

}