## Lab 4

Create a `BankAccount` class which has:
- Variables that store the balance; assigns a unique account number to each user (starting from 180020131111); stores the number of valid transactions; stores the name and address of the user; and finally, stores the last type of transaction carried out by the user.
- The bank also has a minimum balance that the user must maintain.
- A constructor which initialises the name, address and assigns an opening balance.
- The methods:
    - `deposit` which accepts a double value;
    - `withdraw` which accepts a double value and carries out the transaction only if value + minimum balance is lesser than balance.
    - `getBalance` which returns the present balance
    - `transfer` with transfers money between two bank accounts
- Override the `toString` method to print the account details of the user. 