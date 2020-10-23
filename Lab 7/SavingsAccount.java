public class SavingsAccount extends BankAccount {
    
    // The interest rate
    private double interestRate;
    private double taxDeducted;

    /**
     * Contructor for SavingsAccount. It also assigns a unique account number to each object.
     * @param name Name of the user
     * @param address Address of the user
     * @param balance Opeining balance
     * @param interestRate The interest rate
     */
    public SavingsAccount(String name, String address, double balance, double interestRate){
        super(name, address, balance);
        this.interestRate = interestRate;
    }

    /**
     * Deposits the interest into the account.
     */
    public void addInterest(){
        double interest = this.balance * (interestRate/100);
        taxDeducted = calculateTax(interest);
        deposit(interest - taxDeducted);
    }
}
