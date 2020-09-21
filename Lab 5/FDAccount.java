public class FDAccount extends BankAccount {
    
    // Term length for the deposit
    private int term;
    
    // The interest rate
    private double interestRate;

    /**
     * Contructor for BankAccount. It also assigns a unique account number to each object.
     * @param name Name of the user
     * @param address Address of the user
     * @param balance Opeining balance
     * @param term Term period for the deposit
     */
    public FDAccount(String name, String address, double balance, int term){
        super(name, address, balance);
        this.term = term;

        if(this.term <= 12) {
            this.interestRate = 6.0;
        }

        else if(this.term > 12 && this.term <= 36){
            this.interestRate = 7;
        }
        else {
            this.interestRate = 8;
        }
    }

    /**
     * A method that implements the deposit transaction. Only one deposit is permitted.
     * @param amount Amount to be deposited.
     */
    @Override
    public void deposit(double amount) {
        if(this.numberOfTransaction < 1){
            super.deposit(amount);
        }
    }

    /**
     * Method that implements the withdrawal function. No withdrawals are allowed.
     */
    @Override
    public boolean withdraw(double amount) {
        return false;
    }

}
