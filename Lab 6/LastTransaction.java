public class LastTransaction {
    protected String lastTransaction;

    public void setTransaction(String transactionType) {
        this.lastTransaction = transactionType;
    }

    @Override
    public String toString() {
        return lastTransaction;
    }
}
