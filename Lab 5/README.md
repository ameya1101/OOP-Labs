## Lab 5

Create three classes `CheckingAccount`, `SavingsAccount` and `FDAccount` that inherit `BankAccount` created in Lab4.

- A `CheckingAccount` has a small number of free transactions, with additional transaction being charged. These transactions are tracked by the field `transactionCount`. Also create a method `deductFees` that deducts the transaction fee and resets `transactionCount`. Modify other inherited methods accordingly.

- A `SavingsAccount` earns an interest that compounds monthly. This interest is represented by the field `interestRate`. Also create a method `addInterest` that credits this amount. 

- A `FDAccount` has the following features:
    - Variable interest based on term for which invested (6% for upto 12 months, 7% for 12-36 months) and 8% for > 36 months; 

    - No withdrawals allowed; only one deposit/transfer is permitted. 

Finally, generate a UML class diagram for the class hierarchy.