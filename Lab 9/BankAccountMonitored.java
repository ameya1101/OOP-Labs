public class BankAccountMonitored extends BankAccount{
    private DoublyLinkedList<Action> transactions;
    private Action lastAct;

    public BankAccountMonitored(String name, String address, double balance){
        super(name, address, balance);
        transactions = new DoublyLinkedList<Action>();
        this.lastAct = new Action();
    }

    public class Action{
        public String act;
        public double amount;
        private int tid;


        public Action(){
            this.act = null;
            this.amount = 0;
            this.tid = 0;
        }


        public Action(String act, double amount){
            this.act = act;
            this.amount = amount;
            this.tid = lastAct.tid + 1;
            lastAct.tid = this.tid;
        }

        @Override
        public String toString() {
            return ( "(" + act + ", " + amount + ", " + tid +  ")" );
        }

        public int getTID(){
            return tid;
        }
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        transactions = DoublyLinkedList.append(transactions, new Action("Deposit", amount));
    }

    @Override
    public boolean withdraw(double amount) {
        super.deposit(amount);
        transactions = DoublyLinkedList.append(transactions, new Action("Withdrawal", amount));
        return true;
    }

    public void printActions(){
        System.out.println("All Actions: ");
        DoublyLinkedList.print(transactions);
        System.out.println();
    }

    public void printDeposits(){
        System.out.println("Deposits: ");
        DoublyLinkedList.Node<Action> current = transactions.first;

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
        DoublyLinkedList.Node<Action> current = transactions.first;

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

    public void deleteTransaction(int tranID){
        DoublyLinkedList.Node<Action> current = transactions.first;
        int pos = 1;
        int flag = 0;

        while(current.next != null){
            if(((Action)current.data).tid == tranID){
                flag = 1;
                break;
            }
            current = current.next;
            pos++;
        }

        if(flag == 1)
            transactions = transactions.delete(transactions, pos);
        else
            System.out.println("Transaction could not be found");
    }

    public void printFirstSecond(){
        DoublyLinkedList.Node<Action> current = transactions.first;
        System.out.println(current.data + ", " + current.next.data + ", " + current.next.prev.data);
    }
}
