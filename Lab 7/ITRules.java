public interface ITRules {

    double taxRates[] = {10, 8, 4, 3};
    double taxSlabs[] = {100000, 75000, 30000, 10000};

    public double calculateTax(double amount);
}
