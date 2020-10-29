## Lab 9

1. Extend the `BankAccount` class to create a `BankAccountMonitored` class:
    - This will have an `Action` class.
    - Add a new member variable to the Action class called `tid` (Rransaction ID). It will be private and of type `int`.
    - This will also maintain a Doubly Linked List of Actions in every object.
    - Create objects of BankAccountMonitored class and perform transactions.
    - Provide methods which will output:
        - the entire Actions LinkedList
        - only withdrawals
        - only deposits
        - The transaction in the order ( 1st transaction , 2nd transaction , 1st transaction)
    - Remove a transaction from the doubly LinkedList given the transaction ID.

### Appendix

```java
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
```

