public class CheckingAccount extends BankAccount {
    private final int FREE_TRANSACTIONS = 10;
    private final int transactionFee = 2;
    private int transactionCount; 

    /**
     * Contructor for CheckingAccount. It also assigns a unique account number to each object.
     * @param name Name of the user
     * @param address Address of the user
     * @param balance Opeining balance
     */
    public CheckingAccount(String name, String address, double balance) {
        super(name, address, balance);
        transactionCount = 0;
    }

    /**
     * Implements the withdrawal transaction. 
     * @param amount Amount to be withdrawn.
     * @return True if transaction was successful, else false.
     */
    @Override
    public boolean withdraw(double amount) {
        if(super.withdraw(amount)){
            this.transactionCount += 1;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * A method that implements the deposit transaction.
     * @param amount Amount to be deposited.
     */
    @Override
    public void deposit(double amount){
        super.deposit(amount);
        transactionCount += 1;
    }

    /**
     * Deducts a fee if the number of transactions exceeds the number of free transactions
     */
    public void deductFees(){
        int chargedTransactions = (transactionCount - FREE_TRANSACTIONS);
        if(chargedTransactions > 0) {
            withdraw(chargedTransactions * transactionFee);
        }
        transactionCount = 0;
    }

}