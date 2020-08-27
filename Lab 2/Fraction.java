/** 
 * The class Fraction implements fractions and associated operations.
 * @author Ameya Thete
 */


public class Fraction {
    private int num, denom;

    public Fraction(int p, int q) {
        this.num = p;
        this.denom = q;
        reduce();
    }

    public Fraction(int n) {
        this(n, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public Fraction (Fraction other) {
        this.num = other.num;
        this.denom = other.denom;
    }

    /**
     * Reduces the fraction to its simplest form.
     * This is done by successively dividing the numerator and denominator by their common divisors
     * until further division is not possible.
     * Moreover, this method also corrects for redundant or misplaced negative signs. 
     */

    public void reduce() {
        for(int i = 2; i <= denom; i++) {
            if(this.num%i == 0 && this.denom%i == 0) {
                this.num = this.num/i;
                this.denom = this.denom/i;
            }
        }

        // Correct redundant negative signs

        if (this.num < 0 && this.denom < 0) {
            this.num = -1 * this.num;
            this.denom = -1 * this.denom;
        }

        // Correct misplaced negative signs in the denominator.

        else if(this.denom < 0) {
            this.denom = -1 * this.denom;
        }
    }

    /**
     * Adds the fraction f to the Fraction object calling the method. 
     * @param f
     */
    
    public void addFraction(Fraction f) {

        int newDenom = lcm(this.denom, f.denom);
        int newNum = (this.num*f.denom + f.num*this.denom);

        this.num = newNum;
        this.denom = newDenom;
        reduce();

    }

    /**
     * Subtracts the fraction f from the Fraction object calling the method.
     * @param f
     */

    public void subtractFraction(Fraction f) {

        Fraction temp = new Fraction(-f.num, f.denom);
        addFraction(temp);
        
    }

    /**
     * Multiplies the fraction f with the Fraction object calling the method.
     * @param f
     */

    public void multiplyFraction(Fraction f) {

        int newNum = this.num * f.num;
        int newDenom = this.denom * f.denom;

        this.num = newNum;
        this.denom = newDenom;
        reduce();
        
    }

    /**
     * Divides the Fraction object calling the method by the fraction f. 
     * @param f
     */

    public void divideFraction(Fraction f) {

        Fraction temp = new Fraction(f.denom, f.num);
        multiplyFraction(temp);
        
    }

    /**
     * Getter function for numerator
     * @return num
     */

    public int getNum() {
        return this.num;
    }

    /**
     * Getter function for denominator
     * @return denom 
     */

    public int getDenom() {
        return this.denom;
    }

    /**
     * Setter funtion for Numerator
     * @param num
     */

    public void setNum(int num) {
        this.num = num;
        reduce();
    }

    /**
     * Setter function for Denominator
     */

    public void setDenom(int denom) {
        this.denom = denom;
        reduce();
    }

    /**
     * Prints the fraction
     */

    public void print() {
        System.out.println(String.valueOf(this.num) + "/" + String.valueOf(this.denom));
    }

    /**
     * Static method to compute GCD. Used in the addFraction method.
     */

    private static int gcd(int a, int b) {

        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    /**
     * Static method to compute LCM. Used in the addFraction method.
     */

    private static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }

}