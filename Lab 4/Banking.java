public class Banking {
    public static void main(String[] args) {
        BankAccount person1 = new BankAccount("Ameya", "10, 42nd Street", 2000);
        BankAccount person2 = new BankAccount("Ajay", "10, 42nd Street", 5000);

        person1.withdraw(500);
        System.out.println(person1.toString());

        person2.deposit(210);
        System.out.println(person2.toString());

        BankAccount.transfer(person2, person1, 1000);
        System.out.println(person1.toString());
        System.out.println(person2.toString());

    }
}
