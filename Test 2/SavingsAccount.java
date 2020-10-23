public class SavingsAccount extends Account {
    public static int num = 2000;
    private float interestRate;
    private int period;
    private char[] lastFiveTransactions;

    public SavingsAccount(int amount, float rate, int period){
        super(amount);
        this.interestRate = rate;
        this.period = period;
        this.accountNumber = "sav" + Integer.toString(++num);
        lastFiveTransactions = new char[5];
    }

    public String getAccountNumber(){
        return this.accountNumber;
    }

    public double getReturns(){
        double interest = ((principalAmount) * (interestRate * period))/100;
        return interest + principalAmount;
    }

    public void deposit(int amount){
        this.principalAmount += amount;
        assignTransaction('d');
    }

    public boolean withdraw(int amount){
        if(amount > this.principalAmount){
            return false;
        }
        this.principalAmount -= amount;
        assignTransaction('w');
        return true;
    }

    public String getLastFiveTransactions(){
        String lastFive = new String(lastFiveTransactions);
        return lastFive;
    }

    private void assignTransaction(char tran){
        for(int i = 0; i < 4; i++){
            lastFiveTransactions[i] = lastFiveTransactions[i+1];
        }

        lastFiveTransactions[4] = tran;
    } 

}
