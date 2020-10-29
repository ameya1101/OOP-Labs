/**
 * This class implements a bank account
 */
public class BankAccount {

    public double balance;
    public long accNo;
    public int numberOfTransaction = 0;
    public String name;
    public String address;

    protected static final int MINIMUM_BALANCE = 250;
    protected static long baseAccNo = 180020131111l;

    BankAccount(String name, String address, double balance){
        this.name = name;
        this.address = address;
        this.balance = balance;
        this.accNo = baseAccNo;
        baseAccNo += 1;
    }

    public void deposit(double amount) {
        this.balance += amount;
        this.numberOfTransaction += 1;
    }

    public double getBalance(){
        return this.balance;
    }

    public boolean withdraw(double amount) {
        if(this.balance < MINIMUM_BALANCE + amount) {
            return false;
        }

        this.balance -= amount;
        this.numberOfTransaction += 1;
        return true;
    }

    @Override
    public String toString() {
        return("Account Number: " + Long.toString(accNo) + "\n"
                + "Name: " + name + "\n"
                + "Address: " + address + "\n"
                );
    }

}