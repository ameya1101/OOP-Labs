/**
 * The class Circle implements a circle.
 */
public class Circle {
    int x, y, radius;
    public static final double PI = 3.14;

    /**
     * A three-argument constructor that sets the values for x, y, and radius.
     * @param x
     * @param y
     * @param radius
     */
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    /**
     * A two-argument constructor
     * @param x
     * @param y
     */
    public Circle(int x, int y) {
        this(x, y, 0);
    }

    /**
     * A no-argument constructor
     */
    public Circle() {
        this(0, 0, 0);
    }

    /**
     * Getter method
     * @return int This returns the value of x
     */
    private int getX(){
        return this.x;
    }

    /**
     * Setter method
     * @param x value that x is initalised with
     */
    private void setX(int x){
        this.x = x;
    }

    /**
     * Getter method
     * @return int This returns the value of y
     */
    private int getY(){
        return this.y;
    }

    /**
     * Setter method
     * @param y value that y is initalised with
     */
    private void setY(int y){
        this.y = y;
    }

    /**
     * Getter method
     * @return int This returns the radius
     */
    public int getRadius(){
        return this.radius;
    }

    /**
     * Setter method
     * @param radius value that radius is initalised with
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Setter method
     * @param a value for x
     * @param b value for y
     * This method calls the setX and setY methods
     */
    public void setCenter(int a, int b) {
        setX(a);
        setY(b);
    }

    /**
     * Prints the center of the circle
     */
    public void getCenter() {
        System.out.print("(" + getX() + ", " + getY() + ")");
    }

    /**
     * Translates the center of the circle
     * @param a translates x by a
     * @param b translate y by b
     */
    public void translate(int a, int b) {
        setX(this.x + a);
        setY(this.y + b);
    }

    /**
     * Returns the area of the circle
     * @return the area
     */
    public double area() {
        return PI*this.radius*this.radius;
    }
    
}
