/**
 * This class implements a bank account
 */
public class BankAccount {
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
    private String lastTran;

    // Name of the user
    private String name;

    // Address of the user
    private String address;

    // Minimum required balance 
    private static final int MINIMUM_BALANCE = 250;

    // A Base account number
    private static long baseAccNo = 180020131111l;

    /**
     * Contructor for BankAccount. It also assigns a unique account number to each object.
     * @param name Name of the user
     * @param address Address of the user
     * @param balance Opeining balance
     */
    BankAccount(String name, String address, double balance){
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accNo = baseAccNo;
        baseAccNo += 1;
    }

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