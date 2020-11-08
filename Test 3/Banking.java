import java.util.*;

class SavingAccount {

    private ArrayList<SavingAccount.LoanAccount> loanAcc;

    public SavingAccount(){
        this.loanAcc = new ArrayList<SavingAccount.LoanAccount>();
    }

    
    ArrayList<SavingAccount.LoanAccount> getLoanList(){
        return this.loanAcc;
    }

    int requestLoan(String loanID, double Amt){
        if(loanAcc.size() < 3){
            int numActive = 0;
            for(LoanAccount acct : loanAcc){
                if(acct.loanStatus == 200)
                    numActive += 1;
            }

            if(numActive < 2){
                LoanAccount newLoanAcc = new LoanAccount(loanID, Amt);
                loanAcc.add(newLoanAcc);
                return 1;
            }
        }
        return 0;
    }

    LoanAccount getLoanObject(int index){
        return loanAcc.get(index);
    }

    class LoanAccount{
        private double loanAmt;
        private String loanID;
        private int loanStatus;
        private double rem_loanAmt;

        public LoanAccount(String loanID, double loanAmt){
            this.loanID = loanID;
            this.loanAmt = loanAmt;
            this.rem_loanAmt = this.loanAmt;
            this.loanStatus = 200;
        }

        public void depositAmt(String LoanID, int Amt){
            this.rem_loanAmt -= Amt;
            if(rem_loanAmt <= 0){
                loanStatus = 500;
            }
        }

        public int getStatus(){
            return loanStatus;
        }

        public double getTotalLoanAmount(){
            return loanAmt;
        }
    }

}

public class Banking {
    public static void main(String[] args) {
        // #1
        SavingAccount S1 = new SavingAccount();
        SavingAccount S2 = new SavingAccount();

        // #2
        System.out.println(S1.requestLoan("S1.1", 10000));

        // #3
        S2.requestLoan("S2.1", 12000);
        S2.requestLoan("S2.2", 15000);

        // #4
        SavingAccount.LoanAccount S1_1 = S1.getLoanObject(0);
        S1_1.depositAmt("S1.1", 10000); 
        System.out.println(S1_1.getStatus());
        
        // #5
        System.out.println(S2.requestLoan("S2.3", 20000));

        // #6
        SavingAccount.LoanAccount S2_2 = S2.getLoanObject(1);
        S2_2.depositAmt("S2.2", 15000); 
        System.out.println(S2_2.getStatus());

        // #7
        System.out.println(S2.requestLoan("S2.4", 25000));

        // #8
        System.out.println(S2.requestLoan("S2.5", 30000));



    }
}
