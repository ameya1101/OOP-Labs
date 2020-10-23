abstract class Account {
    protected int principalAmount;
    protected String accountNumber;

    public Account(int amount){
        this.principalAmount = amount;
    }

    public abstract String getAccountNumber();
    public abstract double getReturns();

    public int getPrincipalAmount(){
        return principalAmount;
    }

    public static double pow(double a, int b){
        double result = Math.pow(a, b);
        return result;
    }

}
