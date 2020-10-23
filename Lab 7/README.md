## Lab 7

1. Create a class hierarchy as follows:

    Abstract Class(es): `BankAccount`
    Subclasses: `SavingsAccount`, `FDAccount`, `CheckingAccount`

2. Create an interface `ITRules`
    - It defines 4 income tax slabs: (a) >10,000: 3%, (b) >30,000: 4%,  (c) >75,000: 8%,  (d) >1,00,000: 10%
    - It has a method `double calculateTax(double)`. The method will use the double argument passed to it to calculate tax using the slabs given.

3. All BankAccounts should implement the `ITRules`, `Comparable` and `Serializable` interfaces. 

4. Modify the method `addInterest` to call the method `calculateTax` with the interest as the argument. The (interest-calculated tax) amount is then deposited and a variable `taxDeducted` is set to the amount calculated as tax.

5. For the BankAccount hierarchy, draw a complete class diagram to include all the classes made in the labs.


