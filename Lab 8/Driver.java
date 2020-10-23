public class Driver {

    public static void main(String[] args){
        BankAccountMonitored b1 = new BankAccountMonitored("Ameya", "#10, 3rd Street", 2330);
        b1.deposit(100);
        b1.withdraw(50);
        b1.deposit(150);
        b1.withdraw(10);
        b1.deposit(210);
        b1.deposit(50);

        b1.printActions();
        b1.printDeposits();
        b1.printWithdrawals();

    }

}
