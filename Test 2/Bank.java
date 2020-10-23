public class Bank implements IBank {
    
    public SavingsAccount[] sv;
    public FixedDeposit[] fd;
    public LoansAccount[] ln;
    
    public int numFDS = 0;
    

    public int numLoans = 0;
    

    public int numSV = 0;
    

    public Bank() {
        fd = new FixedDeposit[MAX_FDS];
        sv = new SavingsAccount[MAX_SAVINGS_ACCOUNT];
        ln = new LoansAccount[MAX_LOANS];
    }

    public boolean createAccount(char type, int amount, float interestRate, int period) {

        if (type == 'f') {
            if (numFDS >= MAX_FDS)
                return false;
            
            FixedDeposit fdAccount = new FixedDeposit(amount, interestRate, period);

            fd[numFDS] = fdAccount;
            numFDS += 1;

            return true;
        }
        else if (type == 's') {
            if (numSV >= MAX_SAVINGS_ACCOUNT)
                return false;
            
            SavingsAccount savingsAccount = new SavingsAccount(amount, interestRate, period);

            sv[numSV] = savingsAccount;
            numSV += 1;

            return true;
        }
        else if (type == 'l') {
            if (numLoans >= MAX_LOANS)
                return false;
            
            LoansAccount loansAccount = new LoansAccount(amount, interestRate, period);

            ln[numLoans] = loansAccount;
            numLoans += 1;

            return true;
        }

        return false;
    }

    public boolean deleteAccount(String accno) {

        if (accno.indexOf("fd") == 0) {
            for (int i = 0; i < numFDS; i++)
            {
                if (fd[i].getAccountNumber().equals(accno)) {

                    for (int j = i + 1; i < numFDS-1 && j < numFDS; i++, j++) {
                        fd[i] = fd[j];
                    }

                    fd[numFDS-1] = null;
                    numFDS -= 1;
                    return true;
                }
            }
        }
        else if (accno.indexOf("sav") == 0) {
            for (int i = 0; i < numSV; i++)
            {
                if (sv[i].getAccountNumber().equals(accno)) {

                    for (int j = i + 1; i < numSV-1 && j < numSV; i++, j++) {
                        sv[i] = sv[j];
                    }

                    sv[numSV-1] = null;
                    numSV -= 1;
                    return true;
                }
            }
        }
        else if (accno.indexOf("loan") == 0) {
            for (int i = 0; i < numLoans; i++)
            {
                if (ln[i].getAccountNumber().equals(accno)) {

                    for (int j = i + 1; i < numLoans-1 && j < numLoans; i++, j++) {
                        ln[i] = ln[j];
                    }

                    ln[numLoans-1] = null;
                    numLoans -= 1;
                    return true;
                }
            }
        }

        return false;
    }

    public double profitFromLoans() {
        double totReturns = 0;
        double totPrincipalAmount = 0;

        for (int i = 0; i < numLoans; i++)
        {
            totReturns += ln[i].getReturns();
            totPrincipalAmount += ln[i].getPrincipalAmount();
        }

        return totReturns - totPrincipalAmount;
    }

    public double interestToPay() {

        double totReturns = 0;
        double totPrincipalAmount = 0;

        for (int i = 0; i < numFDS; i++)
        {
            totReturns += fd[i].getReturns();
            totPrincipalAmount += fd[i].getPrincipalAmount();
        }

        for (int i = 0; i < numSV; i++)
        {
            totReturns += sv[i].getReturns();
            totPrincipalAmount += sv[i].getPrincipalAmount();
        }

        return totReturns - totPrincipalAmount;
    }
}
