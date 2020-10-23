## Lab 8

1. Create a class `LinkedList`
    - Create 5 Nodes with `Integer` objects in them. Link them to the LinkedList.
    - Give a method `int containsInteger(Integer)` which will take an `Integer` argument. It will search through the LinkedList and return the number of times the integer occurs in the Linked List.

2. Extend the `BankAccount` class to create a `BankAccountMonitored` class
    - This will have an `Action` class (see appendix).
    - This will also maintain a Linked List of Actions in every object.
    - Create objects of `BankAccountMonitored` class and perform transactions.
    - Provide methods which will output:
        - the entire Actions LinkedList
        - only withdrawals
        - only deposits

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


