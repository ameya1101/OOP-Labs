## Lab 10

1. Extend the `BankAccount` class to create a `BankAccountMonitored` class:
    - This will have an `Action` class.
    - Add a new member variable to the Action class called `tid` (Rransaction ID). It will be private and of type `int`.
    - Maintain a LinkedList and HashMap in the BankAccountMonitored class.
    - The LinkedList will store the deposits and HashMap stores the withdrawals. In case of hashmap use the tid as the key.
    - Create objects of BankAccountMonitored class and perform transactions.
    - Provide methods which will output:
        - Withdrawal with the specified tid as a parameter. 
        - The entire deposits LinkedList
        - The entire withdrawal HashMap
        - Remove a deposit transaction from the linked list.

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

