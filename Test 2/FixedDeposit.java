public class FixedDeposit extends Account{

    public static int num = 1000;
    private float interestRate;
    private int period;

    public FixedDeposit(int amount, float rate, int period){
        super(amount);
        this.interestRate = rate;
        this.period = period;
        this.accountNumber = "fd" + Integer.toString(++num);
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getReturns(){
        double interest = principalAmount * (Account.pow(1.0 + (((double)interestRate)/100), period));
        return interest;
    }
}
