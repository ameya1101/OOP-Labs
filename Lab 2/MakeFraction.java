import java.util.Scanner;

public class MakeFraction {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter Numerator: ");
        int num = input.nextInt();
        int denom = 0;
        do {
            try {
                System.out.print("Enter Denominator: ");
                denom = input.nextInt();

                if(denom == 0) {
                    throw new ArithmeticException();
                }
            } catch (Exception e) {
                System.out.println("Denominator can not be zero. Please try again.");
            }
            
        }while (denom == 0);

        input.close();

        Fraction fraction = new Fraction(num, denom);

        System.out.println();
        System.out.print("Reduced Fraction: ");
        fraction.print();
    }
}