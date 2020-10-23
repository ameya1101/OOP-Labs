public class LoansAccount extends Account {
    public static int num = 5000;
    private float interestRate;
    private int period;

    public LoansAccount(int amount, float rate, int period){
        super(amount);
        this.interestRate = rate;
        this.period = period;
        this.accountNumber = "loan" + Integer.toString(++num);
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getReturns(){
        double interest = principalAmount * (Account.pow(1.0 + (((double)interestRate)/100), period));
        return interest;
    }
}
