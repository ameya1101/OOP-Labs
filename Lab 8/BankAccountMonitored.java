public class BankAccountMonitored extends BankAccount{
    private LinkedList<Action> transactions;

    public BankAccountMonitored(String name, String address, double balance){
        super(name, address, balance);
        transactions = new LinkedList<Action>();
    }

    public class Action{
        public String act;
        public double amount;
        Action(String act, double amount){
            this.act = act;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return ("(" + act + ", " + amount + ")");
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions = LinkedList.append(transactions, new Action("Deposit", amount));
    }

    @Override
    public boolean withdraw(double amount) {
        super.deposit(amount);
        transactions = LinkedList.append(transactions, new Action("Withdrawal", amount));
        return true;
    }

    public void printActions(){
        System.out.println("All Actions: ");
        LinkedList.print(transactions);
        System.out.println();
    }

    public void printDeposits(){
        System.out.println("Deposits: ");
        LinkedList.Node<Action> current = transactions.first;

        while(current.next != null){
            if(((Action)current.data).act.equals("Deposit")){
                System.out.println(current.data);
            }
            current = current.next;
        }

        if(((Action)current.data).act.equals("Deposit")){
            System.out.println(current.data);
        }

        System.out.println();
    }

    public void printWithdrawals(){
        System.out.println("Withdrawals: ");
        LinkedList.Node<Action> current = transactions.first;

        while(current.next != null){
            if(((Action)current.data).act.equals("Withdrawal")){
                System.out.println(current.data);
            }
            current = current.next;
        }

        if(((Action)current.data).act.equals("Withdrawal")){
            System.out.println(current.data);
        }

        System.out.println();
    }
}
