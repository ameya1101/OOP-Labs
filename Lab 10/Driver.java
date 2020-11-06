public class Driver {

    public static void main(String[] args){
        BankAccountMonitored bankPerson = new BankAccountMonitored("John Smith", "10, Some Street", 5000);

        bankPerson.withdraw(50);
        bankPerson.withdraw(100);
        bankPerson.deposit(3000);
        bankPerson.deposit(900);
        bankPerson.deposit(10000);
        bankPerson.withdraw(4000);

        bankPerson.printDeposits();
        bankPerson.printWithdrawals();

        bankPerson.displayWithdrawal(102);

        bankPerson.deleteDeposit(200);

        bankPerson.printDeposits();

        bankPerson.displayWithdrawal(105);
    }

}
