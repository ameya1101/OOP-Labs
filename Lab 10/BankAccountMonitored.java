import java.util.*;

public class BankAccountMonitored extends BankAccount{
    private List<Action> deposits;
    private HashMap<Integer, Action> withdrawals;
    

    public BankAccountMonitored(String name, String address, double balance){
        super(name, address, balance);
        this.deposits = new LinkedList<Action>();
        this.withdrawals = new HashMap<Integer, Action>();
    }

    public class Action{
        public String act;
        public double amount;
        private int tid;


        public Action(String act, double amount, int tid){
            this.act = act;
            this.amount = amount;
            this.tid = tid;
        }

        @Override
        public String toString() {
            return ( "(Type: " + act + ", Amount: " + amount + ", TID: " + tid +  ")" );
        }

        public int getTID(){
            return tid;
        }
    }

    @Override
    public void deposit(double amount) {
        Action depositAction = new Action("deposit", amount, this.deposits.size() + 200);
        this.deposits.add(depositAction);
    }

    @Override
    public boolean withdraw(double amount) {
        if(super.withdraw(amount)){
            Action withdrawAction = new Action("withdrawal", amount, this.withdrawals.size() + 100);
            this.withdrawals.put(withdrawAction.getTID(), withdrawAction);
            return true;
        }
        
        return false;
    }


    public void printDeposits(){

        System.out.println("---------Deposits---------");
        
        ListIterator<Action> depositsIterator = deposits.listIterator();
        while(depositsIterator.hasNext()){
            System.out.println(depositsIterator.next() + ", ");
        }

        System.out.println();
    }

    public void printWithdrawals(){
        System.out.println("---------Withdrawals---------");

        for (Action withdrawActions : withdrawals.values()){
            System.out.println(withdrawActions);
        }

        System.out.println();
	}
	
	public boolean displayWithdrawal(int tranID){
		if(withdrawals.containsKey(tranID)){
			System.out.println(withdrawals.get(tranID));
			return true;
		}
		
		else {
			throw new NoSuchElementException("Withdrawal with ID " + tranID + " was not found.");
		}
	}

    public void deleteDeposit(int tranID){

		System.out.println("\nRequested deletion of deposit with transaction ID " + tranID);

       	ListIterator<Action> depositsIterator = deposits.listIterator();

        while(depositsIterator.hasNext()){
            if(depositsIterator.next().getTID() == tranID){
                depositsIterator.remove();
            }
		}
		
		System.out.println("Deletion successful.");
    }
}
